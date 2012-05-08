package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Location;
import org.springframework.social.flickr.api.Place;
import org.springframework.social.flickr.api.Place_types;
import org.springframework.social.flickr.api.Places;
import org.springframework.social.flickr.api.PlacesOperations;
import org.springframework.social.flickr.api.Shapes;
import org.springframework.social.flickr.api.Tags;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PlacesTemplate extends AbstractFlickrOperations implements
		PlacesOperations {
	private final RestTemplate restTemplate;

	public PlacesTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Places find(String apiKey, String query) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (query != null)
			parameters.set("query", query);
		return restTemplate.getForObject(
				buildUri("flickr.places.find", parameters), Places.class);
	}

	@Override
	public Places findByLatLon(String apiKey, String lat, String lon,
			String accuracy) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (lat != null)
			parameters.set("lat", lat);
		if (lon != null)
			parameters.set("lon", lon);
		if (accuracy != null)
			parameters.set("accuracy", accuracy);
		return restTemplate.getForObject(
				buildUri("flickr.places.findByLatLon", parameters),
				Places.class);
	}

	@Override
	public Places getChildrenWithPhotosPublic(String apiKey, String placeId,
			String woeId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		return restTemplate.getForObject(
				buildUri("flickr.places.getChildrenWithPhotosPublic",
						parameters), Places.class);
	}

	@Override
	public Place getInfo(String apiKey, String placeId, String woeId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		return restTemplate.getForObject(
				buildUri("flickr.places.getInfo", parameters), Place.class);
	}

	@Override
	public Place getInfoByUrl(String apiKey, String url) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (url != null)
			parameters.set("url", url);
		return restTemplate
				.getForObject(
						buildUri("flickr.places.getInfoByUrl", parameters),
						Place.class);
	}

	@Override
	public Place_types getPlaceTypes(String apiKey) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.places.getPlaceTypes", parameters),
				Place_types.class);
	}

	@Override
	public Shapes getShapeHistory(String apiKey, String placeId, String woeId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		return restTemplate.getForObject(
				buildUri("flickr.places.getShapeHistory", parameters),
				Shapes.class);
	}

	@Override
	public Places getTopPlacesList(String apiKey, String placeTypeId,
			String date, String woeId, String placeId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (placeTypeId != null)
			parameters.set("place_type_id", placeTypeId);
		if (date != null)
			parameters.set("date", date);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		if (placeId != null)
			parameters.set("place_id", placeId);
		return restTemplate.getForObject(
				buildUri("flickr.places.getTopPlacesList", parameters),
				Places.class);
	}

	@Override
	public void placesForBoundingBox(String apiKey, String bbox,
			String placeType, String placeTypeId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (bbox != null)
			parameters.set("bbox", bbox);
		if (placeType != null)
			parameters.set("place_type", placeType);
		if (placeTypeId != null)
			parameters.set("place_type_id", placeTypeId);
		restTemplate.getForObject(
				buildUri("flickr.places.placesForBoundingBox", parameters),
				Object.class);
	}

	@Override
	public void placesForContacts(String apiKey, String placeType,
			String placeTypeId, String woeId, String placeId, String threshold,
			String contacts, String minUploadDate, String maxUploadDate,
			String minTakenDate, String maxTakenDate) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (placeType != null)
			parameters.set("place_type", placeType);
		if (placeTypeId != null)
			parameters.set("place_type_id", placeTypeId);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (threshold != null)
			parameters.set("threshold", threshold);
		if (contacts != null)
			parameters.set("contacts", contacts);
		if (minUploadDate != null)
			parameters.set("min_upload_date", minUploadDate);
		if (maxUploadDate != null)
			parameters.set("max_upload_date", maxUploadDate);
		if (minTakenDate != null)
			parameters.set("min_taken_date", minTakenDate);
		if (maxTakenDate != null)
			parameters.set("max_taken_date", maxTakenDate);
		restTemplate.getForObject(
				buildUri("flickr.places.placesForContacts", parameters),
				Object.class);
	}

	@Override
	public void placesForTags(String apiKey, String placeTypeId, String woeId,
			String placeId, String threshold, String tags, String tagMode,
			String machineTags, String machineTagMode, String minUploadDate,
			String maxUploadDate, String minTakenDate, String maxTakenDate) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (placeTypeId != null)
			parameters.set("place_type_id", placeTypeId);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (threshold != null)
			parameters.set("threshold", threshold);
		if (tags != null)
			parameters.set("tags", tags);
		if (tagMode != null)
			parameters.set("tag_mode", tagMode);
		if (machineTags != null)
			parameters.set("machine_tags", machineTags);
		if (machineTagMode != null)
			parameters.set("machine_tag_mode", machineTagMode);
		if (minUploadDate != null)
			parameters.set("min_upload_date", minUploadDate);
		if (maxUploadDate != null)
			parameters.set("max_upload_date", maxUploadDate);
		if (minTakenDate != null)
			parameters.set("min_taken_date", minTakenDate);
		if (maxTakenDate != null)
			parameters.set("max_taken_date", maxTakenDate);
		restTemplate.getForObject(
				buildUri("flickr.places.placesForTags", parameters),
				Object.class);
	}

	@Override
	public void placesForUser(String apiKey, String placeTypeId,
			String placeType, String woeId, String placeId, String threshold,
			String minUploadDate, String maxUploadDate, String minTakenDate,
			String maxTakenDate) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (placeTypeId != null)
			parameters.set("place_type_id", placeTypeId);
		if (placeType != null)
			parameters.set("place_type", placeType);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (threshold != null)
			parameters.set("threshold", threshold);
		if (minUploadDate != null)
			parameters.set("min_upload_date", minUploadDate);
		if (maxUploadDate != null)
			parameters.set("max_upload_date", maxUploadDate);
		if (minTakenDate != null)
			parameters.set("min_taken_date", minTakenDate);
		if (maxTakenDate != null)
			parameters.set("max_taken_date", maxTakenDate);
		restTemplate.getForObject(
				buildUri("flickr.places.placesForUser", parameters),
				Object.class);
	}

	@Override
	public Location resolvePlaceId(String apiKey, String placeId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (placeId != null)
			parameters.set("place_id", placeId);
		return restTemplate.getForObject(
				buildUri("flickr.places.resolvePlaceId", parameters),
				Location.class);
	}

	@Override
	public Location resolvePlaceURL(String apiKey, String url) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (url != null)
			parameters.set("url", url);
		return restTemplate.getForObject(
				buildUri("flickr.places.resolvePlaceURL", parameters),
				Location.class);
	}

	@Override
	public Tags tagsForPlace(String apiKey, String woeId, String placeId,
			String minUploadDate, String maxUploadDate, String minTakenDate,
			String maxTakenDate) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (woeId != null)
			parameters.set("woe_id", woeId);
		if (placeId != null)
			parameters.set("place_id", placeId);
		if (minUploadDate != null)
			parameters.set("min_upload_date", minUploadDate);
		if (maxUploadDate != null)
			parameters.set("max_upload_date", maxUploadDate);
		if (minTakenDate != null)
			parameters.set("min_taken_date", minTakenDate);
		if (maxTakenDate != null)
			parameters.set("max_taken_date", maxTakenDate);
		return restTemplate.getForObject(
				buildUri("flickr.places.tagsForPlace", parameters), Tags.class);
	}
}