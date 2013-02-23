package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Contacts;
import org.springframework.social.flickr.api.ContactsOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class ContactsTemplate extends AbstractFlickrOperations implements
		ContactsOperations {
	private final RestTemplate restTemplate;

	public ContactsTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public void getListRecentlyUploaded(String dateLastupload,
			String filter) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (dateLastupload != null)
			parameters.set("date_lastupload", dateLastupload);
		if (filter != null)
			parameters.set("filter", filter);
		restTemplate
				.getForObject(
						buildUri("flickr.contacts.getListRecentlyUploaded",
								parameters), Object.class);
	}

	@Override
	public Contacts getPublicList(String userId, String page,
			String perPage) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (userId != null)
			parameters.set("user_id", userId);
		if (page != null)
			parameters.set("page", page);
		if (perPage != null)
			parameters.set("per_page", perPage);
		return restTemplate.getForObject(
				buildUri("flickr.contacts.getPublicList", parameters),
				Contacts.class);
	}

	@Override
	public Contacts getTaggingSuggestions(String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.contacts.getTaggingSuggestions", parameters),
				Contacts.class);
	}

	@Override
	public Contacts getList(String filter, String page, String perPage,String sort) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (filter != null)
			parameters.set("filter", filter);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		if (sort != null)
			parameters.set("sort", sort);
		return restTemplate.getForObject(buildUri("flickr.contacts.getList", parameters),Contacts.class);
	}
}