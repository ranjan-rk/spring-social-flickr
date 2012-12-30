package org.springframework.social.flickr.api;

import java.io.File;


/**
 * @author HemantS
 *
 */

/**
 * The Interface PhotoOperations.
 */
public interface PhotoOperations {

    /**
     * Adds the tags.
     *
     * @param photoId the photo id
     * @param tagList the tag list
     * @return true, if successful
     */
    boolean addTags(String photoId, String[] tagList);

    /**
     * Adds the tags.
     *
     * @param photoId the photo id
     * @param tags    comma separated tags
     * @return true, if successful
     */
    boolean addTags(String photoId, String tags);


    /**
     * Remove a tag from a photo.
     * <p/>
     * This method requires authentication with 'write' permission.
     *
     * @param tagId
     * @return
     */
    boolean removeTag(String tagId);

    /**
     * Delete the photoT
     * This method require 'delete' permission
     *
     * @param photoId the photo id
     * @return true, if successful
     */
    boolean delete(String photoId);

    /**
     * Gets the recent.
     *
     * @param perPage the per page
     * @param page    the page
     * @param List    of extras
     * @return the recent
     */
    Photos getRecent(String perPage, String page, String[] extras);

    /**
     * Returns the list of people who have favorited a given photo.
     *
     * @param perPage the per page
     * @param page    the page
     * @param photoId the photo id
     * @return the favorites
     */
    Photo getFavorites(String perPage, String page, String photoId);

    /**
     * Get information about a photo. The calling user must have permission to view the photo.
     *
     * @param photoId the photo id
     * @return the info
     */
    PhotoDetail getInfo(String photoId);

    /**
     * Returns the available sizes for a photo. The calling user must have permission to view the photo.
     *
     * @param photoId the photo id
     * @return the sizes
     */
    Sizes getSizes(String photoId);

    /**
     * Get permissions for a photo.
     * <p/>
     * This method requires authentication with 'read' permission.
     *
     * @param photoId
     * @return
     */
    Perms getPerms(String photoId);

    /**
     * Set permissions for a photo.
     * <p/>
     * This method requires authentication with 'write' permission.
     *
     * @param perms
     * @return
     */
    PhotoId setPerms(Perms perms);

    /**
     * Set the content type of a photo.
     * <p/>
     * This method requires authentication with 'write' permission.
     *
     * @param photoId
     * @param contentType
     * @return
     */
    boolean setContentType(String photoId, ContentTypeEnum contentTypeEnum);

    /**
     * Set the safety level of a photo.
     * <p/>
     * This method requires authentication with 'write' permission.
     *
     * @param photoId
     * @param safetyLevel
     * @param hidden
     * @return
     */
    boolean setSafetyLevel(String photoId, SafetyLevelEnum safetyLevel, Boolean hidden);

    boolean setSafetyLevel(String photoId, SafetyLevelEnum safetyLevel);

    /**
     * Set the meta information for a photo.
     * <p/>
     * This method requires authentication with 'write' permission.
     *
     * @param photoId
     * @param title
     * @param description
     * @return
     */
    boolean setMeta(String photoId, String title, String description);

    /**
     * Rotate a photo.
     * <p/>
     * This method requires authentication with 'write' permission.
     *
     * @param photoId
     * @param rotation The amount of degrees by which to rotate the photo (clockwise) from it's current orientation. Valid values are 90, 180 and 270.
     * @return
     */
    PhotoId rotate(String photoId, RotateEnum rotation);

    /*peding */
    String upload(File photo, String title, String description, String[] tags, Perms perms, ContentTypeEnum contentType, HiddenEnum hiddenType);


}
