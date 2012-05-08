package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface GroupsPoolsOperations.
 */
/**
 * @author HemantS
 *
 */
public interface GroupsPoolsOperations {
	
	/**
	 * Adds the.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param groupId the group id
	 */
	void add(String apiKey, String photoId, String groupId);

	/**
	 * Gets the context.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param groupId the group id
	 * @return the context
	 */
	Prevphoto getContext(String apiKey, String photoId, String groupId);

	/**
	 * Gets the groups.
	 *
	 * @param apiKey the api key
	 * @param page the page
	 * @param perPage the per page
	 * @return the groups
	 */
	Groups getGroups(String apiKey, String page, String perPage);// page,perPage,

	/**
	 * Gets the photos.
	 *
	 * @param apiKey the api key
	 * @param groupId the group id
	 * @param tags the tags
	 * @param userId the user id
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the photos
	 */
	Photos getPhotos(String apiKey, String groupId, String tags, String userId,
			String extras, String perPage, String page);// tags,userId,extras,perPage,page,

	/**
	 * Removes the.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param groupId the group id
	 */
	void remove(String apiKey, String photoId, String groupId);
}