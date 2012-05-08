package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.People;
import org.springframework.social.flickr.api.PhotosPeopleOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 * 
 */
public class PhotosPeopleTemplate extends AbstractFlickrOperations implements
		PhotosPeopleOperations {
	private final RestTemplate restTemplate;

	public PhotosPeopleTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public void add(String apiKey, String photoId, String userId,
			String personX, String personY, String personW, String personH) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (userId != null)
			parameters.set("user_id", userId);
		if (personX != null)
			parameters.set("person_x", personX);
		if (personY != null)
			parameters.set("person_y", personY);
		if (personW != null)
			parameters.set("person_w", personW);
		if (personH != null)
			parameters.set("person_h", personH);
		restTemplate.postForObject(buildUri("flickr.photos.people.add"),
				parameters, Object.class);
	}

	@Override
	public void delete(String apiKey, String photoId, String userId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (userId != null)
			parameters.set("user_id", userId);
		restTemplate.postForObject(buildUri("flickr.photos.people.delete"),
				parameters, Object.class);
	}

	@Override
	public People getList(String apiKey, String photoId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		return restTemplate.getForObject(
				buildUri("flickr.photos.people.getList", parameters),
				People.class);
	}

	@Override
	public void deleteCoords(String apiKey, String photoId, String userId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (userId != null)
			parameters.set("user_id", userId);
		restTemplate.postForObject(
				buildUri("flickr.photos.people.deleteCoords"), parameters,
				Object.class);
	}

	@Override
	public void editCoords(String apiKey, String photoId, String userId,
			String personX, String personY, String personW, String personH) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (userId != null)
			parameters.set("user_id", userId);
		if (personX != null)
			parameters.set("person_x", personX);
		if (personY != null)
			parameters.set("person_y", personY);
		if (personW != null)
			parameters.set("person_w", personW);
		if (personH != null)
			parameters.set("person_h", personH);
		restTemplate.postForObject(buildUri("flickr.photos.people.editCoords"),parameters, Object.class);
	}
}