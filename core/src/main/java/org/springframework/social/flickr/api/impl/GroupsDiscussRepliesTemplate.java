package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.GroupsDiscussRepliesOperations;
import org.springframework.social.flickr.api.Replies;
import org.springframework.social.flickr.api.Reply;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * The Class GroupsDiscussRepliesTemplate.
 * 
 * @author HemantS
 */
public class GroupsDiscussRepliesTemplate extends AbstractFlickrOperations
		implements GroupsDiscussRepliesOperations {
	private final RestTemplate restTemplate;

	public GroupsDiscussRepliesTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser, String consumerKey) {
		super(isAuthorizedForUser, consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Reply add(String topicId, String message) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (message != null)
			parameters.set("message", message);
		if (topicId != null)
			parameters.set("topic_id", topicId);
		return restTemplate.postForObject(buildUri("flickr.groups.discuss.replies.add"),parameters, Reply.class);
		
	}

	@Override
	public boolean delete(String topicId, String replyId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (replyId != null)
			parameters.set("reply_id", replyId);
		if (topicId != null)
			parameters.set("topic_id", topicId);
		restTemplate.postForObject(buildUri("flickr.groups.discuss.replies.delete"),parameters, Object.class);
		return true;
	}

	@Override
	public boolean edit(String topicId, String replyId, String message) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (replyId != null)
			parameters.set("reply_id", replyId);
		if (topicId != null)
			parameters.set("topic_id", topicId);
		if (message != null)
			parameters.set("message", message);
		restTemplate.postForObject(buildUri("flickr.groups.discuss.replies.edit"),parameters, Object.class);
		return true;
	}

	@Override
	public Reply getInfo(String topicId, String replyId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (replyId != null)
			parameters.set("reply_id", replyId);
		if (topicId != null)
			parameters.set("topic_id", topicId);
		return restTemplate.getForObject(buildUri("flickr.groups.discuss.replies.getInfo",parameters), Reply.class);
		
	}

	@Override
	public Replies getList(String topicId, String replyId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (replyId != null)
			parameters.set("reply_id", replyId);
		if (topicId != null)
			parameters.set("topic_id", topicId);
		return restTemplate.getForObject(buildUri("flickr.groups.discuss.replies.getList",parameters), Replies.class);
	}
}
