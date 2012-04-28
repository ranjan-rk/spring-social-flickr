package org.springframework.social.flickr.api.impl;

import java.util.List;

import org.springframework.social.flickr.api.PhotoCount;
import org.springframework.social.flickr.api.Photoset;
import org.springframework.social.flickr.api.PhotosetOperations;
import org.springframework.social.flickr.api.Photosets;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

public class PhotosetTemplate extends AbstractFlickrOperations implements PhotosetOperations {
	private final RestTemplate restTemplate;
	
	public PhotosetTemplate(RestTemplate restTemplate,boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Photoset create(String title, String description,
			String primaryPhotoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("title", title);
		if(description!=null){
			parameters.set("description", description);
		}
		parameters.set("primary_photo_id", primaryPhotoId);
		return restTemplate.postForObject(buildUri("flickr.photosets.create"), parameters, Photoset.class);
	}

	@Override
	public boolean addPhoto(String photosetId, String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photoset_id", photosetId);
		restTemplate.postForObject(buildUri("flickr.photosets.addPhoto"), parameters, Object.class);
		return true;
	}

	@Override
	public boolean editMeta(String photosetId, String title, String description) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photoset_id", photosetId);
		parameters.set("title", title);
		parameters.set("description", description);
		restTemplate.postForObject(buildUri("flickr.photosets.editMeta"), parameters, Object.class);
		return true;
	}

	@Override
	public boolean editPhotos(String photosetId, String primaryPhotoId,
			List<String> photoIds) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photoset_id", photosetId);
		parameters.set("primary_photo_id ", primaryPhotoId);
		parameters.set("photo_ids", StringUtils.arrayToCommaDelimitedString(photoIds.toArray()));
		restTemplate.postForObject(buildUri("flickr.photosets.editPhotos"), parameters, Object.class);
		return true;
	}

	@Override
	public Photoset getInfo(String photosetId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photoset_id", photosetId);		
		return restTemplate.postForObject(buildUri("flickr.photosets.getInfo"), parameters, Photoset.class);
	}

	@Override
	public Photosets getList(String userId, String page , String perPage) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("user_id", userId);	
		if(page!=null){
			parameters.set("page", page);	
		}
		if(perPage!=null){
			parameters.set("per_page", perPage);	
		}
		return restTemplate.postForObject(buildUri("flickr.photosets.getList"), parameters, Photosets.class);
	}

	
	/* Need to handle in special way
	@Override
	public PhotoCount getContext(String photoId, String photosetId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id ", photoId);
		parameters.set("photoset_id", photosetId);
		return restTemplate.postForObject(buildUri("flickr.photosets.getContext"), parameters, PhotoCount.class);
	}
	*/
}
