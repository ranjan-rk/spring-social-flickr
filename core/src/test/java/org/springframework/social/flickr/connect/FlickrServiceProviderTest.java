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

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.flickr.api.Person;
import org.springframework.social.flickr.api.impl.FlickrTemplate;
import org.springframework.social.test.client.MockRestServiceServer;

public class FlickrServiceProviderTest {
    MockRestServiceServer mockServer;
    FlickrTemplate flickr;

    @Before
    public void getFlickrTemplate() {
    	flickr = new FlickrTemplate("consumerKey", "consumerSecret", "accessToken", "accessTokenSecret");
		mockServer = MockRestServiceServer.createServer(flickr.getRestTemplate());

    }
    
    @Test
    public void getPeopleInfoTest(){	
	HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.setContentType(MediaType.TEXT_PLAIN);
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.test.login&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("testuser"), responseHeaders));
	    
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?user_id=73562874%40N08&method=flickr.people.getInfo&format=json&nojsoncallback=1"))
        .andExpect(method(GET))
        .andRespond(withResponse(jsonResource("peopleinfo"), responseHeaders));
	    
	    Person profile = flickr.userOperations().getUserProfile();
	    System.out.println(profile.getUsername());
	    	    
    }
    
    private Resource jsonResource(String filename) {
    	System.out.println(getClass());
		Resource r =new ClassPathResource(filename + ".json", getClass());		
		try {
		    File f = r.getFile();
		    System.out.println(f.getAbsolutePath());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    return  r;
    }
		
}