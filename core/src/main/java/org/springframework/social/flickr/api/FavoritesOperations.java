package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface FavoritesOperations.
 *
 * @author HemantS
 */
public interface FavoritesOperations {
	
	/**
	 * Adds the.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 */
	void add(String apiKey, String photoId);

	/**
	 * Gets the context.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param userId the user id
	 * @return the context
	 */
	Rsp getContext(String apiKey, String photoId, String userId);

	/**
	 * Gets the list.
	 *
	 * @param apiKey the api key
	 * @param userId the user id
	 * @param minFaveDate the min fave date
	 * @param maxFaveDate the max fave date
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the list
	 */
	Photos getList(String apiKey, String userId, String minFaveDate,
			String maxFaveDate, String extras, String perPage, String page);// userId,minFaveDate,maxFaveDate,extras,perPage,page,

	/**
	 * Gets the public list.
	 *
	 * @param apiKey the api key
	 * @param userId the user id
	 * @param minFaveDate the min fave date
	 * @param maxFaveDate the max fave date
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the public list
	 */
	Photos getPublicList(String apiKey, String userId, String minFaveDate,
			String maxFaveDate, String extras, String perPage, String page);// minFaveDate,maxFaveDate,extras,perPage,page,

	/**
	 * Removes the.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 */
	void remove(String apiKey, String photoId);
}