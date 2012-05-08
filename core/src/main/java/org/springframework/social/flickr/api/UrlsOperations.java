package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface UrlsOperations.
 *
 * @author HemantS
 */
public interface UrlsOperations {
	
	/**
	 * Gets the group.
	 *
	 * @param apiKey the api key
	 * @param groupId the group id
	 * @return the group
	 */
	Group getGroup(String apiKey, String groupId);

	/**
	 * Gets the user photos.
	 *
	 * @param apiKey the api key
	 * @param userId the user id
	 * @return the user photos
	 */
	User getUserPhotos(String apiKey, String userId);// userId,

	/**
	 * Gets the user profile.
	 *
	 * @param apiKey the api key
	 * @param userId the user id
	 * @return the user profile
	 */
	User getUserProfile(String apiKey, String userId);// userId,

	/**
	 * Lookup gallery.
	 *
	 * @param apiKey the api key
	 * @param url the url
	 * @return the gallery
	 */
	Gallery lookupGallery(String apiKey, String url);

	/**
	 * Lookup group.
	 *
	 * @param apiKey the api key
	 * @param url the url
	 * @return the group
	 */
	Group lookupGroup(String apiKey, String url);

	/**
	 * Lookup user.
	 *
	 * @param apiKey the api key
	 * @param url the url
	 * @return the user
	 */
	User lookupUser(String apiKey, String url);
}