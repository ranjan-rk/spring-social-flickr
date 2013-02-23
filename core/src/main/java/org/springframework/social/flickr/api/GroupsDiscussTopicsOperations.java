package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface GroupsDiscussTopicsOperations.
 * 
 * @author HemantS
 */
public interface GroupsDiscussTopicsOperations {
	
	/**
	 * Adds the.
	 *
	 * @param groupId the group id
	 * @param subject the subject
	 * @param message the message
	 * @return the topic
	 */
	Topic add(String groupId , String subject , String message);
	
	/**
	 * Gets the info.
	 *
	 * @param topicId the topic id
	 * @return the info
	 */
	Topic getInfo(String topicId);
	
	/**
	 * Gets the list.
	 *
	 * @param groupId the group id
	 * @param per_page the per_page
	 * @param page the page
	 * @return the list
	 */
	Topics getList(String groupId,String perPage, String page);
}
