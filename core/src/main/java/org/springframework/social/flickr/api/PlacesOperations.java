package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface PlacesOperations.
 *
 * @author HemantS
 */
public interface PlacesOperations {
	
	/**
	 * Find.
	 *
	 * @param query the query
	 * @return the places
	 */
	Places find(String query);

	/**
	 * Find by lat lon.
	 *
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @return the places
	 */
	Places findByLatLon(String lat, String lon, String accuracy);// accuracy,

	/**
	 * Gets the children with photos public.
	 *
	 * @param placeId the place id
	 * @param woeId the woe id
	 * @return the children with photos public
	 */
	Places getChildrenWithPhotosPublic(String placeId,
			String woeId);// placeId,woeId,

	/**
	 * Gets the info.
	 *
	 * @param placeId the place id
	 * @param woeId the woe id
	 * @return the info
	 */
	Place getInfo(String placeId, String woeId);// placeId,woeId,

	/**
	 * Gets the info by url.
	 *
	 * @param url the url
	 * @return the info by url
	 */
	Place getInfoByUrl(String url);

	/**
	 * Gets the place types.
	 *
	 * @return the place types
	 */
	Place_types getPlaceTypes();

	/**
	 * Gets the shape history.
	 *
	 * @param placeId the place id
	 * @param woeId the woe id
	 * @return the shape history
	 */
	Shapes getShapeHistory(String placeId, String woeId);// placeId,woeId,

	/**
	 * Gets the top places list.
	 *
	 * @param placeTypeId the place type id
	 * @param date the date
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @return the top places list
	 */
	Places getTopPlacesList(String placeTypeId, String date,
			String woeId, String placeId);// date,woeId,placeId,

	/**
	 * Places for bounding box.
	 *
	 * @param bbox the bbox
	 * @param placeType the place type
	 * @param placeTypeId the place type id
	 * @return the places
	 */
	Places placesForBoundingBox(String bbox, String placeType,
			String placeTypeId);// placeType,placeTypeId,

	/**
	 * Places for contacts.
	 *
	 * @param placeType the place type
	 * @param placeTypeId the place type id
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @param threshold the threshold
	 * @param contacts the contacts
	 * @param minUploadDate the min upload date
	 * @param maxUploadDate the max upload date
	 * @param minTakenDate the min taken date
	 * @param maxTakenDate the max taken date
	 * @return the places
	 */
	Places placesForContacts(String placeType, String placeTypeId,
			String woeId, String placeId, String threshold, String contacts,
			String minUploadDate, String maxUploadDate, String minTakenDate,
			String maxTakenDate);// placeType,placeTypeId,woeId,placeId,threshold,contacts,minUploadDate,maxUploadDate,minTakenDate,maxTakenDate,

	/**
	 * Places for tags.
	 *
	 * @param placeTypeId the place type id
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @param threshold the threshold
	 * @param tags the tags
	 * @param tagMode the tag mode
	 * @param machineTags the machine tags
	 * @param machineTagMode the machine tag mode
	 * @param minUploadDate the min upload date
	 * @param maxUploadDate the max upload date
	 * @param minTakenDate the min taken date
	 * @param maxTakenDate the max taken date
	 * @return the places
	 */
	Places placesForTags(String placeTypeId, String woeId,
			String placeId, String threshold, String tags, String tagMode,
			String machineTags, String machineTagMode, String minUploadDate,
			String maxUploadDate, String minTakenDate, String maxTakenDate);// woeId,placeId,threshold,tags,tagMode,machineTags,machineTagMode,minUploadDate,maxUploadDate,minTakenDate,maxTakenDate,

	/**
	 * Places for user.
	 *
	 * @param placeTypeId the place type id
	 * @param placeType the place type
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @param threshold the threshold
	 * @param minUploadDate the min upload date
	 * @param maxUploadDate the max upload date
	 * @param minTakenDate the min taken date
	 * @param maxTakenDate the max taken date
	 * @return the places
	 */
	Places placesForUser(String placeTypeId, String placeType,
			String woeId, String placeId, String threshold,
			String minUploadDate, String maxUploadDate, String minTakenDate,
			String maxTakenDate);// placeTypeId,placeType,woeId,placeId,threshold,minUploadDate,maxUploadDate,minTakenDate,maxTakenDate,

	/**
	 * Tags for place.
	 *
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @param minUploadDate the min upload date
	 * @param maxUploadDate the max upload date
	 * @param minTakenDate the min taken date
	 * @param maxTakenDate the max taken date
	 * @return the tags
	 */
	Tags tagsForPlace(String woeId, String placeId,
			String minUploadDate, String maxUploadDate, String minTakenDate,
			String maxTakenDate);// woeId,placeId,minUploadDate,maxUploadDate,minTakenDate,maxTakenDate,
}