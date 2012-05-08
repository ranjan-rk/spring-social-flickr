package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Category;
import org.springframework.social.flickr.api.Group;
import org.springframework.social.flickr.api.Groups;
import org.springframework.social.flickr.api.GroupsOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class GroupsTemplate extends AbstractFlickrOperations implements
		GroupsOperations {
	private final RestTemplate restTemplate;

	public GroupsTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Category browse(String apiKey, String catId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (catId != null)
			parameters.set("cat_id", catId);
		return restTemplate.getForObject(
				buildUri("flickr.groups.browse", parameters), Category.class);
	}

	@Override
	public Group getInfo(String apiKey, String groupId, String lang) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (groupId != null)
			parameters.set("group_id", groupId);
		if (lang != null)
			parameters.set("lang", lang);
		return restTemplate.getForObject(
				buildUri("flickr.groups.getInfo", parameters), Group.class);
	}

	@Override
	public Groups search(String apiKey, String text, String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (text != null)
			parameters.set("text", text);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.groups.search", parameters), Groups.class);
	}
}