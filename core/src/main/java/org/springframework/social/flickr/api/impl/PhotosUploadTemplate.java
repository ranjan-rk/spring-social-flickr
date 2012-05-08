package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.PhotosUploadOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PhotosUploadTemplate extends AbstractFlickrOperations implements
		PhotosUploadOperations {
	private final RestTemplate restTemplate;

	public PhotosUploadTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public void checkTickets(String apiKey, String tickets) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (tickets != null)
			parameters.set("tickets", tickets);
		restTemplate.getForObject(
				buildUri("flickr.photos.upload.checkTickets", parameters),
				Object.class);
	}
}