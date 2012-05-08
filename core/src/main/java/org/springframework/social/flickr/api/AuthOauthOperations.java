package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface AuthOauthOperations.
 *
 * @author HemantS
 */
public interface AuthOauthOperations {
	
	/**
	 * Check token.
	 *
	 * @param apiKey the api key
	 * @param oauthToken the oauth token
	 * @return the oauth
	 */
	Oauth checkToken(String apiKey, String oauthToken);

	/**
	 * Gets the access token.
	 *
	 * @param apiKey the api key
	 * @return the access token
	 */
	Auth getAccessToken(String apiKey);
}