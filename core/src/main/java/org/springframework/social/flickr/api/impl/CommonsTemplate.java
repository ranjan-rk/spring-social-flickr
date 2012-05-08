package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.CommonsOperations;
import org.springframework.social.flickr.api.Rsp;
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
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Rsp getInstitutions(String apiKey) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.commons.getInstitutions", parameters),
				Rsp.class);
	}
}