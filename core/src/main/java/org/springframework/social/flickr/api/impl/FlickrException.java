package org.springframework.social.flickr.api.impl;

import org.springframework.social.SocialException;

/**
 * @author HemantS
 *
 */
public class FlickrException  extends SocialException {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public FlickrException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
}
