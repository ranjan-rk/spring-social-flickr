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
	 * @param photoId the photo id
	 * @param groupId the group id
	 */
	boolean add(String photoId, String groupId);

	/**
	 * TODO : need to handle in different way
	 * Gets the context.
	 * 
	 * @param photoId the photo id
	 * @param groupId the group id
	 * @return the context
	 */
	Prevphoto getContext(String photoId, String groupId);

	/**
	 * Gets the groups.
	 *
	 * @param page the page
	 * @param perPage the per page
	 * @return the groups
	 */
	Groups getGroups(String page, String perPage);// page,perPage,

	/**
	 * Gets the photos.
	 *
	 * @param groupId the group id
	 * @param tags the tags
	 * @param userId the user id
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the photos
	 */
	Photos getPhotos(String groupId, String tags, String userId,
			String extras, String perPage, String page);// tags,userId,extras,perPage,page,

	/**
	 * Removes the.
	 *
	 * @param photoId the photo id
	 * @param groupId the group id
	 */
	boolean remove(String photoId, String groupId);
}