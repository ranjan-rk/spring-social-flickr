package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.MachinetagsOperations;
import org.springframework.social.flickr.api.Namespaces;
import org.springframework.social.flickr.api.Predicates;
import org.springframework.social.flickr.api.Values;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class MachinetagsTemplate extends AbstractFlickrOperations implements
		MachinetagsOperations {
	private final RestTemplate restTemplate;

	public MachinetagsTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Namespaces getNamespaces(String apiKey, String predicate,
			String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (predicate != null)
			parameters.set("predicate", predicate);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.machinetags.getNamespaces", parameters),
				Namespaces.class);
	}

	@Override
	public void getPairs(String apiKey, String namespace, String predicate,
			String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (namespace != null)
			parameters.set("namespace", namespace);
		if (predicate != null)
			parameters.set("predicate", predicate);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		restTemplate.getForObject(
				buildUri("flickr.machinetags.getPairs", parameters),
				Object.class);
	}

	@Override
	public Predicates getPredicates(String apiKey, String namespace,
			String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (namespace != null)
			parameters.set("namespace", namespace);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.machinetags.getPredicates", parameters),
				Predicates.class);
	}

	@Override
	public Values getRecentValues(String apiKey, String namespace,
			String predicate, String addedSince) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (namespace != null)
			parameters.set("namespace", namespace);
		if (predicate != null)
			parameters.set("predicate", predicate);
		if (addedSince != null)
			parameters.set("added_since", addedSince);
		return restTemplate.getForObject(
				buildUri("flickr.machinetags.getRecentValues", parameters),
				Values.class);
	}

	@Override
	public Values getValues(String apiKey, String namespace, String predicate,
			String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (namespace != null)
			parameters.set("namespace", namespace);
		if (predicate != null)
			parameters.set("predicate", predicate);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.machinetags.getValues", parameters),
				Values.class);
	}
}