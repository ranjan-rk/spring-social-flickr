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
	 * @param apiKey the api key
	 * @param galleryId the gallery id
	 * @param photoId the photo id
	 * @param comment the comment
	 */
	void addPhoto(String apiKey, String galleryId, String photoId,
			String comment);// comment,

	/**
	 * Creates the.
	 *
	 * @param apiKey the api key
	 * @param title the title
	 * @param description the description
	 * @param primaryPhotoId the primary photo id
	 * @return the gallery
	 */
	Gallery create(String apiKey, String title, String description,
			String primaryPhotoId);// primaryPhotoId,

	/**
	 * Edits the meta.
	 *
	 * @param apiKey the api key
	 * @param galleryId the gallery id
	 * @param title the title
	 * @param description the description
	 */
	void editMeta(String apiKey, String galleryId, String title,
			String description);// description,

	/**
	 * Edits the photo.
	 *
	 * @param apiKey the api key
	 * @param galleryId the gallery id
	 * @param photoId the photo id
	 * @param comment the comment
	 */
	void editPhoto(String apiKey, String galleryId, String photoId,
			String comment);

	/**
	 * Edits the photos.
	 *
	 * @param apiKey the api key
	 * @param galleryId the gallery id
	 * @param primaryPhotoId the primary photo id
	 * @param photoIds the photo ids
	 */
	void editPhotos(String apiKey, String galleryId, String primaryPhotoId,
			String photoIds);

	/**
	 * Gets the info.
	 *
	 * @param apiKey the api key
	 * @param galleryId the gallery id
	 * @return the info
	 */
	Gallery getInfo(String apiKey, String galleryId);

	/**
	 * Gets the list.
	 *
	 * @param apiKey the api key
	 * @param userId the user id
	 * @param perPage the per page
	 * @param page the page
	 * @return the list
	 */
	Galleries getList(String apiKey, String userId, String perPage, String page);// perPage,page,

	/**
	 * Gets the list for photo.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param perPage the per page
	 * @param page the page
	 * @return the list for photo
	 */
	void getListForPhoto(String apiKey, String photoId, String perPage,
			String page);// perPage,page,

	/**
	 * Gets the photos.
	 *
	 * @param apiKey the api key
	 * @param galleryId the gallery id
	 * @param extras the extras
	 * @param perPage the per page
	 * @param page the page
	 * @return the photos
	 */
	Photos getPhotos(String apiKey, String galleryId, String extras,
			String perPage, String page);// extras,perPage,page,
}