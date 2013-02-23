package org.springframework.social.flickr.api;

import java.util.List;

/**
 * The Interface PhotosetOperations.
 */
public interface PhotosetOperations {

	/**
	 * Create a new photoset for the calling user.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param title
	 * @param description
	 *            options send null
	 * @param primaryPhotoId
	 * @return
	 */
	Photoset create(String title, String description, String primaryPhotoId);

	/**
	 * Add a photo to the end of an existing photoset.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param photosetId
	 * @param photoId
	 * @return
	 */
	boolean addPhoto(String photosetId, String photoId);

	/**
	 * Modify the meta-data for a photoset.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param photosetId
	 * @param title
	 * @param description
	 *            A description of the photoset. May contain limited html.
	 * @return
	 */
	boolean editMeta(String photosetId, String title, String description);

	/**
	 * Modify the photos in a photoset. Use this method to add, remove and
	 * re-order photos.
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param photosetId
	 * @param primaryPhotoId
	 *            The id of the photo to use as the 'primary' photo for the set.
	 *            This id must also be passed along in photo_ids list argument.
	 * 
	 * @param photoIds
	 *            A list of photo ids to include in the set. They will appear in
	 *            the set in the order sent. This list must contain the primary
	 *            photo id. All photos must belong to the owner of the set. This
	 *            list of photos replaces the existing list. Call
	 *            flickr.photosets.addPhoto to append a photo to a set.
	 * 
	 * @return
	 */
	boolean editPhotos(String photosetId, String primaryPhotoId,
			List<String> photoIds);

	/**
	 * Returns next and previous photos for a photo in a set.
	 * 
	 * This method does not require authentication.
	 * 
	 * @param photoId
	 * @param photosetId
	 * @return
	 */
	/*
	 * TODO: Need to handle in special way PhotoCount getContext(String photoId ,
	 * String photosetId);
	 */

	/**
	 * Gets information about a photoset.
	 * 
	 * This method does not require authentication.
	 * 
	 * @param photosetId
	 * @return
	 */
	Photoset getInfo(String photosetId);

	/**
	 * Returns the photosets belonging to the specified user.
	 * 
	 * This method does not require authentication.
	 * 
	 * @param userId
	 * @param page
	 *            optional send null
	 * @param perPage
	 *            optional send null
	 * @return
	 */
	Photosets getList(String userId, String page, String perPage);

	/**
	 * Delete.
	 *
	 * @param photosetId the photoset id
	 */
	boolean delete( String photosetId);

	/**
	 * Gets the photos.
	 *
	 * @param photosetId the photoset id
	 * @param extras the extras
	 * @param privacyFilter the privacy filter
	 * @param perPage the per page
	 * @param page the page
	 * @param media the media
	 * @return the photos
	 */
	Photoset getPhotos( String photosetId, String[] extras,
			PrivacyFilterEnum privacyFilter, String perPage, String page, MediaEnum media);// extras,privacyFilter,perPage,page,media optional

	/**
	 * Order sets.
	 *
	 * @param photosetIds the photoset ids
	 */
	boolean orderSets( String[] photosetIds);

	/**
	 * Removes the photo.
	 *
	 * @param photosetId the photoset id
	 * @param photoId the photo id
	 */
	boolean removePhoto( String photosetId, String photoId);

	/**
	 * Removes the photos.
	 *
	 * @param photosetId the photoset id
	 * @param photoIds the photo ids
	 */
	boolean removePhotos( String photosetId, String[] photoIds);

	/**
	 * Reorder photos.
	 *
	 * @param photosetId the photoset id
	 * @param photoIds the photo ids
	 */
	boolean reorderPhotos( String photosetId, String[] photoIds);

	/**
	 * Sets the primary photo.
	 *
	 * @param photosetId the photoset id
	 * @param photoId the photo id
	 */
	boolean setPrimaryPhoto( String photosetId, String photoId);

}
