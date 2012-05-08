package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.PrefsOperations;
import org.springframework.social.flickr.api.Rsp;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PrefsTemplate extends AbstractFlickrOperations implements
		PrefsOperations {
	private final RestTemplate restTemplate;

	public PrefsTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Rsp getContentType(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getContentType", parameters), Rsp.class);
	}

	@Override
	public Rsp getGeoPerms(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getGeoPerms", parameters), Rsp.class);
	}

	@Override
	public Rsp getHidden(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getHidden", parameters), Rsp.class);
	}

	@Override
	public Rsp getPrivacy(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getPrivacy", parameters), Rsp.class);
	}

	@Override
	public Rsp getSafetyLevel(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getSafetyLevel", parameters), Rsp.class);
	}
}