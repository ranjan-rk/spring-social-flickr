package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.ExtrasConstant;
import org.springframework.social.flickr.api.Photos;

public class PhotoTemplateTest extends AbstractFlickrApiTest{
    
    @Test
    public void addTagsTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.addTags&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    
	   String[] tags  ={"tag"};
	   boolean result = flickr.photoOperations().addTags("id", tags);
	    	    
    }
    
    @Test
    public void deleteTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.delete&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    boolean result = flickr.photoOperations().delete("id");
    }
    
    @Test
    public void getRecentTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?per_page=3&page=2&extras=date_upload%2Cowner_name&method=flickr.photos.getRecent&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("recent"), responseHeaders));
	    String extras [] = {ExtrasConstant.DATE_UPLOAD,ExtrasConstant.OWNER_NAME};
	    Photos photos	=  flickr.photoOperations().getRecent("3", "2",extras );
	    System.out.println(photos.getPhoto().get(0).getUrl());
	    assertPhotos(photos);
    }
    
    private void assertPhotos(Photos photos){
		Assert.assertEquals(3, photos.getPhoto().size());
	}
}
