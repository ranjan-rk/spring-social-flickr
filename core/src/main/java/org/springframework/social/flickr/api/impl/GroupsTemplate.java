package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Category;
import org.springframework.social.flickr.api.Group2;
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

	public GroupsTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser, String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Category browse(String catId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (catId != null)
			parameters.set("cat_id", catId);
		return restTemplate.getForObject(
				buildUri("flickr.groups.browse", parameters), Category.class);
	}

	@Override
	public Group2 getInfo(String groupId, String lang) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (groupId != null)
			parameters.set("group_id", groupId);
		if (lang != null)
			parameters.set("lang", lang);
		return restTemplate.getForObject(
				buildUri("flickr.groups.getInfo", parameters), Group2.class);
	}

	@Override
	public Groups search(String text, String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (text != null)
			parameters.set("text", text);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.groups.search", parameters), Groups.class);
	}

	@Override
	public boolean join(String groupId, String acceptRules) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (groupId != null)
			parameters.set("group_id", groupId);
		if (acceptRules != null)
			parameters.set("accept_rules", acceptRules);
		restTemplate.postForObject(buildUri("flickr.groups.join"),parameters, Object.class);
		return true;
	}
	
	@Override
	public boolean joinRequest(String groupId, String message,
			String acceptRules) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (groupId != null)
			parameters.set("group_id", groupId);
		if (message != null)
			parameters.set("message", message);
		if (acceptRules != null)
			parameters.set("accept_rules", acceptRules);
		restTemplate.postForObject(buildUri("flickr.groups.joinRequest"),parameters, Object.class);
		return true;
	}
	
	@Override
	public boolean leave(String groupId, String deletePhotos) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (groupId != null)
			parameters.set("group_id", groupId);
		if (deletePhotos != null)
			parameters.set("delete_photos", deletePhotos);
		restTemplate.postForObject(buildUri("flickr.groups.leave"),parameters, Object.class);
		return true;
	}


}