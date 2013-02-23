package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.GroupsMembersOperations;
import org.springframework.social.flickr.api.Members;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class GroupsMembersTemplate extends AbstractFlickrOperations implements
		GroupsMembersOperations {
	private final RestTemplate restTemplate;

	public GroupsMembersTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Members getList(String groupId, String membertypes,
			String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (groupId != null)
			parameters.set("group_id", groupId);
		if (membertypes != null)
			parameters.set("membertypes", membertypes);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.groups.members.getList", parameters),
				Members.class);
	}
}