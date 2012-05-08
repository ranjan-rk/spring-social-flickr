package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Auth;
import org.springframework.social.flickr.api.AuthOauthOperations;
import org.springframework.social.flickr.api.Oauth;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class AuthOauthTemplate extends AbstractFlickrOperations implements
		AuthOauthOperations {
	private final RestTemplate restTemplate;

	public AuthOauthTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Oauth checkToken(String apiKey, String oauthToken) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (oauthToken != null)
			parameters.set("oauth_token", oauthToken);
		return restTemplate.getForObject(
				buildUri("flickr.auth.oauth.checkToken", parameters),
				Oauth.class);
	}

	@Override
	public Auth getAccessToken(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.auth.oauth.getAccessToken", parameters),
				Auth.class);
	}
}