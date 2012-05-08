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
	Rsp getContentType(String apiKey);

	/**
	 * Gets the geo perms.
	 *
	 * @param apiKey the api key
	 * @return the geo perms
	 */
	Rsp getGeoPerms(String apiKey);

	/**
	 * Gets the hidden.
	 *
	 * @param apiKey the api key
	 * @return the hidden
	 */
	Rsp getHidden(String apiKey);

	/**
	 * Gets the privacy.
	 *
	 * @param apiKey the api key
	 * @return the privacy
	 */
	Rsp getPrivacy(String apiKey);

	/**
	 * Gets the safety level.
	 *
	 * @param apiKey the api key
	 * @return the safety level
	 */
	Rsp getSafetyLevel(String apiKey);
}