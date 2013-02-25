package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.PhotosSuggestionsOperations;
import org.springframework.social.flickr.api.Suggestions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PhotosSuggestionsTemplate extends AbstractFlickrOperations
		implements PhotosSuggestionsOperations {
	private final RestTemplate restTemplate;

	public PhotosSuggestionsTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser, consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean approveSuggestion(String suggestionId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (suggestionId != null)
			parameters.set("suggestion_id", suggestionId);
		restTemplate.postForObject(
				buildUri("flickr.photos.suggestions.approveSuggestion"),
				parameters, Object.class);
		return true;
	}

	@Override
	public Suggestions getList(String photoId, String statusId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (statusId != null)
			parameters.set("status_id", statusId);
		return restTemplate.getForObject(
				buildUri("flickr.photos.suggestions.getList", parameters),
				Suggestions.class);
	}

	@Override
	public boolean rejectSuggestion(String suggestionId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (suggestionId != null)
			parameters.set("suggestion_id", suggestionId);
		restTemplate.postForObject(
				buildUri("flickr.photos.suggestions.rejectSuggestion"),
				parameters, Object.class);
		return true;
	}

	@Override
	public boolean removeSuggestion(String suggestionId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (suggestionId != null)
			parameters.set("suggestion_id", suggestionId);
		restTemplate.postForObject(
				buildUri("flickr.photos.suggestions.removeSuggestion"),
				parameters, Object.class);
		return true;
	}

	@Override
	public Suggestions suggestLocation(String photoId, String lat,
			String lon, String accuracy, String woeId, String placeId,
			String note) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (lat != null)
			parameters.set("lat", lat);
		if (lon != null)
			parameters.set("lon", lon);
		if (accuracy != null)
			parameters.set("accuracy", accuracy);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (note != null)
			parameters.set("note", note);
		return restTemplate.postForObject(
				buildUri("flickr.photos.suggestions.suggestLocation"),
				parameters, Suggestions.class);
	}
}