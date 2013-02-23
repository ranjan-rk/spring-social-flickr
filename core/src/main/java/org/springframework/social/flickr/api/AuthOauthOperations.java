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
	 * @param oauthToken the oauth token
	 * @return the oauth
	 */
	Oauth checkToken(String oauthToken);

	/**
	 * Gets the access token.
	 *
	 * @return the access token
	 */
	Auth getAccessToken();
}