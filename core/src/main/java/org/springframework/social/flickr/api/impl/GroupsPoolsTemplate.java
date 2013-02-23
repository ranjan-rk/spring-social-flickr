package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Groups;
import org.springframework.social.flickr.api.GroupsPoolsOperations;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.Prevphoto;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class GroupsPoolsTemplate extends AbstractFlickrOperations implements
		GroupsPoolsOperations {
	private final RestTemplate restTemplate;

	public GroupsPoolsTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean add(String photoId, String groupId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (groupId != null)
			parameters.set("group_id", groupId);
		restTemplate.postForObject(buildUri("flickr.groups.pools.add"),
				parameters, Object.class);
		return true;
	}

	@Override
	public Prevphoto getContext(String photoId, String groupId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (groupId != null)
			parameters.set("group_id", groupId);
		return restTemplate.getForObject(
				buildUri("flickr.groups.pools.getContext", parameters),
				Prevphoto.class);
	}

	@Override
	public Groups getGroups(String page, String perPage) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (page != null)
			parameters.set("page", page);
		if (perPage != null)
			parameters.set("per_page", perPage);
		return restTemplate.getForObject(
				buildUri("flickr.groups.pools.getGroups", parameters),
				Groups.class);
	}

	@Override
	public Photos getPhotos(String groupId, String tags,
			String userId, String extras, String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (groupId != null)
			parameters.set("group_id", groupId);
		if (tags != null)
			parameters.set("tags", tags);
		if (userId != null)
			parameters.set("user_id", userId);
		if (extras != null)
			parameters.set("extras", extras);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.groups.pools.getPhotos", parameters),
				Photos.class);
	}

	@Override
	public boolean remove(String photoId, String groupId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (groupId != null)
			parameters.set("group_id", groupId);
		restTemplate.postForObject(buildUri("flickr.groups.pools.remove"),
				parameters, Object.class);
		return true;
	}
}