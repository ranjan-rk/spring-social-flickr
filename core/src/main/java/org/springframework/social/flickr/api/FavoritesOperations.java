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
	 * 
	 * @param photoId
	 *            the photo id
	 */
	boolean add(String photoId);

	/**
	 * Gets the context.
	 * 
	 * 
	 * @param photoId
	 *            the photo id
	 * @param userId
	 *            the user id
	 * @return the context
	 */
	//TODO:Pending as it return different kind of json
	Rsp getContext(String photoId, String userId);

	/**
	 * Gets the list.
	 * 
	 * 
	 * @param userId
	 *            the user id
	 * @param minFaveDate
	 *            the min fave date
	 * @param maxFaveDate
	 *            the max fave date
	 * @param extras
	 *            the extras
	 * @param perPage
	 *            the per page
	 * @param page
	 *            the page
	 * @return the list
	 */
	Photos getList(String userId, String minFaveDate, String maxFaveDate,
			String extras, String perPage, String page);// userId,minFaveDate,maxFaveDate,extras,perPage,page,

	/**
	 * Gets the public list.
	 * 
	 * 
	 * @param userId
	 *            the user id
	 * @param minFaveDate
	 *            the min fave date
	 * @param maxFaveDate
	 *            the max fave date
	 * @param extras
	 *            the extras
	 * @param perPage
	 *            the per page
	 * @param page
	 *            the page
	 * @return the public list
	 */
	Photos getPublicList(String userId, String minFaveDate, String maxFaveDate,
			String extras, String perPage, String page);// minFaveDate,maxFaveDate,extras,perPage,page,

	/**
	 * Removes the.
	 * 
	 * 
	 * @param photoId
	 *            the photo id
	 */
	boolean remove(String photoId);
}