package org.springframework.social.flickr.api.impl;

import java.util.Collections;

import org.springframework.social.flickr.api.CollectionsOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class CollectionsTemplate extends AbstractFlickrOperations implements
		CollectionsOperations {
	private final RestTemplate restTemplate;

	public CollectionsTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public void getInfo(String collectionId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (collectionId != null)
			parameters.set("collection_id", collectionId);
		restTemplate.getForObject(
				buildUri("flickr.collections.getInfo", parameters),
				Object.class);
	}

	@Override
	public Collections getTree(String collectionId, String userId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (collectionId != null)
			parameters.set("collection_id", collectionId);
		if (userId != null)
			parameters.set("user_id", userId);
		return restTemplate.getForObject(
				buildUri("flickr.collections.getTree", parameters),
				Collections.class);
	}
}