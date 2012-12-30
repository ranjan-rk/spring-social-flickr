package org.springframework.social.importer;

import org.apache.commons.lang.StringUtils;
import org.springframework.social.flickr.api.Photoset;

/**
 * @author Josh Long
 */
public class PhotoSet {


    private String description, url, id, title, userId;

    private int countOfVideos = 0, countOfPhotos = 0;

    private void setup(int cv, int cp, String url, String title, String description, String id, String userId) {
        this.userId = userId;
        this.countOfPhotos = cp;
        this.id = id;
        this.description = StringUtils.isEmpty(description) ? "" : description;
        this.url = url;
        this.title = title;
        this.countOfVideos = cv;
    }

    public PhotoSet(int cv, int cp, String url, String title, String description, String id, String userId) {
        setup(cv, cp, url, title, description, id, userId);
    }

    public PhotoSet(Photoset photoset, String userId) {
        setup(photoset.getCountVideos(), photoset.getCountPhotos(),
                photoset.getUrl(), photoset.getTitle(), photoset.getDescription(), photoset.getId(), userId);
    }

    public String getDescription() {
        return description;
    }

    public int getCountOfPhotos() {
        return countOfPhotos;
    }

    public int getCountOfVideos() {
        return countOfVideos;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }
}
