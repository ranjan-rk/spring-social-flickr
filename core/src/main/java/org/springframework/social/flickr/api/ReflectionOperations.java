package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface ReflectionOperations.
 *
 * @author HemantS
 */
public interface ReflectionOperations { 
	/**
	 * TODO: pending need to handle the response in different way
	 * Gets the method info.
	 *
	 * @param apiKey the api key
	 * @param methodName the method name
	 * @return the method info
	 */
	Method getMethodInfo(String methodName);

	/**
	 * Gets the methods.
	 *
	 * @param apiKey the api key
	 * @return the methods
	 */
	Methods getMethods();
}