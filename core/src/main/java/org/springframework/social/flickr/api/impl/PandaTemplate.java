package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.PandaOperations;
import org.springframework.social.flickr.api.Pandas;
import org.springframework.social.flickr.api.Photos;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 * 
 */
public class PandaTemplate extends AbstractFlickrOperations implements
		PandaOperations {
	private final RestTemplate restTemplate;

	public PandaTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Pandas getList(String apiKey) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(buildUri("flickr.panda.getList",parameters), Pandas.class);
	}

	@Override
	public Photos getPhotos(String apiKey, String pandaName, String extras,
			String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (pandaName != null)
			parameters.set("panda_name", pandaName);
		if (extras != null)
			parameters.set("extras", extras);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(buildUri("flickr.panda.getPhotos",parameters), Photos.class);
	}
}