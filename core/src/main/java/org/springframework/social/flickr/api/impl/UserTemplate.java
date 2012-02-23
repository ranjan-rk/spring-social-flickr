package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Person;
import org.springframework.social.flickr.api.User;
import org.springframework.social.flickr.api.UserOperations;
import org.springframework.web.client.RestTemplate;

public class UserTemplate extends AbstractFlickrOperations implements UserOperations{

	private final RestTemplate restTemplate;
	
	public UserTemplate(RestTemplate restTemplate,boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public String getProfileId() {
		User testUser = restTemplate.getForObject(buildUri("flickr.test.login"),  User.class);
		return testUser.getId();
	}

	@Override
	public Person getUserProfile() {
		return restTemplate.getForObject(buildUri("flickr.people.getInfo","user_id",getProfileId()),  Person.class);
	}

}
