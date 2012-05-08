package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.PushOperations;
import org.springframework.social.flickr.api.Rsp;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PushTemplate extends AbstractFlickrOperations implements
		PushOperations {
	private final RestTemplate restTemplate;

	public PushTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Rsp getSubscriptions(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate
				.getForObject(
						buildUri("flickr.push.getSubscriptions", parameters),
						Rsp.class);
	}

	@Override
	public Rsp getTopics(String apiKey) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.push.getTopics", parameters), Rsp.class);
	}

	@Override
	public void subscribe(String apiKey, String topic, String callback,
			String verify, String verifyToken, String leaseSeconds,
			String woeIds, String placeIds, String lat, String lon,
			String radius, String radiusUnits, String accuracy, String nsids,
			String tags) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (topic != null)
			parameters.set("topic", topic);
		if (callback != null)
			parameters.set("callback", callback);
		if (verify != null)
			parameters.set("verify", verify);
		if (verifyToken != null)
			parameters.set("verify_token", verifyToken);
		if (leaseSeconds != null)
			parameters.set("lease_seconds", leaseSeconds);
		if (woeIds != null)
			parameters.set("woe_ids", woeIds);
		if (placeIds != null)
			parameters.set("place_ids", placeIds);
		if (lat != null)
			parameters.set("lat", lat);
		if (lon != null)
			parameters.set("lon", lon);
		if (radius != null)
			parameters.set("radius", radius);
		if (radiusUnits != null)
			parameters.set("radius_units", radiusUnits);
		if (accuracy != null)
			parameters.set("accuracy", accuracy);
		if (nsids != null)
			parameters.set("nsids", nsids);
		if (tags != null)
			parameters.set("tags", tags);
		restTemplate.getForObject(
				buildUri("flickr.push.subscribe", parameters), Object.class);
	}

	@Override
	public void unsubscribe(String apiKey, String topic, String callback,
			String verify, String verifyToken) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (topic != null)
			parameters.set("topic", topic);
		if (callback != null)
			parameters.set("callback", callback);
		if (verify != null)
			parameters.set("verify", verify);
		if (verifyToken != null)
			parameters.set("verify_token", verifyToken);
		restTemplate.getForObject(
				buildUri("flickr.push.unsubscribe", parameters), Object.class);
	}
}