package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.PhotoOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class PhotoTemplate extends AbstractFlickrOperations implements PhotoOperations {
	private final RestTemplate restTemplate;
	
	public PhotoTemplate(RestTemplate restTemplate,boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}
	
	@Override
	public boolean addTags(String photoId, String[] tagList) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("tags", toCommaList(tagList));
		restTemplate.postForObject(buildUri("flickr.photos.addTags",parameters), new LinkedMultiValueMap<String, String>(), Object.class);
		return false;
	}
	
	private String toCommaList(String[] a){
		if (a == null)
            return "null";
	int iMax = a.length - 1;
	if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        
        for (int i = 0; ; i++) {
            b.append(a[i]);
	    if (i == iMax)
		return b.toString();
            b.append(", ");
        }
	}
}
