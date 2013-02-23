package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface GroupsOperations.
 *
 * @author HemantS
 */
public interface GroupsOperations {
	
	/**
	 * TODO: did not understand the purpose of this function
	 * Browse.
	 *
	 * @param apiKey the api key
	 * @param catId the cat id
	 * @return the category
	 */
	Category browse(String catId);// catId,

	/**
	 * Search.
	 *
	 * @param apiKey the api key
	 * @param text the text
	 * @param perPage the per page
	 * @param page the page
	 * @return the groups
	 */
	Groups search(String text, String perPage, String page);// perPage,page,
	
	/**
	 * Gets the info.
	 *
	 * @param apiKey the api key
	 * @param groupId the group id
	 * @param lang the lang
	 * @return the info
	 */
	Group2 getInfo(String groupId, String lang);
	
	/**
	 * Join.
	 *
	 * @param groupId the group id
	 * @param acceptRules the accept rules
	 * @return true, if successful
	 */
	boolean join(String groupId ,String acceptRules );
	
	/**
	 * Join request.
	 *
	 * @param groupId the group id
	 * @param message the message
	 * @param acceptRules the accept rules
	 * @return true, if successful
	 */
	boolean joinRequest(String groupId, String message, String acceptRules);
	
	/**
	 * Leave.
	 *
	 * @param groupId the group id
	 * @param delete_photos the delete_photos
	 * @return true, if successful
	 */
	boolean leave(String groupId ,String deletePhotos);
}