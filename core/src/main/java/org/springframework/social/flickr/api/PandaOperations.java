package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface PandaOperations.
 *
 * @author HemantS
 */
public interface PandaOperations {
	
	/**
	 * Gets the list.
	 *
	 * @param apiKey the api key
	 * @return the list
	 */
	Pandas getList(String apiKey);

	/**
	 * Gets the photos.
	 *
	 * @param apiKey the api key
	 * @param pandaName the panda name
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the photos
	 */
	Photos getPhotos(String apiKey, String pandaName, String extras,
			String perPage, String page);// extras,perPage,page,
}