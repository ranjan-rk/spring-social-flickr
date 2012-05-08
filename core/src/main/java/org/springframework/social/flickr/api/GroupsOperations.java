package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface GroupsOperations.
 *
 * @author HemantS
 */
public interface GroupsOperations {
	
	/**
	 * Browse.
	 *
	 * @param apiKey the api key
	 * @param catId the cat id
	 * @return the category
	 */
	Category browse(String apiKey, String catId);// catId,

	/**
	 * Search.
	 *
	 * @param apiKey the api key
	 * @param text the text
	 * @param perPage the per page
	 * @param page the page
	 * @return the groups
	 */
	Groups search(String apiKey, String text, String perPage, String page);// perPage,page,
	
	/**
	 * Gets the info.
	 *
	 * @param apiKey the api key
	 * @param groupId the group id
	 * @param lang the lang
	 * @return the info
	 */
	Group getInfo(String apiKey, String groupId, String lang);
}