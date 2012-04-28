package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.PhotoCount;
import org.springframework.social.flickr.api.Photoset;
import org.springframework.social.flickr.api.Photosets;

public class PhotosetTemplateTest extends AbstractFlickrApiTest{

    @Test
    public void createTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.create&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("photoset"), responseHeaders));
	   Photoset photoset = flickr.PhotosetOperations().create("title", "description", "23");
	   assertPhotoset(photoset);	        
    }
    
    @Test
    public void addPhotoTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.addPhoto&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	   boolean result = flickr.PhotosetOperations().addPhoto("23","23");
	   assertStat(result);	        
    }
    
    @Test
    public void editMetaTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.editMeta&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	   boolean result = flickr.PhotosetOperations().editMeta("23","title","desc");
	   assertStat(result);	        
    }
    
    @Test
    public void editPhotosTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.editPhotos&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    List<String> listOfPhots = new ArrayList<String>();
	    listOfPhots.add("24");
	    listOfPhots.add("25");
	   boolean result = flickr.PhotosetOperations().editPhotos("23","title",listOfPhots);
	   assertStat(result);	        
    }
    
    @Test
    public void getInfoTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.getInfo&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("photosetdetail"), responseHeaders));
	   Photoset photoset = flickr.PhotosetOperations().getInfo("23");
	   assertPhotoset(photoset);	        
    }
    
    @Test
    public void getListTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.getList&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("photosets"), responseHeaders));
	   Photosets photosets = flickr.PhotosetOperations().getList("23",null,null);
	   assertPhotosets(photosets);	        
    }
    
    /*
    @Test
    public void getContextTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.getContext&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("photocount"), responseHeaders));
	   PhotoCount photoCount = flickr.PhotosetOperations().getContext("23", "34");
	   assertPhotoCount(photoCount);	        
    }*/
    
	private void assertPhotosets(Photosets photosets) {
		Assert.assertEquals(4,photosets.getPhotoset().size());
	}

	private void assertPhotoCount(PhotoCount photoCount) {
		Assert.assertEquals(3,photoCount.get_content());
	}

	private void assertPhotoset(Photoset photoset) {
		Assert.assertEquals("72157629917337143",photoset.getId());
	}
    private void assertStat(boolean result){
    	Assert.assertEquals(true, result);
    }
}
