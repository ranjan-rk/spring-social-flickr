package org.springframework.social.importer.config;


import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.social.flickr.api.impl.FlickrTemplate;
import org.springframework.social.importer.*;
import org.springframework.transaction.PlatformTransactionManager;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@ImportResource("/batch.xml")
public class BatchConfiguration {

    private boolean shouldCreateTables = false;

    @Bean
    public TaskExecutor taskExecutor() {
        return new ConcurrentTaskExecutor();
    }

    @Bean
    public TaskScheduler taskScheduler() {
        return new ConcurrentTaskScheduler();
    }

    @Bean
    @Inject
    public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {
        DataSourceInitializer dsi = new DataSourceInitializer();
        dsi.setDataSource(dataSource);
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        String[] scripts = "/batch_%s.sql,/photos_%s.sql".split(",");
        String scriptSuffix = "pg";
        for (String s : scripts) {
            ClassPathResource classPathResource = new ClassPathResource(String.format(s, scriptSuffix));
            resourceDatabasePopulator.addScript(classPathResource);
        }
        dsi.setDatabasePopulator(resourceDatabasePopulator);
        dsi.setEnabled(this.shouldCreateTables);
        return dsi;
    }

    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor() throws Exception {
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
        jobRegistryBeanPostProcessor.setJobRegistry(this.mapJobRegistry());
        return jobRegistryBeanPostProcessor;
    }

    @Bean
    @Inject
    public PlatformTransactionManager transactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

    @Bean
    public MapJobRegistry mapJobRegistry() throws Exception {
        return new MapJobRegistry();
    }

    @Bean
    @Inject
    public DataSource dataSource(Environment environment) {
        int port = environment.getProperty("dataSource.port", Integer.class);
        String pw = environment.getProperty("dataSource.password"),
                user = environment.getProperty("dataSource.user"),
                host = environment.getProperty("dataSource.host"),
                db = environment.getProperty("dataSource.db"),
                url = String.format("jdbc:postgresql://%s:%s/%s", host, port, db);
        Class<Driver> classOfDs = environment.getPropertyAsClass("dataSource.driverClassName", Driver.class);

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setPassword(pw);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setDriverClass(classOfDs);

        return dataSource;
    }

    @Bean
    @Inject
    public JobRepositoryFactoryBean jobRepository(DataSource ds, PlatformTransactionManager tx) throws Exception {
        JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();
        jobRepositoryFactoryBean.setDataSource(ds);
        jobRepositoryFactoryBean.setTransactionManager(tx);
        return jobRepositoryFactoryBean;
    }

