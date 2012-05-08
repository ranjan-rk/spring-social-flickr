package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Gallery;
import org.springframework.social.flickr.api.Group;
import org.springframework.social.flickr.api.UrlsOperations;
import org.springframework.social.flickr.api.User;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class UrlsTemplate extends AbstractFlickrOperations implements
		UrlsOperations {
	private final RestTemplate restTemplate;

	public UrlsTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Group getGroup(String apiKey, String groupId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (groupId != null)
			parameters.set("group_id", groupId);
		return restTemplate.getForObject(
				buildUri("flickr.urls.getGroup", parameters), Group.class);
	}

	@Override
	public User getUserPhotos(String apiKey, String userId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (userId != null)
			parameters.set("user_id", userId);
		return restTemplate.getForObject(
				buildUri("flickr.urls.getUserPhotos", parameters), User.class);
	}

	@Override
	public User getUserProfile(String apiKey, String userId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (userId != null)
			parameters.set("user_id", userId);
		return restTemplate.getForObject(
				buildUri("flickr.urls.getUserProfile", parameters), User.class);
	}

	@Override
	public Gallery lookupGallery(String apiKey, String url) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (url != null)
			parameters.set("url", url);
		return restTemplate.getForObject(
				buildUri("flickr.urls.lookupGallery", parameters),
				Gallery.class);
	}

	@Override
	public Group lookupGroup(String apiKey, String url) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (url != null)
			parameters.set("url", url);
		return restTemplate.getForObject(
				buildUri("flickr.urls.lookupGroup", parameters), Group.class);
	}

	@Override
	public User lookupUser(String apiKey, String url) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (url != null)
			parameters.set("url", url);
		return restTemplate.getForObject(
				buildUri("flickr.urls.lookupUser", parameters), User.class);
	}
}