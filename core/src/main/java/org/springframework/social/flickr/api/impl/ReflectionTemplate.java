package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Method;
import org.springframework.social.flickr.api.Methods;
import org.springframework.social.flickr.api.ReflectionOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class ReflectionTemplate extends AbstractFlickrOperations implements
		ReflectionOperations {
	private final RestTemplate restTemplate;

	public ReflectionTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Method getMethodInfo(String methodName) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (methodName != null)
			parameters.set("method_name", methodName);
		return restTemplate.getForObject(
				buildUri("flickr.reflection.getMethodInfo", parameters),
				Method.class);
	}

	@Override
	public Methods getMethods() {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		return restTemplate.getForObject(
				buildUri("flickr.reflection.getMethods", parameters),
				Methods.class);
	}
}