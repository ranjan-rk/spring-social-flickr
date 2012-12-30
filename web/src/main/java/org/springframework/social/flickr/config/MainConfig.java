package org.springframework.social.flickr.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.flickr.UploadItem;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
@ComponentScan(basePackageClasses = {UploadItem.class}, excludeFilters = {@Filter(Configuration.class)})
@PropertySource("classpath:/org/springframework/social/flickr/config/flickr.properties")
public class MainConfig {
/*

    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource() {
        EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
        factory.setDatabaseName("spring-social-flickr");
        factory.setDatabaseType(EmbeddedDatabaseType.H2);
        factory.setDatabasePopulator(databasePopulator());
        return factory.getDatabase();
    }
*/


    @Bean(destroyMethod = "close")
    @Inject
    public DataSource dataSource(Environment environment) throws Exception {
        String user = environment.getProperty("dataSource.user"),
                pw = environment.getProperty("dataSource.password"),
                host = environment.getProperty("dataSource.host");
        int port = Integer.parseInt(environment.getProperty("dataSource.port"));
        String db = environment.getProperty("dataSource.db");
        Class<Driver> driverClass = environment.getPropertyAsClass("dataSource.driverClassName", Driver.class);
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(driverClass.getName());
        basicDataSource.setPassword(pw);
        String url = String.format("jdbc:postgresql://%s:%s/%s", host, port, db);
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(user);
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxActive(10);

        return basicDataSource;
    }

    @Bean
    public DatabasePopulator databasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("JdbcUsersConnectionRepository.sql", JdbcUsersConnectionRepository.class));
        return populator;
    }
}
