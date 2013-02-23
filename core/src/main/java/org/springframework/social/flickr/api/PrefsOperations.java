package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface PrefsOperations.
 *
 * @author HemantS
 */
public interface PrefsOperations {
	
	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	Person getContentType();

	/**
	 * Gets the geo perms.
	 *
	 * @return the geo perms
	 */
	Person getGeoPerms();

	/**
	 * Gets the hidden.
	 *
	 * @return the hidden
	 */
	Person getHidden();

	/**
	 * Gets the privacy.
	 *
	 * @return the privacy
	 */
	Person getPrivacy();

	/**
	 * Gets the safety level.
	 *
	 * @return the safety level
	 */
	Person getSafetyLevel();
}