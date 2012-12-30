package org.springframework.social.importer;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.Lifecycle;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * component that manages Spring Batch jobs to import photos from Flickr and
 * downloads them to a local cache where they can be used.
 *
 * @author Josh Long
 */
public class FlickrImporter implements Lifecycle {

    private volatile JobLauncher jobLauncher;

    private volatile Job importFlickrPhotosJob;

    private volatile Map<File, JobExecution> mapOfFilesToRunningJobs = new ConcurrentHashMap<File, JobExecution>();

    private volatile TaskScheduler scheduler;

    public FlickrImporter(Job importFlickrPhotosJob, JobLauncher jobLauncher, TaskScheduler s) {
        this.importFlickrPhotosJob = importFlickrPhotosJob;
        this.jobLauncher = jobLauncher;
        this.scheduler = s;
    }

    /**
     * call this to kick off the import job.
     *
     * @param file the directory to which the imported photos should be written
     */
    public void importPhotosToDirectory(
            String at,
            String atSecret,
            String consumerKey,
            String consumerSecret,
            File file) throws Throwable {

        Assert.notNull(file, "you must provide a non-null File object.");
        Assert.isTrue(file.exists(), "the " + file.getAbsolutePath() + " must exist.");
        Assert.isTrue(file.canWrite(), "we must be able to write to " + file.getAbsolutePath() + ".");

        JobParameters jp = new JobParametersBuilder()
                .addString("accessToken", at)
                .addString("accessTokenSecret", atSecret)
                .addString("consumerKey", consumerKey)
                .addString("consumerSecret", consumerSecret)
                .addString("output", file.getAbsolutePath())
                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(this.importFlickrPhotosJob, jp);

        this.mapOfFilesToRunningJobs.put(file, jobExecution);
    }

    /**
     * tests to see if any jobs can be removed and, if so, does.
     * <p/>
     * todo we should re-work this in terms of {@link java.lang.ref.WeakReference weak references} and {@link java.util.WeakHashMap weak hash map}.
     */
    public static class JobCleanupRunnable implements Runnable {

        private volatile Map<File, JobExecution> executionMap;

        public JobCleanupRunnable(Map<File, JobExecution> ex) {
            this.executionMap = ex;
        }

        @Override
        public void run() {
            for (Map.Entry<File, JobExecution> e : executionMap.entrySet())
                if (!e.getValue().isRunning())
                    executionMap.remove(e.getKey());

        }
    }


    @Override
    public void start() {
        // we don't have a particular obligation to do anything here..
        if (null == this.scheduler) {
            this.scheduler = new ConcurrentTaskScheduler();
        }
        this.scheduler.scheduleAtFixedRate(new JobCleanupRunnable(this.mapOfFilesToRunningJobs), 1000);
    }

    @Override
    public void stop() {
        for (JobExecution jobExecution : this.mapOfFilesToRunningJobs.values()) {
            jobExecution.stop();
        }

    }

    @Override
    public boolean isRunning() {
        return this.mapOfFilesToRunningJobs.size() > 0;
    }
}
