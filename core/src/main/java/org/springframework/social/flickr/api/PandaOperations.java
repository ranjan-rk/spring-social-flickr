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
	 * @return the list
	 */
	Pandas getList();

	/**
	 * Gets the photos.
	 *
	 * @param pandaName the panda name
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the photos
	 */
	Photos getPhotos(String pandaName, String extras,
			String perPage, String page);// extras,perPage,page,
}