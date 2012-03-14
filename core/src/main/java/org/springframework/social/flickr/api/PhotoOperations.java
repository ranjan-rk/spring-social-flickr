package org.springframework.social.flickr.api;


/**
 * The Interface PhotoOperations.
 */
public interface PhotoOperations {
	boolean addTags(String photoId,String[]  tagList);
}
