package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Domain;
import org.springframework.social.flickr.api.Domains;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.Stats;
import org.springframework.social.flickr.api.StatsOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class StatsTemplate extends AbstractFlickrOperations implements
		StatsOperations {
	private final RestTemplate restTemplate;

	public StatsTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public Domains getCollectionDomains(String apiKey, String date,
			String collectionId, String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (collectionId != null)
			parameters.set("collection_id", collectionId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getCollectionDomains", parameters),
				Domains.class);
	}

	@Override
	public Domain getCollectionReferrers(String apiKey, String date,
			String domain, String collectionId, String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (domain != null)
			parameters.set("domain", domain);
		if (collectionId != null)
			parameters.set("collection_id", collectionId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getCollectionReferrers", parameters),
				Domain.class);
	}

	@Override
	public Stats getCSVFiles(String apiKey) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getCSVFiles", parameters), Stats.class);
	}

	@Override
	public Domains getPhotoDomains(String apiKey, String date, String photoId,
			String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getPhotoDomains", parameters),
				Domains.class);
	}

	@Override
	public Domain getPhotoReferrers(String apiKey, String date, String domain,
			String photoId, String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (domain != null)
			parameters.set("domain", domain);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getPhotoReferrers", parameters),
				Domain.class);
	}

	@Override
	public Domains getPhotosetDomains(String apiKey, String date,
			String photosetId, String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (photosetId != null)
			parameters.set("photoset_id", photosetId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getPhotosetDomains", parameters),
				Domains.class);
	}

	@Override
	public Domain getPhotosetReferrers(String apiKey, String date,
			String domain, String photosetId, String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (domain != null)
			parameters.set("domain", domain);
		if (photosetId != null)
			parameters.set("photoset_id", photosetId);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getPhotosetReferrers", parameters),
				Domain.class);
	}

	@Override
	public Stats getPhotosetStats(String apiKey, String date, String photosetId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (photosetId != null)
			parameters.set("photoset_id", photosetId);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getPhotosetStats", parameters),
				Stats.class);
	}

	@Override
	public Stats getPhotoStats(String apiKey, String date, String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (photoId != null)
			parameters.set("photo_id", photoId);
		return restTemplate
				.getForObject(
						buildUri("flickr.stats.getPhotoStats", parameters),
						Stats.class);
	}

	@Override
	public Domains getPhotostreamDomains(String apiKey, String date,
			String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getPhotostreamDomains", parameters),
				Domains.class);
	}

	@Override
	public Domain getPhotostreamReferrers(String apiKey, String date,
			String domain, String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (domain != null)
			parameters.set("domain", domain);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getPhotostreamReferrers", parameters),
				Domain.class);
	}

	@Override
	public Stats getPhotostreamStats(String apiKey, String date) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getPhotostreamStats", parameters),
				Stats.class);
	}

	@Override
	public Photos getPopularPhotos(String apiKey, String date, String sort,
			String perPage, String page) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (sort != null)
			parameters.set("sort", sort);
		if (perPage != null)
			parameters.set("per_page", perPage);
		if (page != null)
			parameters.set("page", page);
		return restTemplate.getForObject(
				buildUri("flickr.stats.getPopularPhotos", parameters),
				Photos.class);
	}

	@Override
	public Stats getTotalViews(String apiKey, String date) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		return restTemplate
				.getForObject(
						buildUri("flickr.stats.getTotalViews", parameters),
						Stats.class);
	}

	@Override
	public Stats getCollectionStats(String apiKey, String date,
			String collectionId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (apiKey != null)
			parameters.set("api_key", apiKey);
		if (date != null)
			parameters.set("date", date);
		if (collectionId != null)
			parameters.set("collection_id", collectionId);
		return restTemplate.getForObject(buildUri("flickr.stats.getCollectionStats", parameters),Stats.class);
	}
}