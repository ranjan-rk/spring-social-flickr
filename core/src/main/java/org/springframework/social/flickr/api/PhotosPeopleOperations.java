package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface PhotosPeopleOperations.
 *
 * @author HemantS
 */
public interface PhotosPeopleOperations {
	
	/**
	 * Adds the.
	 *
	 * @param photoId the photo id
	 * @param userId the user id
	 * @param personX the person x
	 * @param personY the person y
	 * @param personW the person w
	 * @param personH the person h
	 */
	boolean add(String photoId, String userId, String personX,
			String personY, String personW, String personH);// personX,personY,personW,personH,

	/**
	 * Delete.
	 *
	 * @param photoId the photo id
	 * @param userId the user id
	 */
	boolean delete(String photoId, String userId);

	/**
	 * Delete coords.
	 *
	 * @param photoId the photo id
	 * @param userId the user id
	 */
	boolean deleteCoords(String photoId, String userId);

	/**
	 * Edits the coords.
	 *
	 * @param photoId the photo id
	 * @param userId the user id
	 * @param personX the person x
	 * @param personY the person y
	 * @param personW the person w
	 * @param personH the person h
	 */
	boolean editCoords(String photoId, String userId,
			String personX, String personY, String personW, String personH);

	/**
	 * Gets the list.
	 *
	 * @param photoId the photo id
	 * @return the list
	 */
	People getList(String photoId);
}