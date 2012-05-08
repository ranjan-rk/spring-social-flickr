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
	 * @param apiKey the api key
	 * @param photosetId the photoset id
	 * @param commentText the comment text
	 * @return the comment
	 */
	Comment addComment(String apiKey, String photosetId, String commentText);

	/**
	 * Delete comment.
	 *
	 * @param apiKey the api key
	 * @param commentId the comment id
	 */
	void deleteComment(String apiKey, String commentId);

	/**
	 * Edits the comment.
	 *
	 * @param apiKey the api key
	 * @param commentId the comment id
	 * @param commentText the comment text
	 */
	void editComment(String apiKey, String commentId, String commentText);

	/**
	 * Gets the list.
	 *
	 * @param apiKey the api key
	 * @param photosetId the photoset id
	 * @return the list
	 */
	Comments getList(String apiKey, String photosetId);
}