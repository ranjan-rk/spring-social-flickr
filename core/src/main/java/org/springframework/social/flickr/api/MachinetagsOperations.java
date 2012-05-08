package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface MachinetagsOperations.
 *
 * @author HemantS
 */
public interface MachinetagsOperations {
	
	/**
	 * Gets the namespaces.
	 *
	 * @param apiKey the api key
	 * @param predicate the predicate
	 * @param perPage the per page
	 * @param page the page
	 * @return the namespaces
	 */
	Namespaces getNamespaces(String apiKey, String predicate, String perPage,
			String page);// predicate,perPage,page,

	/**
	 * Gets the pairs.
	 *
	 * @param apiKey the api key
	 * @param namespace the namespace
	 * @param predicate the predicate
	 * @param perPage the per page
	 * @param page the page
	 * @return the pairs
	 */
	void getPairs(String apiKey, String namespace, String predicate,
			String perPage, String page);// namespace,predicate,perPage,page,

	/**
	 * Gets the predicates.
	 *
	 * @param apiKey the api key
	 * @param namespace the namespace
	 * @param perPage the per page
	 * @param page the page
	 * @return the predicates
	 */
	Predicates getPredicates(String apiKey, String namespace, String perPage,
			String page);// namespace,perPage,page,

	/**
	 * Gets the recent values.
	 *
	 * @param apiKey the api key
	 * @param namespace the namespace
	 * @param predicate the predicate
	 * @param addedSince the added since
	 * @return the recent values
	 */
	Values getRecentValues(String apiKey, String namespace, String predicate,
			String addedSince);// namespace,predicate,addedSince,

	/**
	 * Gets the values.
	 *
	 * @param apiKey the api key
	 * @param namespace the namespace
	 * @param predicate the predicate
	 * @param perPage the per page
	 * @param page the page
	 * @return the values
	 */
	Values getValues(String apiKey, String namespace, String predicate,
			String perPage, String page);// perPage,page,
}