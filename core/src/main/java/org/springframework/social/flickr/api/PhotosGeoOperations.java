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
	 * TODO: pending didn't understand completely
	 *
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @param placeId the place id
	 * @param woeId the woe id
	 */
	void batchCorrectLocation(String lat, String lon,
			String accuracy, String placeId, String woeId);// placeId,woeId,

	/**
	 * Correct location.
	 *
	 * @param photoId the photo id
	 * @param placeId the place id
	 * @param woeId the woe id
	 * @param foursquareId the foursquare id
	 * @return true, if successful
	 */
	boolean correctLocation(String photoId, String placeId,
			String woeId,String foursquareId);// placeId,woeId,

	/**
	 * Gets the location.
	 *
	 * @param photoId the photo id
	 * @return the location
	 */
	Photo getLocation(String photoId);

	/**
	 * Gets the perms.
	 *
	 * @param photoId the photo id
	 * @return the perms
	 */
	Perms getPerms(String photoId);

	/**
	 * Photos for location.
	 *
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the photos
	 */
	Photos photosForLocation(String lat, String lon,
			String accuracy, String extras, String perPage, String page);// accuracy,extras,perPage,page,

	/**
	 * Removes the location.
	 *
	 * @param photoId the photo id
	 */
	boolean removeLocation(String photoId);

	/**
	 * Sets the context.
	 *
	 * @param photoId the photo id
	 * @param context the context
	 */
	boolean setContext(String photoId, String context);

	/**
	 * Sets the location.
	 *
	 * @param photoId the photo id
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @param context the context
	 */
	boolean setLocation(String photoId, String lat, String lon,
			String accuracy, String context);// accuracy,context,

	/**
	 * Sets the perms.
	 *
	 * @param isPublic the is public
	 * @param isContact the is contact
	 * @param isFriend the is friend
	 * @param isFamily the is family
	 * @param photoId the photo id
	 */
	boolean setPerms(String isPublic, String isContact,
			String isFriend, String isFamily, String photoId);
}