package org.springframework.social.flickr.api;

/**
 * @author HemantS
 * 
 * The Interface PhotoCommentOperations.
 */
public interface PhotoCommentOperations {

	/**
	 * Add comment to a photo as the currently authenticated user.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param photoId
	 * @param commentText
	 * @return
	 */
	Comment addComment(String photoId , String commentText);
	
	/**
	 * Delete a comment as the currently authenticated user.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param commentId
	 * @return
	 */
	boolean deleteComment(String commentId);
	
	/**
	 * Edit the text of a comment as the currently authenticated user.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param commentId
	 * @param commentText
	 * @return
	 */
	boolean editComment(String commentId , String commentText);
	
	/**
	 * flickr.photos.comments.getList
	 * 
	 * This method does not require authentication.
	 * 
	 * @param photoId
	 * @param minCommentDate //optional send null
	 * @param isMaxCommentDate //optional send null
	 * @return
	 */
	Comments getList(String photoId , String minCommentDate, String maxCommentDate);
}
