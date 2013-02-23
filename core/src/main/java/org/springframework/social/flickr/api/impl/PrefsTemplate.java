package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.PrefsOperations;
import org.springframework.social.flickr.api.Person;
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

	public PrefsTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Person getContentType() {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getContentType", parameters), Person.class);
	}

	@Override
	public Person getGeoPerms() {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getGeoPerms", parameters), Person.class);
	}

	@Override
	public Person getHidden() {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getHidden", parameters), Person.class);
	}

	@Override
	public Person getPrivacy() {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getPrivacy", parameters), Person.class);
	}

	@Override
	public Person getSafetyLevel() {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		return restTemplate.getForObject(
				buildUri("flickr.prefs.getSafetyLevel", parameters), Person.class);
	}
}