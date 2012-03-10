package org.springframework.social.flickr.api;

/**
 * The Interface PeopleOperations.
 *
 * @author HemantS
 */
/*TODO:Pending things in getPhotos( parameters)
 * 		Pending completely getPhotosOf
 */
public interface PeopleOperations {
	
	/**
	 * Retrieves the authenticated user's Flickr ID.
	 *
	 * @return the profile id
	 */
	String getProfileId();
	
	/**
	 * Retrieves the authenticated user's Flickr profile details.
	 *
	 * @return the person profile
	 */
	Person getPersonProfile();
	
	/**
	 * Retrieves a specific user's Flickr profile details.
	 * Note that this method does not require authentication.
	 *
	 * @param userId the user id
	 * @return the person profile
	 */
	Person getPersonProfile(String userId);
	
	/**
	 * Gets the user by email.
	 * Note that this method does not require authentication.
	 * 
	 * @param email the email
	 * @return the user by email
	 */
	User getUserByEmail(String email);
	
	/**
	 * Gets the user by user name.
	 * Note that this method does not require authentication.
	 * @param userName the user name
	 * @return the user by user name
	 */
	User getUserByUserName(String userName);
	
	/**
	 * Gets the groups.
	 * Note that this method require read permission.
	 * @param userId the user id
	 * @return the groups
	 */
	Groups getGroups(String userId);
	
	/**
	 * Gets the public groups.
	 *
	 * @param userId the user id
	 * @return the public groups
	 */
	Groups getPublicGroups(String userId);
	
	/**
	 * Gets the photos.
	 * Only photos visible to the calling user will be returned
	 * @param userId the user id TODO: parameter need to change,  provide all option available
	 * @return the photos
	 */
	Photos getPhotos(String userId);
	
	/**
	 * Gets the public photos.
	 *
	 * @param userId the user id
	 * @return the public photos
	 */
	Photos getPublicPhotos(String userId);
	
}
