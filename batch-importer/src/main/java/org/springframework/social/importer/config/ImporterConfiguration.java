package org.springframework.social.importer.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.social.importer.FlickrImporter;

import javax.inject.Inject;


@Configuration
@ImportResource("/batch.xml")
@Import(BatchConfiguration.class)
public class ImporterConfiguration {

    @Inject
    @Qualifier("flickrImportJob")
    private Job importFlickrPhotosJob;

    @Inject
    private JobLauncher jobLauncher;

    @Bean
    @Inject
    public FlickrImporter importer(TaskScheduler taskScheduler) {
        return new FlickrImporter(this.importFlickrPhotosJob, this.jobLauncher, taskScheduler);
    }

}