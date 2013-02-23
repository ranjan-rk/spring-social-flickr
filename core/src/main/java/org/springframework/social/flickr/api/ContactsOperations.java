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
	 * Gets the list.
	 *
	 * @param filter the filter
	 * @param page the page
	 * @param perPage the per page
	 * @param sort the sort
	 * @return the list
	 */
	Contacts getList(String filter, String page, String perPage, String sort );
	
	/**
	 * TODO: doubtful so leaving it for now
	 * 
	 * Gets the list recently uploaded.
	 *
	 * @param dateLastupload the date lastupload
	 * @param filter the filter
	 * @return the list recently uploaded
	 */
	void getListRecentlyUploaded(String dateLastupload,
			String filter);// dateLastupload,filter,

	/**
	 * Gets the public list.
	 *
	 * @param userId the user id
	 * @param page the page
	 * @param perPage the per page
	 * @return the public list
	 */
	Contacts getPublicList(String userId, String page,
			String perPage);// page,perPage,

	/**
	 * Gets the tagging suggestions.
	 *
	 * @param perPage the per page
	 * @param page the page
	 * @return the tagging suggestions
	 */
	Contacts getTaggingSuggestions(String perPage, String page);// perPage,page,
}