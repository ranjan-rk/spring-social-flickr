package org.springframework.social.flickr.api;

/**
 * The Interface PeopleOperations.
 *
 * @author HemantS
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
	
}
