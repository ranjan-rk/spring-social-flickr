package org.springframework.social.importer;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.social.flickr.api.impl.FlickrTemplate;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.logging.Logger;

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
    }

    @Override
    public void write(List<? extends Photo> items) throws Exception {
        for (Photo p : items) {
            String url = p.getUrl();
            String ext = extension(url);
            File output = new File(forPhoto(p), p.getId() + ext);
            if (!output.exists()) {
                logger.info("downloading "+ url + " to "+output.getAbsolutePath()+".");
                BufferedImage bi = this.restTemplate.getForObject(url, BufferedImage.class);
                ImageIO.write(bi, ext.substring(1), output);
            }

        }
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