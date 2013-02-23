package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Galleries;
import org.springframework.social.flickr.api.GalleriesOperations;
import org.springframework.social.flickr.api.Gallery;
import org.springframework.social.flickr.api.Photos;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class GalleriesTemplate extends AbstractFlickrOperations implements
		GalleriesOperations {
	private final RestTemplate restTemplate;

	public GalleriesTemplate(RestTemplate restTemplate,
			boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public boolean addPhoto(String galleryId, String photoId,
			String comment) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (comment != null)
			parameters.set("comment", comment);
		restTemplate.postForObject(buildUri("flickr.galleries.addPhoto"),parameters, Object.class);
		return true;
	}

	@Override
	public Gallery create(String title, String description,
			String primaryPhotoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
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
	public boolean editMeta(String galleryId, String title,
			String description) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		if (title != null)
			parameters.set("title", title);
		if (description != null)
			parameters.set("description", description);
		restTemplate.postForObject(buildUri("flickr.galleries.editMeta"),
				parameters, Object.class);
		return true;
	}

	@Override
	public boolean editPhoto(String galleryId, String photoId,
			String comment) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (comment != null)
			parameters.set("comment", comment);
		restTemplate.postForObject(buildUri("flickr.galleries.editPhoto"),
				parameters, Object.class);
		return true;
	}

	@Override
	public boolean editPhotos(String galleryId,
			String primaryPhotoId, String[] photoIds) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		if (primaryPhotoId != null)
			parameters.set("primary_photo_id", primaryPhotoId);
		if (photoIds != null)
			parameters.set("photo_ids", StringUtils.arrayToCommaDelimitedString(photoIds));
		restTemplate.postForObject(buildUri("flickr.galleries.editPhotos"),
				parameters, Object.class);
		return true;
	}

	@Override
	public Gallery getInfo(String galleryId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (galleryId != null)
			parameters.set("gallery_id", galleryId);
		return restTemplate
				.getForObject(buildUri("flickr.galleries.getInfo", parameters),
						Gallery.class);
	}

	@Override
	public Galleries getList(String userId, String perPage,
			String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		
			
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
	public Galleries getListForPhoto(String photoId, String perPage,
			String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		
			
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.galleries.getListForPhoto", parameters),
				Galleries.class);
	}

	@Override
	public Photos getPhotos(String galleryId, String extras,
			String perPage, String page) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		
			
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