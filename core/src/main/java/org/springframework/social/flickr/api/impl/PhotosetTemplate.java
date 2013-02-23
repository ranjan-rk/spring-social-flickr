package org.springframework.social.flickr.api.impl;

import java.util.List;

import org.springframework.social.flickr.api.MediaEnum;
import org.springframework.social.flickr.api.Photoset;
import org.springframework.social.flickr.api.PhotosetOperations;
import org.springframework.social.flickr.api.Photosets;
import org.springframework.social.flickr.api.PrivacyFilterEnum;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 * 
 */
public class PhotosetTemplate extends AbstractFlickrOperations implements
		PhotosetOperations {
	private final RestTemplate restTemplate;

	public PhotosetTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Photoset create(String title, String description,
			String primaryPhotoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("title", title);
		if (description != null) {
			parameters.set("description", description);
		}
		parameters.set("primary_photo_id", primaryPhotoId);
		return restTemplate.postForObject(buildUri("flickr.photosets.create"),
				parameters, Photoset.class);
	}

	@Override
	public boolean addPhoto(String photosetId, String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photoset_id", photosetId);
		restTemplate.postForObject(buildUri("flickr.photosets.addPhoto"),
				parameters, Object.class);
		return true;
	}

	@Override
	public boolean editMeta(String photosetId, String title, String description) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photoset_id", photosetId);
		parameters.set("title", title);
		parameters.set("description", description);
		restTemplate.postForObject(buildUri("flickr.photosets.editMeta"),
				parameters, Object.class);
		return true;
	}

	@Override
	public boolean editPhotos(String photosetId, String primaryPhotoId,
			List<String> photoIds) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photoset_id", photosetId);
		parameters.set("primary_photo_id ", primaryPhotoId);
		parameters.set("photo_ids",
				StringUtils.arrayToCommaDelimitedString(photoIds.toArray()));
		restTemplate.postForObject(buildUri("flickr.photosets.editPhotos"),
				parameters, Object.class);
		return true;
	}

	@Override
	public Photoset getInfo(String photosetId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photoset_id", photosetId);
		return restTemplate.postForObject(buildUri("flickr.photosets.getInfo"),
				parameters, Photoset.class);
	}

	@Override
	public Photosets getList(String userId, String page, String perPage) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("user_id", userId);
		if (page != null) {
			parameters.set("page", page);
		}
		if (perPage != null) {
			parameters.set("per_page", perPage);
		}
		return restTemplate.postForObject(buildUri("flickr.photosets.getList"),
				parameters, Photosets.class);
	}

	@Override
	public boolean delete(String photosetId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photosetId != null)
			parameters.set("photoset_id", photosetId);
		restTemplate.postForObject(buildUri("flickr.photosets.delete"),parameters, Object.class);
		return true;
	}

	@Override
	public Photoset getPhotos(String photosetId, String[] extras,
			PrivacyFilterEnum privacyFilter, String perPage, String page, MediaEnum media) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photosetId != null)
			parameters.set("photoset_id", photosetId);
		if (extras != null)
			parameters.set("extras", StringUtils.arrayToCommaDelimitedString(extras));
		if (privacyFilter != null)
			parameters.set("privacy_filter", privacyFilter.getPrivacy());
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		if (media != null)
			parameters.set("media", media.getMediaEnum());
		return restTemplate.getForObject(buildUri("flickr.photosets.getPhotos", parameters),Photoset.class);
	}

	@Override
	public boolean orderSets(String[] photosetIds) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photosetIds != null)
			parameters.set("photoset_ids",StringUtils.arrayToCommaDelimitedString(photosetIds));
		restTemplate.postForObject(buildUri("flickr.photosets.orderSets"),parameters, Object.class);
		return true;
	}

	@Override
	public boolean removePhoto(String photosetId, String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photosetId != null)
			parameters.set("photoset_id", photosetId);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		restTemplate.postForObject(buildUri("flickr.photosets.removePhoto"),
				parameters, Object.class);
		return true;
	}

	@Override
	public boolean removePhotos(String photosetId, String photoIds[]) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photosetId != null)
			parameters.set("photoset_id",photosetId);
		if (photoIds != null)
			parameters.set("photo_ids",  StringUtils.arrayToCommaDelimitedString(photoIds));
		restTemplate.postForObject(buildUri("flickr.photosets.removePhotos"),
				parameters, Object.class);
		return true;
	}

	@Override
	public boolean reorderPhotos(String photosetId, String[] photoIds) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photosetId != null)
			parameters.set("photoset_id", photosetId);
		if (photoIds != null)
			parameters.set("photo_ids",StringUtils.arrayToCommaDelimitedString(photoIds));
		restTemplate.postForObject(buildUri("flickr.photosets.reorderPhotos"),
				parameters, Object.class);
		return true;
	}

	@Override
	public boolean setPrimaryPhoto(String photosetId, String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (photosetId != null)
			parameters.set("photoset_id", photosetId);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		restTemplate.postForObject(
				buildUri("flickr.photosets.setPrimaryPhoto"), parameters,
				Object.class);
		return true;
	}

	/*
	 * Need to handle in special way
	 * 
	 * @Override public PhotoCount getContext(String photoId, String photosetId)
	 * { MultiValueMap<String, String> parameters = new
	 * LinkedMultiValueMap<String, String>(); parameters.set("photo_id ",
	 * photoId); parameters.set("photoset_id", photosetId); return
	 * restTemplate.postForObject(buildUri("flickr.photosets.getContext"),
	 * parameters, PhotoCount.class); }
	 */
}
