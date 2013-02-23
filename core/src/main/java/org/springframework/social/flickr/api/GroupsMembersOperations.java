package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface GroupsMembersOperations.
 *
 * @author HemantS
 */
public interface GroupsMembersOperations {
	
	/**
	 * Gets the list.
	 *
	 * @param groupId the group id
	 * @param membertypes the membertypes
	 * @param perPage the per page
	 * @param page the page
	 * @return the list
	 */
	Members getList(String groupId, String membertypes,
			String perPage, String page);// membertypes,perPage,page,
}