package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface GalleriesOperations.
 *
 * @author HemantS
 */
public interface GalleriesOperations {
	
	/**
	 * Adds the photo.
	 *
	 * @param galleryId the gallery id
	 * @param photoId the photo id
	 * @param comment the comment
	 */
	boolean addPhoto(String galleryId, String photoId,
			String comment);// comment,

	/**
	 * Creates the.
	 *

	 * @param title the title
	 * @param description the description
	 * @param primaryPhotoId the primary photo id
	 * @return the gallery
	 */
	Gallery create(String title, String description,
			String primaryPhotoId);// primaryPhotoId,

	/**
	 * Edits the meta.
	 *

	 * @param galleryId the gallery id
	 * @param title the title
	 * @param description the description
	 */
	boolean editMeta(String galleryId, String title,
			String description);// description,

	/**
	 * Edits the photo.
	 *

	 * @param galleryId the gallery id
	 * @param photoId the photo id
	 * @param comment the comment
	 */
	boolean editPhoto(String galleryId, String photoId,
			String comment);

	/**
	 * Edits the photos.
	 *

	 * @param galleryId the gallery id
	 * @param primaryPhotoId the primary photo id
	 * @param photoIds the photo ids
	 */
	boolean editPhotos(String galleryId, String primaryPhotoId,
			String[] photoIds);

	/**
	 * Gets the info.
	 *

	 * @param galleryId the gallery id
	 * @return the info
	 */
	Gallery getInfo(String galleryId);

	/**
	 * Gets the list.
	 *

	 * @param userId the user id
	 * @param perPage the per page
	 * @param page the page
	 * @return the list
	 */
	Galleries getList(String userId, String perPage, String page);// perPage,page,

	/**
	 * Gets the list for photo.
	 *

	 * @param photoId the photo id
	 * @param perPage the per page
	 * @param page the page
	 * @return the list for photo
	 */
	Galleries getListForPhoto(String photoId, String perPage,
			String page);// perPage,page,

	/**
	 * Gets the photos.
	 *

	 * @param galleryId the gallery id
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the photos
	 */
	Photos getPhotos(String galleryId, String extras,
			String perPage, String page);// extras,perPage,page,
}