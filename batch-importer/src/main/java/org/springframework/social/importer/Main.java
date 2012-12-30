package org.springframework.social.importer;

import org.apache.commons.lang.SystemUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.social.importer.config.ImporterConfiguration;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Properties;

/**
 * Entry point for the program. Reads in properties
 * from the Desktop (<CODE>~/Desktop/flickr.properties</CODE>), and uses them
 * to launch a <code>Job</code>.
 *
 * @author Josh Long
 */
public class Main {

    public static void main(String args[]) throws Throwable {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        registerPropertiesForFlickrConnection(applicationContext);
        applicationContext.register(ImporterConfiguration.class);
        applicationContext.refresh();
        applicationContext.start();

        FlickrImporter flickrImporter = applicationContext.getBean(FlickrImporter.class);
        Environment environment = applicationContext.getEnvironment();
        File output = new File(new File(SystemUtils.getUserHome(), "Desktop"), "flickr-output");

        if (!output.exists()) {
            Assert.isTrue(output.mkdirs(),
                    "there should be a directory to contain the " +
                            "output photos, but we could not create it!.");
        }

        String clientId = environment.getProperty("clientId"),
                clientSecret = environment.getProperty("clientSecret"),
                accessToken = environment.getProperty("accessToken"),
                accessTokenSecret = environment.getProperty("accessTokenSecret");

        flickrImporter.importPhotosToDirectory(accessToken, accessTokenSecret, clientId, clientSecret, output);


    }

    /**
     * I do this because I don't want to constantly specify the properties on the command line and I don't wan to check in
     * the properties on github in a public repository since I'm working with my own photos.
     * <p/>
     * Refer to the code below to see the properties required. They are fairly self explanatory.
     *
     * @param applicationContext the application context
     * @param <T>                the exception
     * @throws Throwable
     */
    private static <T extends AbstractApplicationContext> void registerPropertiesForFlickrConnection(T applicationContext) throws Throwable {

        File propertiesFile = new File(new File(SystemUtils.getUserHome(), "Desktop"), "flickr.properties");
        Assert.isTrue(propertiesFile.exists(), "the flickr.properties file must exist.");
        Resource propertiesResource = new FileSystemResource(propertiesFile);
        Properties properties = new Properties();
        properties.load(propertiesResource.getInputStream());

        PropertiesPropertySource mapPropertySource = new PropertiesPropertySource("flickr", properties);
        applicationContext.getEnvironment().getPropertySources().addLast(mapPropertySource);
    }


}

