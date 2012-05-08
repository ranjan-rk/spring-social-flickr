package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface PushOperations.
 *
 * @author HemantS
 */
public interface PushOperations {
	
	/**
	 * Gets the subscriptions.
	 *
	 * @param apiKey the api key
	 * @return the subscriptions
	 */
	Rsp getSubscriptions(String apiKey);

	/**
	 * Gets the topics.
	 *
	 * @param apiKey the api key
	 * @return the topics
	 */
	Rsp getTopics(String apiKey);

	/**
	 * Subscribe.
	 *
	 * @param apiKey the api key
	 * @param topic the topic
	 * @param callback the callback
	 * @param verify the verify
	 * @param verifyToken the verify token
	 * @param leaseSeconds the lease seconds
	 * @param woeIds the woe ids
	 * @param placeIds the place ids
	 * @param lat the lat
	 * @param lon the lon
	 * @param radius the radius
	 * @param radiusUnits the radius units
	 * @param accuracy the accuracy
	 * @param nsids the nsids
	 * @param tags the tags
	 */
	void subscribe(String apiKey, String topic, String callback, String verify,
			String verifyToken, String leaseSeconds, String woeIds,
			String placeIds, String lat, String lon, String radius,
			String radiusUnits, String accuracy, String nsids, String tags);// verifyToken,leaseSeconds,woeIds,placeIds,lat,lon,radius,radiusUnits,accuracy,nsids,tags,
	
	/**
	 * Unsubscribe.
	 *
	 * @param apiKey the api key
	 * @param topic the topic
	 * @param callback the callback
	 * @param verify the verify
	 * @param verifyToken the verify token
	 */
	public void unsubscribe(String apiKey, String topic, String callback,
			String verify, String verifyToken);
}