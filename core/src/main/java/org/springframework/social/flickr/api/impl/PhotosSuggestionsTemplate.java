package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.PhotosSuggestionsOperations;
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

	public PhotosSuggestionsTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public void approveSuggestion(String apiKey, String suggestionId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (suggestionId != null)
			parameters.set("suggestion_id", suggestionId);
		restTemplate.postForObject(
				buildUri("flickr.photos.suggestions.approveSuggestion"),
				parameters, Object.class);
	}

	@Override
	public void getList(String apiKey, String photoId, String statusId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (statusId != null)
			parameters.set("status_id", statusId);
		restTemplate.getForObject(
				buildUri("flickr.photos.suggestions.getList", parameters),
				Object.class);
	}

	@Override
	public void rejectSuggestion(String apiKey, String suggestionId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (suggestionId != null)
			parameters.set("suggestion_id", suggestionId);
		restTemplate.postForObject(
				buildUri("flickr.photos.suggestions.rejectSuggestion"),
				parameters, Object.class);
	}

	@Override
	public void removeSuggestion(String apiKey, String suggestionId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (suggestionId != null)
			parameters.set("suggestion_id", suggestionId);
		restTemplate.postForObject(
				buildUri("flickr.photos.suggestions.removeSuggestion"),
				parameters, Object.class);
	}

	@Override
	public void suggestLocation(String apiKey, String photoId, String lat,
			String lon, String accuracy, String woeId, String placeId,
			String note) {
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
		if (woeId != null)
			parameters.set("woe_id", woeId);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (note != null)
			parameters.set("note", note);
		restTemplate.postForObject(
				buildUri("flickr.photos.suggestions.suggestLocation"),
				parameters, Object.class);
	}
}