package org.springframework.social.importer;


import org.springframework.social.flickr.api.PhotoDetail;
import org.springframework.social.flickr.api.Url;

/**
 * wrapper for SS Flickr's {@link PhotoDetail photo details} object.
 *
 * @author Josh Long
 */
public class Photo {

    private String url, id, title, comments, albumId;

    protected void setup(String id, String url, String title, String comments, String albumId) {
        this.url = url;
        this.id = id;
        this.title = title;
        this.comments = comments;
        this.albumId = albumId;
    }

    public Photo(String id, String url, String title, String comments, String albumId) {
        setup(id, url, title, comments, albumId);
    }

    public Photo(PhotoDetail pd, String albumId) {
        Url u = pd.getUrls().getUrl().iterator().next();
        setup(pd.getId(), u.get_content(), pd.getTitle(), pd.getComments(), albumId);
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public String getComments() {
        return comments;
    }


    public String getAlbumId() {
        return albumId;
    }


}
