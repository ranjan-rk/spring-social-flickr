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
	
	/**
	 * Delete the photoT
	 * This method require 'delete' permission
	 * @param photoId the photo id
	 * @return true, if successful
	 */
	boolean delete(String photoId);
	
	/**
	 * Gets the recent.
	 *  
	 * @param perPage the per page
	 * @param page the page
	 * @param List of extras
	 * @return the recent
	 */
	Photos getRecent(String perPage, String page , String[] extras);
	
	/**
	 * Returns the list of people who have favorited a given photo.
	 *
	 * @param perPage the per page
	 * @param page the page
	 * @param photoId the photo id
	 * @return the favorites
	 */
	Photo getFavorites(String perPage, String page,String photoId);
	
}
