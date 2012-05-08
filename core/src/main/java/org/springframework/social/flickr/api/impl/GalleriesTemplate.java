package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Galleries;
import org.springframework.social.flickr.api.GalleriesOperations;
import org.springframework.social.flickr.api.Gallery;
import org.springframework.social.flickr.api.Photos;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class GalleriesTemplate extends AbstractFlickrOperations implements
		GalleriesOperations {
	private final RestTemplate restTemplate;

	public GalleriesTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public void addPhoto(String apiKey, String galleryId, String photoId,
			String comment) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (comment != null)
			parameters.set("comment", comment);
		restTemplate.postForObject(buildUri("flickr.galleries.addPhoto"),
				parameters, Object.class);
	}

	@Override
	public Gallery create(String apiKey, String title, String description,
			String primaryPhotoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (title != null)
			parameters.set("title", title);
		if (description != null)
			parameters.set("description", description);
		if (primaryPhotoId != null)
			parameters.set("primary_photo_id", primaryPhotoId);
		return restTemplate.postForObject(buildUri("flickr.galleries.create"),
				parameters, Gallery.class);
	}

	@Override
	public void editMeta(String apiKey, String galleryId, String title,
			String description) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		if (title != null)
			parameters.set("title", title);
		if (description != null)
			parameters.set("description", description);
		restTemplate.postForObject(buildUri("flickr.galleries.editMeta"),
				parameters, Object.class);
	}

	@Override
	public void editPhoto(String apiKey, String galleryId, String photoId,
			String comment) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (comment != null)
			parameters.set("comment", comment);
		restTemplate.postForObject(buildUri("flickr.galleries.editPhoto"),
				parameters, Object.class);
	}

	@Override
	public void editPhotos(String apiKey, String galleryId,
			String primaryPhotoId, String photoIds) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		if (primaryPhotoId != null)
			parameters.set("primary_photo_id", primaryPhotoId);
		if (photoIds != null)
			parameters.set("photo_ids", photoIds);
		restTemplate.postForObject(buildUri("flickr.galleries.editPhotos"),
				parameters, Object.class);
	}

	@Override
	public Gallery getInfo(String apiKey, String galleryId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		return restTemplate
				.getForObject(buildUri("flickr.galleries.getInfo", parameters),
						Gallery.class);
	}

	@Override
	public Galleries getList(String apiKey, String userId, String perPage,
			String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (userId != null)
			parameters.set("user_id", userId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.galleries.getList", parameters),
				Galleries.class);
	}

	@Override
	public void getListForPhoto(String apiKey, String photoId, String perPage,
			String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		restTemplate.getForObject(
				buildUri("flickr.galleries.getListForPhoto", parameters),
				Object.class);
	}

	@Override
	public Photos getPhotos(String apiKey, String galleryId, String extras,
			String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		if (extras != null)
			parameters.set("extras", extras);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.galleries.getPhotos", parameters),
				Photos.class);
	}
}