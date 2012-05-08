/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.flickr.api.Groups;
import org.springframework.social.flickr.api.Person;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.User;
import org.springframework.social.flickr.api.impl.FlickrException;

/**
 * @author HemantS
 *
 */
public class PeopleTemplateTest extends AbstractFlickrApiTest {
   
    
    @Test
    public void getLoggedInPersonProfileTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.test.login&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("testuser"), responseHeaders));
	    
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?user_id=73562874%40N08&method=flickr.people.getInfo&format=json&nojsoncallback=1"))
        .andExpect(method(GET))
        .andRespond(withResponse(jsonResource("peopleinfo"), responseHeaders));
	    
	    Person person = flickr.peopleOperations().getPersonProfile();
	    assertPersonProfile(person);
	    	    
    }
    
    @Test
    public void getPersonProfileTest(){
    	String userId ="73562874@N08"; 
    	unauthorizedMockServer.expect(requestTo("http://api.flickr.com/services/rest/?user_id=73562874%40N08&method=flickr.people.getInfo&format=json&nojsoncallback=1"))
        .andExpect(method(GET))
        .andRespond(withResponse(jsonResource("peopleinfo"), responseHeaders));
    	Person person = unauthorizedFlickr.peopleOperations().getPersonProfile(userId);
	    assertPersonProfile(person);
	 }
    
    @Test
    public void getPersonProfileId(){
    	mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.test.login&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("testuser"), responseHeaders));
    	String profileId = flickr.peopleOperations().getProfileId();
    	Assert.assertNotNull(profileId);
    }
    
    @Test
    public void getUserByEmail(){
    	mockServer.expect(requestTo("http://api.flickr.com/services/rest/?find_email=testemailid&method=flickr.people.findByEmail&format=json&nojsoncallback=1"))
        .andExpect(method(GET))
        .andRespond(withResponse(jsonResource("user"), responseHeaders));
    	User user = flickr.peopleOperations().getUserByEmail("testemailid");
    	assertUser(user);
    }
    
    @Test
    public void getUserByUserName(){
    	mockServer.expect(requestTo("http://api.flickr.com/services/rest/?username=testusername&method=flickr.people.findByUsername&format=json&nojsoncallback=1"))
        .andExpect(method(GET))
        .andRespond(withResponse(jsonResource("user"), responseHeaders));
    	User user = flickr.peopleOperations().getUserByUserName("testusername");
    	assertUser(user);
    }

    @Test
    public void getGroups(){
    	mockServer.expect(requestTo("http://api.flickr.com/services/rest/?user_id=testuserid&method=flickr.people.getGroups&format=json&nojsoncallback=1"))
        .andExpect(method(GET))
        .andRespond(withResponse(jsonResource("groups"), responseHeaders));
    	Groups groups = flickr.peopleOperations().getGroups("testuserid");
    	asserGroups(groups);
    }
    
    @Test
    public void getPublicGroups(){
    	mockServer.expect(requestTo("http://api.flickr.com/services/rest/?user_id=testuserid&method=flickr.people.getPublicGroups&format=json&nojsoncallback=1"))
        .andExpect(method(GET))
        .andRespond(withResponse(jsonResource("groups"), responseHeaders));
    	Groups groups = flickr.peopleOperations().getPublicGroups("testuserid");
    	asserGroups(groups);
    }
    
    @Test
    public void getPhotos(){
    	mockServer.expect(requestTo("http://api.flickr.com/services/rest/?user_id=testuserid&method=flickr.people.getPhotos&format=json&nojsoncallback=1"))
        .andExpect(method(GET))
        .andRespond(withResponse(jsonResource("photos"), responseHeaders));
    	Photos photos= flickr.peopleOperations().getPhotos("testuserid");
    	assertPhotos(photos);
    }
    
    @Test
    public void getPublicPhotos(){
    	mockServer.expect(requestTo("http://api.flickr.com/services/rest/?user_id=testuserid&method=flickr.people.getPublicPhotos&format=json&nojsoncallback=1"))
        .andExpect(method(GET))
        .andRespond(withResponse(jsonResource("photos"), responseHeaders));
    	Photos photos= flickr.peopleOperations().getPublicPhotos("testuserid");
    	assertPhotos(photos);
    }
    
    
    //For Negative Testing
    @Test(expected = MissingAuthorizationException.class)
    public void missingAccessToken(){
    	mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.test.login&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("testuser"), responseHeaders));
    	String profileId = unauthorizedFlickr.peopleOperations().getProfileId();
    	Assert.assertNotNull(profileId);
    }

    
    @Test(expected= FlickrException.class)
	public void flickrErrorTest() {
    	String userId ="73562874@N08"; 
		mockServer.expect(requestTo("http://api.flickr.com/services/rest/?user_id=73562874%40N08&method=flickr.people.getInfo&format=json&nojsoncallback=1"))
			.andExpect(method(GET))
			.andRespond(withResponse(jsonResource("error"), responseHeaders ));
		Person person = flickr.peopleOperations().getPersonProfile(userId);
	    assertPersonProfile(person);
	}
    
	private void assertPersonProfile(Person person) {
		Assert.assertEquals("73562874@N08", person.getId());
	}
	private void assertUser(User user){
		Assert.assertEquals("hemantsch", user.getUsername());
	}
	private void asserGroups(Groups groups){
		Assert.assertEquals(2, groups.getGroup().size());
	}
	private void assertPhotos(Photos photos){
		Assert.assertEquals(5, photos.getPhoto().size());
	}
    
}