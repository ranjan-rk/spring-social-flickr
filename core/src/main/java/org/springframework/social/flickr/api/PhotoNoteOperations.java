package org.springframework.social.flickr.api;

/**
 * The Interface PhotoNoteOperations.
 *
 * @author HemantS
 */
public interface PhotoNoteOperations {
	
	/**
	 * 
	 * Add a note to a photo. Coordinates and sizes are in pixels, based on the 500px image size shown on individual photo pages.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param photoId
	 * @param note
	 * @return
	 */
	String add(String photoId , Note note);
	
	/**
	 * Delete a note from a photo.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param noteId
	 * @return
	 */
	boolean delete(String noteId);
	
	/**
	 * Edit a note on a photo. Coordinates and sizes are in pixels, based on the 500px image size shown on individual photo pages.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param noteId
	 * @param note
	 * @return
	 */
	boolean edit(String noteId , Note note);
}
