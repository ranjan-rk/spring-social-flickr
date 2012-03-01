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
import org.springframework.social.flickr.api.Person;
import org.springframework.social.flickr.api.impl.FlickrException;

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
    
}