package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.ExtrasConstant;
import org.springframework.social.flickr.api.Photo;
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
	    assertPhotos(photos);
    }
    
    @Test
    public void getFavoriteTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?per_page=3&page=2&method=flickr.photos.getFavorites&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("favorite"), responseHeaders));
	    Photo photo	=  flickr.photoOperations().getFavorites("3", "2","2679305152" );
	    assertPersonList(photo);
    }
    
    
    private void assertPhotos(Photos photos){
		Assert.assertEquals(3, photos.getPhoto().size());
	}
	private void assertPersonList(Photo photo) {
		Assert.assertEquals(10, photo.getPerson2().size());
	}
}
