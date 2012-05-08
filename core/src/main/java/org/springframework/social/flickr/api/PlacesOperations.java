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
	 * @param apiKey the api key
	 * @param query the query
	 * @return the places
	 */
	Places find(String apiKey, String query);

	/**
	 * Find by lat lon.
	 *
	 * @param apiKey the api key
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @return the places
	 */
	Places findByLatLon(String apiKey, String lat, String lon, String accuracy);// accuracy,

	/**
	 * Gets the children with photos public.
	 *
	 * @param apiKey the api key
	 * @param placeId the place id
	 * @param woeId the woe id
	 * @return the children with photos public
	 */
	Places getChildrenWithPhotosPublic(String apiKey, String placeId,
			String woeId);// placeId,woeId,

	/**
	 * Gets the info.
	 *
	 * @param apiKey the api key
	 * @param placeId the place id
	 * @param woeId the woe id
	 * @return the info
	 */
	Place getInfo(String apiKey, String placeId, String woeId);// placeId,woeId,

	/**
	 * Gets the info by url.
	 *
	 * @param apiKey the api key
	 * @param url the url
	 * @return the info by url
	 */
	Place getInfoByUrl(String apiKey, String url);

	/**
	 * Gets the place types.
	 *
	 * @param apiKey the api key
	 * @return the place types
	 */
	Place_types getPlaceTypes(String apiKey);

	/**
	 * Gets the shape history.
	 *
	 * @param apiKey the api key
	 * @param placeId the place id
	 * @param woeId the woe id
	 * @return the shape history
	 */
	Shapes getShapeHistory(String apiKey, String placeId, String woeId);// placeId,woeId,

	/**
	 * Gets the top places list.
	 *
	 * @param apiKey the api key
	 * @param placeTypeId the place type id
	 * @param date the date
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @return the top places list
	 */
	Places getTopPlacesList(String apiKey, String placeTypeId, String date,
			String woeId, String placeId);// date,woeId,placeId,

	/**
	 * Places for bounding box.
	 *
	 * @param apiKey the api key
	 * @param bbox the bbox
	 * @param placeType the place type
	 * @param placeTypeId the place type id
	 */
	void placesForBoundingBox(String apiKey, String bbox, String placeType,
			String placeTypeId);// placeType,placeTypeId,

	/**
	 * Places for contacts.
	 *
	 * @param apiKey the api key
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
	 */
	void placesForContacts(String apiKey, String placeType, String placeTypeId,
			String woeId, String placeId, String threshold, String contacts,
			String minUploadDate, String maxUploadDate, String minTakenDate,
			String maxTakenDate);// placeType,placeTypeId,woeId,placeId,threshold,contacts,minUploadDate,maxUploadDate,minTakenDate,maxTakenDate,

	/**
	 * Places for tags.
	 *
	 * @param apiKey the api key
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
	 */
	void placesForTags(String apiKey, String placeTypeId, String woeId,
			String placeId, String threshold, String tags, String tagMode,
			String machineTags, String machineTagMode, String minUploadDate,
			String maxUploadDate, String minTakenDate, String maxTakenDate);// woeId,placeId,threshold,tags,tagMode,machineTags,machineTagMode,minUploadDate,maxUploadDate,minTakenDate,maxTakenDate,

	/**
	 * Places for user.
	 *
	 * @param apiKey the api key
	 * @param placeTypeId the place type id
	 * @param placeType the place type
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @param threshold the threshold
	 * @param minUploadDate the min upload date
	 * @param maxUploadDate the max upload date
	 * @param minTakenDate the min taken date
	 * @param maxTakenDate the max taken date
	 */
	void placesForUser(String apiKey, String placeTypeId, String placeType,
			String woeId, String placeId, String threshold,
			String minUploadDate, String maxUploadDate, String minTakenDate,
			String maxTakenDate);// placeTypeId,placeType,woeId,placeId,threshold,minUploadDate,maxUploadDate,minTakenDate,maxTakenDate,

	/**
	 * Resolve place id.
	 *
	 * @param apiKey the api key
	 * @param placeId the place id
	 * @return the location
	 */
	Location resolvePlaceId(String apiKey, String placeId);

	/**
	 * Resolve place url.
	 *
	 * @param apiKey the api key
	 * @param url the url
	 * @return the location
	 */
	Location resolvePlaceURL(String apiKey, String url);

	/**
	 * Tags for place.
	 *
	 * @param apiKey the api key
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @param minUploadDate the min upload date
	 * @param maxUploadDate the max upload date
	 * @param minTakenDate the min taken date
	 * @param maxTakenDate the max taken date
	 * @return the tags
	 */
	Tags tagsForPlace(String apiKey, String woeId, String placeId,
			String minUploadDate, String maxUploadDate, String minTakenDate,
			String maxTakenDate);// woeId,placeId,minUploadDate,maxUploadDate,minTakenDate,maxTakenDate,
}