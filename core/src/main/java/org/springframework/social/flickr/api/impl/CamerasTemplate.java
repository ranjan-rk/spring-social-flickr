package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Brands;
import org.springframework.social.flickr.api.Cameras;
import org.springframework.social.flickr.api.CamerasOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class CamerasTemplate extends AbstractFlickrOperations implements CamerasOperations {
	private final RestTemplate restTemplate;
	
	public CamerasTemplate(RestTemplate restTemplate, boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}
	
	@Override
	public Cameras getBrandModels(String brand) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		if (brand != null)
			parameters.set("brand", brand);
		return restTemplate.getForObject(buildUri("flickr.cameras.getBrandModels", parameters), Cameras.class);
	}

	@Override
	public Brands getBrands() {
		return restTemplate.getForObject(buildUri("flickr.cameras.getBrands"), Brands.class);
	}

}
