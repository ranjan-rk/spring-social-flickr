package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.FavoritesOperations;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.Rsp;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 * 
 */
public class FavoritesTemplate extends AbstractFlickrOperations implements
		FavoritesOperations {
	private final RestTemplate restTemplate;

	public FavoritesTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean add(String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		restTemplate.postForObject(buildUri("flickr.favorites.add"),
				parameters, Object.class);
		return true;
	}

	@Override
	public Rsp getContext(String photoId, String userId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (userId != null)
			parameters.set("user_id", userId);
		return restTemplate.getForObject(
				buildUri("flickr.favorites.getContext", parameters), Rsp.class);
	}

	@Override
	public Photos getList(String userId, String minFaveDate,
			String maxFaveDate, String extras, String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (userId != null)
			parameters.set("user_id", userId);
		if (minFaveDate != null)
			parameters.set("min_fave_date", minFaveDate);
		if (maxFaveDate != null)
			parameters.set("max_fave_date", maxFaveDate);
		if (extras != null)
			parameters.set("extras", extras);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.favorites.getList", parameters), Photos.class);
	}

	@Override
	public Photos getPublicList(String userId, String minFaveDate,
			String maxFaveDate, String extras, String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (userId != null)
			parameters.set("user_id", userId);
		if (minFaveDate != null)
			parameters.set("min_fave_date", minFaveDate);
		if (maxFaveDate != null)
			parameters.set("max_fave_date", maxFaveDate);
		if (extras != null)
			parameters.set("extras", extras);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.favorites.getPublicList", parameters),
				Photos.class);
	}

	@Override
	public boolean remove(String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		restTemplate.postForObject(buildUri("flickr.favorites.remove"),
				parameters, Object.class);
		return true;
	}
}