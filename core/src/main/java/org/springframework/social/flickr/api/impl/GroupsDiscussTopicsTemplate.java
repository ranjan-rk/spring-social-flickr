package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.GroupsDiscussTopicsOperations;
import org.springframework.social.flickr.api.Topic;
import org.springframework.social.flickr.api.Topics;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * The Class GroupsDiscussTopicsTemplate.
 * 
 * @author HemantS
 */
public class GroupsDiscussTopicsTemplate extends AbstractFlickrOperations
		implements GroupsDiscussTopicsOperations {
	private final RestTemplate restTemplate;

	public GroupsDiscussTopicsTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey) {
		super(isAuthorizedForUser, consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Topic add(String groupId, String subject, String message) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (groupId != null)
			parameters.set("group_id", groupId);
		if (subject != null)
			parameters.set("subject", subject);
		if (message != null)
			parameters.set("message", message);
		return restTemplate.postForObject(buildUri("flickr.groups.discuss.topics.add"),parameters, Topic.class);
	}

	@Override
	public Topic getInfo(String topicId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (topicId != null)
			parameters.set("topic_id", topicId);
		return restTemplate.getForObject(buildUri("flickr.groups.discuss.topics.add",parameters), Topic.class);
	}

	@Override
	public Topics getList(String groupId, String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (groupId != null)
			parameters.set("group_id", groupId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(buildUri("flickr.groups.discuss.topics.getList",parameters), Topics.class);
	}

}
