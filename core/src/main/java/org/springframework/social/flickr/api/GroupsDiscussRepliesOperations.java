package org.springframework.social.flickr.api;

/**
 * The Interface GroupsDiscussRepliesOperations.
 * 
 *  @author HemantS
 */
public interface GroupsDiscussRepliesOperations {
	
	/**
	 * Adds the.
	 *
	 * @param topicId the topic id
	 * @param message the message
	 * @return the reply
	 */
	Reply add(String topicId, String message);
	
	/**
	 * Delete.
	 *
	 * @param topicId the topic id
	 * @param replyId the reply id
	 * @return true, if successful
	 */
	boolean delete(String topicId, String replyId);
	
	/**
	 * Edits the.
	 *
	 * @param topicId the topic id
	 * @param replyId the reply id
	 * @param message the message
	 * @return true, if successful
	 */
	boolean edit(String topicId, String replyId,String message);
	
	/**
	 * Gets the info.
	 *
	 * @param topicId the topic id
	 * @param replyId the reply id
	 * @return the info
	 */
	Reply getInfo(String topicId, String replyId);
	
	/**
	 * Gets the list.
	 *
	 * @param topicId the topic id
	 * @param replyId the reply id
	 * @return the list
	 */
	Replies getList(String topicId, String replyId);

}
