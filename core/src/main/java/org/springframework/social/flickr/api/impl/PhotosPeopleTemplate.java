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
			boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean add(String photoId, String userId,
			String personX, String personY, String personW, String personH) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
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
		return true;
	}

	@Override
	public boolean delete(String photoId, String userId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (userId != null)
			parameters.set("user_id", userId);
		restTemplate.postForObject(buildUri("flickr.photos.people.delete"),
				parameters, Object.class);
		return true;
	}

	@Override
	public People getList(String photoId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		return restTemplate.getForObject(
				buildUri("flickr.photos.people.getList", parameters),
				People.class);
	}

	@Override
	public boolean deleteCoords(String photoId, String userId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (userId != null)
			parameters.set("user_id", userId);
		restTemplate.postForObject(
				buildUri("flickr.photos.people.deleteCoords"), parameters,
				Object.class);
		return true;
	}

	@Override
	public boolean editCoords(String photoId, String userId,
			String personX, String personY, String personW, String personH) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
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
		return true;
	}
}