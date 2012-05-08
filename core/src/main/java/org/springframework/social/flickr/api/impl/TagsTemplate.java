package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Clusters;
import org.springframework.social.flickr.api.Hottags;
import org.springframework.social.flickr.api.Photo;
import org.springframework.social.flickr.api.Rsp;
import org.springframework.social.flickr.api.Tags;
import org.springframework.social.flickr.api.TagsOperations;
import org.springframework.social.flickr.api.Who;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class TagsTemplate extends AbstractFlickrOperations implements
		TagsOperations {
	private final RestTemplate restTemplate;

	public TagsTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public void getClusterPhotos(String apiKey, String tag, String clusterId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (tag != null)
			parameters.set("tag", tag);
		if (clusterId != null)
			parameters.set("cluster_id", clusterId);
		restTemplate.getForObject(
				buildUri("flickr.tags.getClusterPhotos", parameters),
				Object.class);
	}

	@Override
	public Clusters getClusters(String apiKey, String tag) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (tag != null)
			parameters.set("tag", tag);
		return restTemplate
				.getForObject(buildUri("flickr.tags.getClusters", parameters),
						Clusters.class);
	}

	@Override
	public Hottags getHotList(String apiKey, String period, String count) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (period != null)
			parameters.set("period", period);
		if (count != null)
			parameters.set("count", count);
		return restTemplate.getForObject(
				buildUri("flickr.tags.getHotList", parameters), Hottags.class);
	}

	@Override
	public Photo getListPhoto(String apiKey, String photoId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		return restTemplate.getForObject(
				buildUri("flickr.tags.getListPhoto", parameters), Photo.class);
	}

	@Override
	public Who getListUser(String apiKey, String userId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (userId != null)
			parameters.set("user_id", userId);
		return restTemplate.getForObject(
				buildUri("flickr.tags.getListUser", parameters), Who.class);
	}

	@Override
	public Who getListUserPopular(String apiKey, String userId, String count) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (userId != null)
			parameters.set("user_id", userId);
		if (count != null)
			parameters.set("count", count);
		return restTemplate.getForObject(
				buildUri("flickr.tags.getListUserPopular", parameters),
				Who.class);
	}

	@Override
	public Who getListUserRaw(String apiKey, String tag) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (tag != null)
			parameters.set("tag", tag);
		return restTemplate.getForObject(
				buildUri("flickr.tags.getListUserRaw", parameters), Who.class);
	}

	@Override
	public Rsp getMostFrequentlyUsed(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.tags.getMostFrequentlyUsed", parameters),
				Rsp.class);
	}

	@Override
	public Tags getRelated(String apiKey, String tag) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (tag != null)
			parameters.set("tag", tag);
		return restTemplate.getForObject(
				buildUri("flickr.tags.getRelated", parameters), Tags.class);
	}
}