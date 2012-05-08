package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Method;
import org.springframework.social.flickr.api.TestOperations;
import org.springframework.social.flickr.api.User;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 * 
 */
public class TestTemplate extends AbstractFlickrOperations implements
		TestOperations {
	private final RestTemplate restTemplate;

	public TestTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public User login(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.test.login", parameters), User.class);
	}

	@Override
	public void Null(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		restTemplate.getForObject(buildUri("flickr.test.null", parameters),
				Object.class);
	}

	@Override
	public Method echo(String apiKey) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.test.echo", parameters), Method.class);
	}

}