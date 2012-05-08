package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Perms;
import org.springframework.social.flickr.api.Photo;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.PhotosGeoOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PhotosGeoTemplate extends AbstractFlickrOperations implements
		PhotosGeoOperations {
	private final RestTemplate restTemplate;

	public PhotosGeoTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public void batchCorrectLocation(String apiKey, String lat, String lon,
			String accuracy, String placeId, String woeId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (lat != null)
			parameters.set("lat", lat);
		if (lon != null)
			parameters.set("lon", lon);
		if (accuracy != null)
			parameters.set("accuracy", accuracy);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		restTemplate.postForObject(
				buildUri("flickr.photos.geo.batchCorrectLocation"), parameters,
				Object.class);
	}

	@Override
	public void correctLocation(String apiKey, String photoId, String placeId,
			String woeId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		restTemplate.postForObject(
				buildUri("flickr.photos.geo.correctLocation"), parameters,
				Object.class);
	}

	@Override
	public Photo getLocation(String apiKey, String photoId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		return restTemplate.getForObject(
				buildUri("flickr.photos.geo.getLocation", parameters),
				Photo.class);
	}

	@Override
	public Perms getPerms(String apiKey, String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		return restTemplate
				.getForObject(
						buildUri("flickr.photos.geo.getPerms", parameters),
						Perms.class);
	}

	@Override
	public Photos photosForLocation(String apiKey, String lat, String lon,
			String accuracy, String extras, String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (lat != null)
			parameters.set("lat", lat);
		if (lon != null)
			parameters.set("lon", lon);
		if (accuracy != null)
			parameters.set("accuracy", accuracy);
		if (extras != null)
			parameters.set("extras", extras);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.photos.geo.photosForLocation", parameters),
				Photos.class);
	}

	@Override
	public void removeLocation(String apiKey, String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		restTemplate.postForObject(
				buildUri("flickr.photos.geo.removeLocation"), parameters,
				Object.class);
	}

	@Override
	public void setContext(String apiKey, String photoId, String context) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (context != null)
			parameters.set("context", context);
		restTemplate.postForObject(buildUri("flickr.photos.geo.setContext"),
				parameters, Object.class);
	}

	@Override
	public void setLocation(String apiKey, String photoId, String lat,
			String lon, String accuracy, String context) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (lat != null)
			parameters.set("lat", lat);
		if (lon != null)
			parameters.set("lon", lon);
		if (accuracy != null)
			parameters.set("accuracy", accuracy);
		if (context != null)
			parameters.set("context", context);
		restTemplate.postForObject(buildUri("flickr.photos.geo.setLocation"),
				parameters, Object.class);
	}

	@Override
	public void setPerms(String apiKey, String isPublic, String isContact,
			String isFriend, String isFamily, String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (isPublic != null)
			parameters.set("is_public", isPublic);
		if (isContact != null)
			parameters.set("is_contact", isContact);
		if (isFriend != null)
			parameters.set("is_friend", isFriend);
		if (isFamily != null)
			parameters.set("is_family", isFamily);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		restTemplate.postForObject(buildUri("flickr.photos.geo.setPerms"),
				parameters, Object.class);
	}
}