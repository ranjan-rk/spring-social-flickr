package org.springframework.social.importer;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.social.flickr.api.impl.FlickrTemplate;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

/**
 * Downloads files from Flickr
 *
 * @author Josh Long
 */
public class PhotoDownloadingItemWriter implements ItemWriter<Photo> {
    private Log logger = LogFactory.getLog(getClass());

    private File outputDirectory; // should come from job parameters

    private FlickrTemplate flickrTemplate;

    private RestTemplate restTemplate;

    public PhotoDownloadingItemWriter(FlickrTemplate flickrTemplate, File outputDirectory) {
        this.outputDirectory = outputDirectory;
        this.flickrTemplate = flickrTemplate;
        this.restTemplate = flickrTemplate.getRestTemplate(); // this is used to handle downloading the images in an OAuth-complaint way
        Assert.notNull(flickrTemplate, "the flickrTemplate must be non-null");
        Assert.notNull(restTemplate, "the rest template must be non-null");
        Assert.notNull(outputDirectory, "you must specify a non-null output directory");
        Assert.isTrue(outputDirectory.exists(), "the output directory must exist");
    }

    @Override
    public void write(List<? extends Photo> items) throws Exception {
        for (Photo p : items) {
            String url = p.getUrl();
            String ext = extension(url);
            File output = new File(forPhoto(p), p.getId() + ext);
            if (shouldFileBeDownloaded(output)) {
                logger.info("downloading " + url + " to " + output.getAbsolutePath() + ".");
                BufferedImage bi = this.restTemplate.getForObject(url, BufferedImage.class);
                ImageIO.write(bi, ext.substring(1), output);
            } else {
                logger.info("not downloading " + url + " to " + output.getAbsolutePath() + " because the file already exists.");
            }
        }
    }

    protected boolean shouldFileBeDownloaded(File output) {
        if (output.exists()) {
            if (output.length() == 0) {
                logger.info("the file " + output.getAbsolutePath() + " exists, but it's 0 bytes in length, so we're removing it.");
                output.delete();
            }
        }
        return !(output.exists() && output.length() > 0); // if  it exists and the size is > 0b, then dont download it
    }

    protected String extension(String url) {
        assert url != null;
        if (!StringUtils.isEmpty(url)) {
            return url.substring(url.lastIndexOf("."));
        }
        return null;
    }

    protected File forPhoto(Photo p) {
        File outputForAlbum = new File(this.outputDirectory, p.getAlbumId());
        if (!outputForAlbum.exists()) outputForAlbum.mkdirs();
        return outputForAlbum;
    }

}