package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactsOperations.
 */
/**
 * @author HemantS
 *
 */
public interface ContactsOperations {
	
	/**
	 * Gets the list recently uploaded.
	 *
	 * @param apiKey the api key
	 * @param dateLastupload the date lastupload
	 * @param filter the filter
	 * @return the list recently uploaded
	 */
	void getListRecentlyUploaded(String apiKey, String dateLastupload,
			String filter);// dateLastupload,filter,

	/**
	 * Gets the public list.
	 *
	 * @param apiKey the api key
	 * @param userId the user id
	 * @param page the page
	 * @param perPage the per page
	 * @return the public list
	 */
	Contacts getPublicList(String apiKey, String userId, String page,
			String perPage);// page,perPage,

	/**
	 * Gets the tagging suggestions.
	 *
	 * @param apiKey the api key
	 * @param perPage the per page
	 * @param page the page
	 * @return the tagging suggestions
	 */
	void getTaggingSuggestions(String apiKey, String perPage, String page);// perPage,page,
}