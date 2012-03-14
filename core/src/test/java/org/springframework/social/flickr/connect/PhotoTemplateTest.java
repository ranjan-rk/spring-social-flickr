package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;

public class PhotoTemplateTest extends AbstractFlickrApiTest{
    
    @Test
    public void addTagsTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?photo_id=id&tags=tag&method=flickr.photos.addTags&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    
	   String[] tags  ={"tag"};
	    boolean result = flickr.photoOperations().addTags("id", tags);
	    System.out.println(result);
	    	    
    }
}
