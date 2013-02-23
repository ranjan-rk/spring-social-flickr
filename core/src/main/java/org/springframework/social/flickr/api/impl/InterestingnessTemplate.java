package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.InterestingnessOperations;
import org.springframework.social.flickr.api.Photos;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class InterestingnessTemplate extends AbstractFlickrOperations implements
		InterestingnessOperations {
	private final RestTemplate restTemplate;

	public InterestingnessTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey) {
		super(isAuthorizedForUser, consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Photos getList(String date, String extras,
			String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (date != null)
			parameters.set("date", date);
		if (extras != null)
			parameters.set("extras", extras);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.interestingness.getList", parameters),
				Photos.class);
	}
}