    @Bean
    @Inject
    public SimpleJobLauncher jobLauncher(TaskExecutor te, JobRepository jobRepository) throws Exception {
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepository);
        simpleJobLauncher.setTaskExecutor(te);
        return simpleJobLauncher;
    }


    // ===================================================
    // STEP #1
    // ===================================================
    @Bean(name = "photoAlbumItemReader")
    @Inject
    @Scope(value = "step")
    public FlickrServicePhotoAlbumItemReader photoAlbumItemReader(
            @Value("#{jobParameters['accessToken']}") String at,
            @Value("#{jobParameters['accessTokenSecret']}") String atSecret,
            @Value("#{jobParameters['consumerKey']}") String consumerKey,
            @Value("#{jobParameters['consumerSecret']}") String consumerSecret
    ) throws Throwable {
        FlickrTemplate flickrTemplate = new FlickrTemplate(consumerKey, consumerSecret, at, atSecret);
        return new FlickrServicePhotoAlbumItemReader(flickrTemplate);
    }

    /**
     * basically loads the photo albums from the Flickr service
     * and loads them into the database
     * <p/>
     * <CODE>insert into photo_albums(title, user_id, description,  album_id, url) values( :t, :ui, :d, :a, :u )</CODE>
     */
    @Bean(name = "photoAlbumItemWriter")
    @Inject
    public JdbcBatchItemWriter<PhotoSet> writer(DataSource ds) {


        String upsertPhotoAlbumsSql =
                "with new_values (title, user_id, description,  album_id, url, count_photos, count_videos) as ( " +
                        " values (  :t, :ui, :d, :a, :u, :cp, :cv )  ), " +
                        "upsert as " +
                        "( update photo_albums p set  count_photos=nv.count_photos,count_videos=nv.count_videos, title = nv.title, user_id = nv.user_id, description = nv.description, album_id = nv.album_id, url = nv.url " +
                        "    FROM new_values nv WHERE p.album_id = nv.album_id RETURNING p.*  ) " +
                        "INSERT INTO photo_albums (title, user_id, description,  album_id, url, count_photos, count_videos)  " +
                        "SELECT nv.* FROM new_values nv " +
                        "WHERE NOT EXISTS (SELECT 1 FROM upsert up WHERE up.album_id = nv.album_id )";

        JdbcBatchItemWriter<PhotoSet> jdbcBatchItemWriter = new JdbcBatchItemWriter<PhotoSet>();
        jdbcBatchItemWriter.setSql(upsertPhotoAlbumsSql);
        jdbcBatchItemWriter.setDataSource(ds);
        jdbcBatchItemWriter.setAssertUpdates(false); // were doing upserts, so these writes may never take effect
        jdbcBatchItemWriter.setItemSqlParameterSourceProvider(new ItemSqlParameterSourceProvider<PhotoSet>() {
            @Override
            public SqlParameterSource createSqlParameterSource(PhotoSet item) {
                return new MapSqlParameterSource()
                        .addValue("t", item.getTitle())
                        .addValue("d", item.getDescription())
                        .addValue("ui", item.getUserId())
                        .addValue("a", item.getId())
                        .addValue("cv", item.getCountOfVideos(), Types.INTEGER)
                        .addValue("cp", item.getCountOfPhotos(), Types.INTEGER)
                        .addValue("u", item.getUrl());
            }
        });
        return jdbcBatchItemWriter;
    }


    // ===================================================
    // STEP #2
    // ===================================================


    /**
     * this will return all the photo_albums from the database, but
     * it's not going to be registered in a step, instead it'll be delegated to
     * from another {@link org.springframework.batch.item.ItemReader}
     * which in turn will load the <em>photos</em> for each album
     * and <em>that</em> is what's written by the step's {@link org.springframework.batch.item.ItemWriter}.
     *
     * @param dataSource datasource
     * @return an item reader
     */
    @Bean(name = "photoSetJdbcCursorItemReader")
    @Inject
    public JdbcCursorItemReader<PhotoSet> readPhotoAlbumsFromDatabaseItemReader(DataSource dataSource) {

        JdbcCursorItemReader<PhotoSet> photoSetJdbcCursorItemReader = new JdbcCursorItemReader<PhotoSet>();
        photoSetJdbcCursorItemReader.setRowMapper(new RowMapper<PhotoSet>() {
            @Override
            public PhotoSet mapRow(ResultSet resultSet, int i) throws SQLException {
                return new PhotoSet(
                        resultSet.getInt("count_videos"),
                        resultSet.getInt("count_photos"),
                        resultSet.getString("url"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("album_id"),
                        resultSet.getString("user_id"));
            }
        });
        photoSetJdbcCursorItemReader.setSql("select * from photo_albums");
        photoSetJdbcCursorItemReader.setDataSource(dataSource);
        return photoSetJdbcCursorItemReader;

    }

    @Bean(name = "delegatingFlickrPhotoAlbumPhotoItemReader")
    @Inject
    @Scope(value = "step")
    public DelegatingFlickrPhotoAlbumPhotoItemReader delegatingFlickrPhotoAlbumPhotoItemReader(
            @Qualifier("photoSetJdbcCursorItemReader") JdbcCursorItemReader<PhotoSet> photoSetJdbcCursorItemReader,
            @Value("#{jobParameters['accessToken']}") String accessToken,
            @Value("#{jobParameters['accessTokenSecret']}") String atSecret,
            @Value("#{jobParameters['consumerKey']}") String consumerKey,
            @Value("#{jobParameters['consumerSecret']}") String consumerSecret) {
        FlickrTemplate flickrTemplate = new FlickrTemplate(consumerKey, consumerSecret, accessToken, atSecret);
        return new DelegatingFlickrPhotoAlbumPhotoItemReader(flickrTemplate, photoSetJdbcCursorItemReader);
    }

    @Bean(name = "photoDetailItemWriter")
    @Inject
    public JdbcBatchItemWriter<Photo> photoDetailItemWriter(DataSource ds) {

        String upsertSql =
                "with new_values (photo_id, url, comments, album_id) as ( " +
                        " values (  :p, :u, :c, :a)  ), " +
                        "upsert as " +
                        "( update photos p set  photo_id=nv.photo_id, url=nv.url,  comments= nv.comments,   album_id= nv.album_id   " +
                        "    FROM new_values nv WHERE p.photo_id = nv.photo_id RETURNING p.*  ) " +
                        " insert into photos( photo_id,url,comments,album_id)   " +
                        "SELECT nv.* FROM new_values nv " +
                        "WHERE NOT EXISTS (SELECT 1 FROM upsert up WHERE up.photo_id = nv.photo_id )";


        JdbcBatchItemWriter<Photo> photoDetailJdbcBatchItemWriter = new JdbcBatchItemWriter<Photo>();
        photoDetailJdbcBatchItemWriter.setDataSource(ds);
        photoDetailJdbcBatchItemWriter.setAssertUpdates(false);
        photoDetailJdbcBatchItemWriter.setSql(upsertSql);
        photoDetailJdbcBatchItemWriter.setItemSqlParameterSourceProvider(new ItemSqlParameterSourceProvider<Photo>() {
            @Override
            public SqlParameterSource createSqlParameterSource(Photo item) {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("p", item.getId());
                params.put("u", item.getUrl());
                params.put("c", item.getComments());
                params.put("a", item.getAlbumId());
                return new MapSqlParameterSource(params);
            }
        });
        return photoDetailJdbcBatchItemWriter;
    }

    // ===================================================
    // STEP #3
    // ===================================================

    /**
     * the final step is to read the database records, then download the file
     */

    @Bean
    @Inject
    public JdbcCursorItemReader<Photo> photoDetailItemReader(DataSource dataSource) {
        JdbcCursorItemReader<Photo> photoSetJdbcCursorItemReader = new JdbcCursorItemReader<Photo>();
        photoSetJdbcCursorItemReader.setRowMapper(new RowMapper<Photo>() {
            @Override
            public Photo mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Photo(
                        resultSet.getString("photo_id"),
                        resultSet.getString("url"),
                        resultSet.getString("title"),
                        resultSet.getString("comments"),
                        resultSet.getString("album_id")
                );
            }
        });
        photoSetJdbcCursorItemReader.setSql("select * from photos ");
        photoSetJdbcCursorItemReader.setDataSource(dataSource);
        return photoSetJdbcCursorItemReader;
    }

    @Inject
    @Scope("step")
    @Bean(name = "photoDownloadingItemWriter")
    public ItemWriter<Photo> photoDownloadingItemWriter(
            @Value("#{jobParameters['output']}") String outputPath,
            @Value("#{jobParameters['accessToken']}") String accessToken,
            @Value("#{jobParameters['accessTokenSecret']}") String atSecret,
            @Value("#{jobParameters['consumerKey']}") String consumerKey,
            @Value("#{jobParameters['consumerSecret']}") String consumerSecret) {
        FlickrTemplate flickrTemplate = new FlickrTemplate(consumerKey, consumerSecret, accessToken, atSecret);
        flickrTemplate.getRestTemplate().getMessageConverters().add(new BufferedImageHttpMessageConverter());
        return new PhotoDownloadingItemWriter(flickrTemplate, new File(outputPath));
    }
}
