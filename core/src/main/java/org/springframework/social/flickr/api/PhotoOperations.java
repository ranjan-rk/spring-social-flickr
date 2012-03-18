package org.springframework.social.flickr.api;


// TODO: Auto-generated Javadoc
/**
 * The Interface PhotoOperations.
 */
public interface PhotoOperations {
	
	/**
	 * Adds the tags.
	 *
	 * @param photoId the photo id
	 * @param tagList the tag list
	 * @return true, if successful
	 */
	boolean addTags(String photoId,String[]  tagList);
	
	/**
	 * Adds the tags.
	 *
	 * @param photoId the photo id
	 * @param tags comma separated tags
	 * @return true, if successful
	 */
	boolean addTags(String photoId,String tags);
}
