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
	 * @param predicate the predicate
	 * @param perPage the per page
	 * @param page the page
	 * @return the namespaces
	 */
	Namespaces getNamespaces(String predicate, String perPage,
			String page);// predicate,perPage,page,

	/**
	 * Gets the pairs.
	 *
	 * @param namespace the namespace
	 * @param predicate the predicate
	 * @param perPage the per page
	 * @param page the page
	 * @return the pairs
	 */
	Pairs getPairs(String namespace, String predicate,
			String perPage, String page);// namespace,predicate,perPage,page,

	/**
	 * Gets the predicates.
	 *
	 * @param namespace the namespace
	 * @param perPage the per page
	 * @param page the page
	 * @return the predicates
	 */
	Predicates getPredicates(String namespace, String perPage,
			String page);// namespace,perPage,page,

	/**
	 * TODO: not enough data for test so leaving it right now
	 * Gets the recent values.
	 *
	 * @param namespace the namespace
	 * @param predicate the predicate
	 * @param addedSince the added since
	 * @return the recent values
	 */
	Values getRecentValues(String namespace, String predicate,
			String addedSince);// namespace,predicate,addedSince,

	/**
	 * Gets the values.
	 *
	 * @param namespace the namespace
	 * @param predicate the predicate
	 * @param perPage the per page
	 * @param page the page
	 * @return the values
	 */
	Values getValues(String namespace, String predicate,
			String perPage, String page);// perPage,page,
}