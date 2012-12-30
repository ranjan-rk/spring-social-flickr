package org.springframework.social.importer;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.social.flickr.api.Person;
import org.springframework.social.flickr.api.Photoset;
import org.springframework.social.flickr.api.PhotosetOperations;
import org.springframework.social.flickr.api.Photosets;
import org.springframework.social.flickr.api.impl.FlickrTemplate;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FlickrServicePhotoAlbumItemReader implements ItemReader<PhotoSet>, InitializingBean {

    private Logger logger = Logger.getLogger(getClass());
    private FlickrTemplate flickrTemplate;
    private Person person;
    private Queue<Photoset> photoSets = new ConcurrentLinkedQueue<Photoset>();
    private PhotosetOperations photosetOperations;
    private String userId;

    public FlickrServicePhotoAlbumItemReader(FlickrTemplate flickrTemplate) {
        this.flickrTemplate = flickrTemplate;
        this.photosetOperations = this.flickrTemplate.photosetOperations();
        this.person = this.flickrTemplate.peopleOperations().getPersonProfile();
        this.userId = person.getId();
    }

    @Override
    public PhotoSet read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Photoset og = photoSets.isEmpty() ? null : photoSets.remove();
        if (null == og)
            return null;

        return new PhotoSet(this.photosetOperations.getInfo(og.getId()), userId);
    }

    public void setFlickrTemplate(FlickrTemplate flickrTemplate) {
        this.flickrTemplate = flickrTemplate;
        this.photosetOperations = flickrTemplate.photosetOperations();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Photosets photosets = photosetOperations.getList(userId, null, null);
        for (Photoset ps : photosets.getPhotoset())
            this.photoSets.add(ps);
    }
}

