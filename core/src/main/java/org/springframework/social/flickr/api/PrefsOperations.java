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
	 * @param apiKey the api key
	 * @return the content type
	 */
	Person getContentType(String apiKey);

	/**
	 * Gets the geo perms.
	 *
	 * @param apiKey the api key
	 * @return the geo perms
	 */
	Person getGeoPerms(String apiKey);

	/**
	 * Gets the hidden.
	 *
	 * @param apiKey the api key
	 * @return the hidden
	 */
	Person getHidden(String apiKey);

	/**
	 * Gets the privacy.
	 *
	 * @param apiKey the api key
	 * @return the privacy
	 */
	Person getPrivacy(String apiKey);

	/**
	 * Gets the safety level.
	 *
	 * @param apiKey the api key
	 * @return the safety level
	 */
	Person getSafetyLevel(String apiKey);
}