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
	 * @param perPage the per page
	 * @param page the page
	 * @return the items
	 */
	UserComment userComments( String perPage, String page);// perPage,page,

	/**
	 * User photos.
	 *
	 * @param timeframe the timeframe
	 * @param perPage the per page
	 * @param page the page
	 * @return the items
	 */
	UserComment userPhotos( String timeframe, String perPage,
			String page);// timeframe,perPage,page,
}