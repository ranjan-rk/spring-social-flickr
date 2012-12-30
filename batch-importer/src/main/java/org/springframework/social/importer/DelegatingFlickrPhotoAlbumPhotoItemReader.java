package org.springframework.social.importer;

import org.springframework.batch.item.*;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.social.flickr.api.MediaEnum;
import org.springframework.social.flickr.api.PhotoSizeEnum;
import org.springframework.social.flickr.api.Photoset;
import org.springframework.social.flickr.api.impl.FlickrTemplate;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Simple Item reader that reads all the photos for a given {@link PhotoSet}
 * and then passes that information onto an {@link org.springframework.batch.item.ItemWriter}.
 *
 * @author Josh Long
 */
public class DelegatingFlickrPhotoAlbumPhotoItemReader implements ItemReader<Photo>, ItemStream {

    private JdbcCursorItemReader<PhotoSet> masterAlbumDelegate;
    private FlickrTemplate flickrTemplate;
    private PhotoSet photoSet;
    private Queue<org.springframework.social.flickr.api.Photo> photoCollection = new ConcurrentLinkedQueue<org.springframework.social.flickr.api.Photo>();

    public DelegatingFlickrPhotoAlbumPhotoItemReader(FlickrTemplate flickrTemplate, JdbcCursorItemReader<PhotoSet> masterAlbumDelegate) {
        this.flickrTemplate = flickrTemplate;
        this.masterAlbumDelegate = masterAlbumDelegate;
    }

    @Override
    public Photo read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        // if theres nothing in the photo collection...
        if (photoCollection.isEmpty() ) {

            // then load a PhotoSet
            photoSet = this.masterAlbumDelegate.read();

            // if theres no PhotoSet, then we're done, no more photos to read
            if (null == photoSet)
                return null;

            // if there is a PhotoSet, then load its PhotoDetails
            Photoset photosSet = flickrTemplate.photosetOperations().getPhotos(photoSet.getId(), null, null, null, null, MediaEnum.PHOTOS);
            for (org.springframework.social.flickr.api.Photo p : photosSet.getPhoto()) {
                photoCollection.add(p);
            }
        }

        // if were here, then the photoCollection might still be empty because it might be a flickr album with nothing in it
        org.springframework.social.flickr.api.Photo photo = photoCollection.isEmpty() ? null : photoCollection.remove();
        if (null == photo)
            return null;

        // downloads the 'large' image
        return new Photo(photo.getId(), photo.getUrl(PhotoSizeEnum.b), photo.getTitle(), null, photoSet.getId());
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {

        masterAlbumDelegate.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        masterAlbumDelegate.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        masterAlbumDelegate.close();
    }
}