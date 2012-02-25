package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Person;
import org.springframework.social.flickr.api.User;
import org.springframework.social.flickr.api.PeopleOperations;
import org.springframework.web.client.RestTemplate;

public class PeopleTemplate extends AbstractFlickrOperations implements PeopleOperations{

	private final RestTemplate restTemplate;
	
	public PeopleTemplate(RestTemplate restTemplate,boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}

	@Override
	public String getProfileId() {
		User user = restTemplate.getForObject(buildUri("flickr.test.login"),  User.class);
		return user.getId();
	}

	@Override
	public Person getPersonProfile() {
		return restTemplate.getForObject(buildUri("flickr.people.getInfo","user_id",getProfileId()),  Person.class);
	}

}
