package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.ActivityOperations;
import org.springframework.social.flickr.api.UserComment;
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
			boolean isAuthorizedForUser, String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public UserComment userComments(String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.activity.userComments", parameters),
				UserComment.class);
	}

	@Override
	public UserComment userPhotos( String timeframe, String perPage,
			String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (timeframe != null)
			parameters.set("timeframe", timeframe);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate
				.getForObject(
						buildUri("flickr.activity.userPhotos", parameters),
						UserComment.class);
	}
}