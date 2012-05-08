package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface TestOperations.
 *
 * @author HemantS
 */
public interface TestOperations {
	
	/**
	 * Echo.
	 *
	 * @param apiKey the api key
	 * @return the method
	 */
	Method echo(String apiKey);

	/**
	 * Login.
	 *
	 * @param apiKey the api key
	 * @return the user
	 */
	User login(String apiKey);

	/**
	 * Null.
	 *
	 * @param apiKey the api key
	 */
	void Null(String apiKey);
}