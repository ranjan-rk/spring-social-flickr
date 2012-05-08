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
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param userId the user id
	 * @param personX the person x
	 * @param personY the person y
	 * @param personW the person w
	 * @param personH the person h
	 */
	void add(String apiKey, String photoId, String userId, String personX,
			String personY, String personW, String personH);// personX,personY,personW,personH,

	/**
	 * Delete.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param userId the user id
	 */
	void delete(String apiKey, String photoId, String userId);

	/**
	 * Delete coords.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param userId the user id
	 */
	void deleteCoords(String apiKey, String photoId, String userId);

	/**
	 * Edits the coords.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param userId the user id
	 * @param personX the person x
	 * @param personY the person y
	 * @param personW the person w
	 * @param personH the person h
	 */
	void editCoords(String apiKey, String photoId, String userId,
			String personX, String personY, String personW, String personH);

	/**
	 * Gets the list.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @return the list
	 */
	People getList(String apiKey, String photoId);
}