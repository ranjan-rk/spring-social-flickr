package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Auth;
import org.springframework.social.flickr.api.AuthOperations;
import org.springframework.social.flickr.api.Frob;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 * 
 */
public class AuthTemplate extends AbstractFlickrOperations implements
		AuthOperations {
	private final RestTemplate restTemplate;

	public AuthTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Auth checkToken(String apiKey, String authToken) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (authToken != null)
			parameters.set("auth_token", authToken);
		return restTemplate.getForObject(
				buildUri("flickr.auth.checkToken", parameters), Auth.class);
	}

	@Override
	public Frob getFrob(String apiKey) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.auth.getFrob", parameters), Frob.class);
	}

	@Override
	public Auth getToken(String apiKey, String frob) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (frob != null)
			parameters.set("frob", frob);
		return restTemplate.getForObject(
				buildUri("flickr.auth.getToken", parameters), Auth.class);
	}

	@Override
	public Auth getFullToken(String apiKey, String miniToken) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (miniToken != null)
			parameters.set("mini_token", miniToken);
		return restTemplate.getForObject(buildUri("flickr.auth.getFullToken",parameters), Auth.class);
	}
}