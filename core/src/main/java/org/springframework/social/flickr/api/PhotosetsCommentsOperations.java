package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface PhotosetsCommentsOperations.
 *
 * @author HemantS
 */
public interface PhotosetsCommentsOperations {
	
	/**
	 * Adds the comment.
	 *
	 * @param photosetId the photoset id
	 * @param commentText the comment text
	 * @return the comment
	 */
	Comment addComment(String photosetId, String commentText);

	/**
	 * Delete comment.
	 *
	 * @param commentId the comment id
	 * @return true, if successful
	 */
	boolean deleteComment(String commentId);

	/**
	 * Edits the comment.
	 *
	 * @param commentId the comment id
	 * @param commentText the comment text
	 * @return true, if successful
	 */
	boolean editComment(String commentId, String commentText);

	/**
	 * Gets the list.
	 *
	 * @param photosetId the photoset id
	 * @return the list
	 */
	Comments getList(String photosetId);
}