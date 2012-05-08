package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface ActivityOperations.
 *
 * @author HemantS
 */
public interface ActivityOperations {
	
	/**
	 * User comments.
	 *
	 * @param apiKey the api key
	 * @param perPage the per page
	 * @param page the page
	 * @return the items
	 */
	Items userComments(String apiKey, String perPage, String page);// perPage,page,

	/**
	 * User photos.
	 *
	 * @param apiKey the api key
	 * @param timeframe the timeframe
	 * @param perPage the per page
	 * @param page the page
	 * @return the items
	 */
	Items userPhotos(String apiKey, String timeframe, String perPage,
			String page);// timeframe,perPage,page,
}