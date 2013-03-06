package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface TagsOperations.
 *
 * @author HemantS
 */ public interface TagsOperations {
	
	/**
	 * Gets the cluster photos.
	 *
	 * @param apiKey the api key
	 * @param tag the tag
	 * @param clusterId the cluster id
	 * @return the cluster photos
	 */
	Photos getClusterPhotos(String tag, String clusterId); 
	/**
	 * Gets the clusters.
	 *
	 * @param apiKey the api key
	 * @param tag the tag
	 * @return the clusters
	 */
	Clusters getClusters(String tag);

	/**
	 * Gets the hot list.
	 *
	 * @param apiKey the api key
	 * @param period the period
	 * @param count the count
	 * @return the hot list
	 */
	Hottags getHotList(String period, String count);// period,count,

	/**
	 * Gets the list photo.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @return the list photo
	 */
	Photo getListPhoto(String photoId);

	/**
	 * Gets the list user.
	 *
	 * @param apiKey the api key
	 * @param userId the user id
	 * @return the list user
	 */
	Who getListUser(String userId);// userId,

	/**
	 * Gets the list user popular.
	 *
	 * @param apiKey the api key
	 * @param userId the user id
	 * @param count the count
	 * @return the list user popular
	 */
	Who getListUserPopular(String userId, String count);// userId,count,

	/**
	 * Gets the list user raw.
	 *
	 * @param apiKey the api key
	 * @param tag the tag
	 * @return the list user raw
	 */
	Who getListUserRaw(String tag);// tag,

	/**
	 * Gets the most frequently used.
	 *
	 * @param apiKey the api key
	 * @return the most frequently used
	 */
	Rsp getMostFrequentlyUsed();

	/**
	 * Gets the related.
	 *
	 * @param apiKey the api key
	 * @param tag the tag
	 * @return the related
	 */
	Tags getRelated(String tag);
}