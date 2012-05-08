package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface PhotosGeoOperations.
 *
 * @author HemantS
 */
public interface PhotosGeoOperations {
	
	/**
	 * Batch correct location.
	 *
	 * @param apiKey the api key
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @param placeId the place id
	 * @param woeId the woe id
	 */
	void batchCorrectLocation(String apiKey, String lat, String lon,
			String accuracy, String placeId, String woeId);// placeId,woeId,

	/**
	 * Correct location.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param placeId the place id
	 * @param woeId the woe id
	 */
	void correctLocation(String apiKey, String photoId, String placeId,
			String woeId);// placeId,woeId,

	/**
	 * Gets the location.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @return the location
	 */
	Photo getLocation(String apiKey, String photoId);

	/**
	 * Gets the perms.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @return the perms
	 */
	Perms getPerms(String apiKey, String photoId);

	/**
	 * Photos for location.
	 *
	 * @param apiKey the api key
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the photos
	 */
	Photos photosForLocation(String apiKey, String lat, String lon,
			String accuracy, String extras, String perPage, String page);// accuracy,extras,perPage,page,

	/**
	 * Removes the location.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 */
	void removeLocation(String apiKey, String photoId);

	/**
	 * Sets the context.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param context the context
	 */
	void setContext(String apiKey, String photoId, String context);

	/**
	 * Sets the location.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @param context the context
	 */
	void setLocation(String apiKey, String photoId, String lat, String lon,
			String accuracy, String context);// accuracy,context,

	/**
	 * Sets the perms.
	 *
	 * @param apiKey the api key
	 * @param isPublic the is public
	 * @param isContact the is contact
	 * @param isFriend the is friend
	 * @param isFamily the is family
	 * @param photoId the photo id
	 */
	void setPerms(String apiKey, String isPublic, String isContact,
			String isFriend, String isFamily, String photoId);
}