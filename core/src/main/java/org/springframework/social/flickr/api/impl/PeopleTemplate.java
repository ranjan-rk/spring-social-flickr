package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Groups;
import org.springframework.social.flickr.api.Person;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.User;
import org.springframework.social.flickr.api.PeopleOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PeopleTemplate extends AbstractFlickrOperations implements PeopleOperations{

	private final RestTemplate restTemplate;
	
	public PeopleTemplate(RestTemplate restTemplate,boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public String getProfileId() {
		requireAuthorization();
		User user = restTemplate.getForObject(buildUri("flickr.test.login"),  User.class);
		return user.getId();
	}

	@Override
	public Person getPersonProfile() {
		requireAuthorization();
		return restTemplate.getForObject(buildUri("flickr.people.getInfo","user_id",getProfileId()),  Person.class);
	}

	@Override
	public Person getPersonProfile(String userId) {
		return restTemplate.getForObject(buildUri("flickr.people.getInfo","user_id",userId),  Person.class);
	}

	@Override
	public User getUserByEmail(String email) {
		return restTemplate.getForObject(buildUri("flickr.people.findByEmail","find_email",email),  User.class);
	}

	@Override
	public User getUserByUserName(String userName) {
		return restTemplate.getForObject(buildUri("flickr.people.findByUsername","username",userName),  User.class);
	}

	@Override
	public Groups getGroups(String userId) {
		return restTemplate.getForObject(buildUri("flickr.people.getGroups","user_id",userId),  Groups.class);
	}
	
	@Override
	public Groups getPublicGroups(String userId) {
		return restTemplate.getForObject(buildUri("flickr.people.getPublicGroups","user_id",userId),  Groups.class);
	}
	
	@Override
	public Photos getPhotos(String userId) {
		return restTemplate.getForObject(buildUri("flickr.people.getPhotos","user_id",userId),  Photos.class);	
	}

	@Override
	public Photos getPublicPhotos(String userId) {
		return restTemplate.getForObject(buildUri("flickr.people.getPublicPhotos","user_id",userId),  Photos.class);	
	}

	

}
