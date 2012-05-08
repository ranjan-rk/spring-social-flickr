package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.ActivityOperations;
import org.springframework.social.flickr.api.Items;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class ActivityTemplate extends AbstractFlickrOperations implements
		ActivityOperations {
	private final RestTemplate restTemplate;

	public ActivityTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Items userComments(String apiKey, String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.activity.userComments", parameters),
				Items.class);
	}

	@Override
	public Items userPhotos(String apiKey, String timeframe, String perPage,
			String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (timeframe != null)
			parameters.set("timeframe", timeframe);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate
				.getForObject(
						buildUri("flickr.activity.userPhotos", parameters),
						Items.class);
	}
}