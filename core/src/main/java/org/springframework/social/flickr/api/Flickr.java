package org.springframework.social.flickr.api;

import org.springframework.social.ApiBinding;

// TODO: Auto-generated Javadoc
/**
 * The Interface Flickr.
 *
 * @author HemantS
 */
public interface Flickr extends ApiBinding {

	/**
	 * People operations.
	 *
	 * @return the people operations
	 */
	PeopleOperations peopleOperations();

	/**
	 * Photo operations.
	 *
	 * @return the photo operations
	 */
	PhotoOperations photoOperations();

}
