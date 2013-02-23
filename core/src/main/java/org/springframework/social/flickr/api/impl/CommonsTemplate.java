package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.CommonsOperations;
import org.springframework.social.flickr.api.Institutions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class CommonsTemplate extends AbstractFlickrOperations implements
		CommonsOperations {
	private final RestTemplate restTemplate;

	public CommonsTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Institutions getInstitutions() {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		return restTemplate.getForObject(
				buildUri("flickr.commons.getInstitutions", parameters),
				Institutions.class);
	}
}