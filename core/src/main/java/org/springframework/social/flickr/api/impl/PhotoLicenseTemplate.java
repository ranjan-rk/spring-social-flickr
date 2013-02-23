package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.LicenseEnum;
import org.springframework.social.flickr.api.Licenses;
import org.springframework.social.flickr.api.PhotoLicenseOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PhotoLicenseTemplate extends AbstractFlickrOperations implements PhotoLicenseOperations {
	
private final RestTemplate restTemplate;
	
	public PhotoLicenseTemplate(RestTemplate restTemplate,boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public Licenses getInfo() {
		return restTemplate.getForObject(buildUri("flickr.photos.licenses.getInfo"), Licenses.class);
	}

	@Override
	public boolean setLicense(String photoId, LicenseEnum license) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("license_id", license.getLicense());
		restTemplate.postForObject(buildUri("flickr.photos.licenses.setLicense"),parameters, Object.class);
		return true;
	}

}
