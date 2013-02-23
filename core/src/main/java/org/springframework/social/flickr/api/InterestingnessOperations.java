package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface InterestingnessOperations.
 *
 * @author HemantS
 */
public interface InterestingnessOperations {
	
	/**
	 * Gets the list.
	 *
	 * @param date the date
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the list
	 */
	Photos getList(String date, String extras, String perPage,
			String page);// date,extras,perPage,page,
}