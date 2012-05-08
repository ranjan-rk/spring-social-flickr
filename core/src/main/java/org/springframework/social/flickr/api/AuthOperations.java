package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface AuthOperations.
 *
 * @author HemantS
 */
public interface AuthOperations {
	
	/**
	 * Check token.
	 *
	 * @param apiKey the api key
	 * @param authToken the auth token
	 * @return the auth
	 */
	Auth checkToken(String apiKey, String authToken);

	/**
	 * Gets the frob.
	 *
	 * @param apiKey the api key
	 * @return the frob
	 */
	Frob getFrob(String apiKey);

	/**
	 * Gets the full token.
	 *
	 * @param apiKey the api key
	 * @param miniToken the mini token
	 * @return the full token
	 */
	Auth getFullToken(String apiKey, String miniToken);

	/**
	 * Gets the token.
	 *
	 * @param apiKey the api key
	 * @param frob the frob
	 * @return the token
	 */
	Auth getToken(String apiKey, String frob);
}