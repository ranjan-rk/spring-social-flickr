package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.ContentTypeEnum;
import org.springframework.social.flickr.api.ExtrasConstant;
import org.springframework.social.flickr.api.PermissionEnum;
import org.springframework.social.flickr.api.Perms;
import org.springframework.social.flickr.api.Photo;
import org.springframework.social.flickr.api.PhotoDetail;
import org.springframework.social.flickr.api.PhotoId;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.SafetyLevelEnum;
import org.springframework.social.flickr.api.Sizes;

public class PhotoTemplateTest extends AbstractFlickrApiTest{
    
    @Test
    public void addTagsTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.addTags&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    
	   String[] tags  ={"tag"};
	   boolean result = flickr.photoOperations().addTags("id", tags);
	   assertStat(result);	        
    }
    
    @Test
    public void removeTagsTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.removeTag&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	   boolean result = flickr.photoOperations().removeTag("23");
	    assertStat(result);	    
    }
    
    @Test
    public void deleteTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.delete&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    boolean result = flickr.photoOperations().delete("id");
	    assertStat(result);	    
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
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?per_page=3&page=2&photo_id=2679305152&method=flickr.photos.getFavorites&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("favorite"), responseHeaders));
	    Photo photo	=  flickr.photoOperations().getFavorites("3", "2","2679305152" );
	    assertPersonList(photo);
    }
    
    @Test
    public void getInfoTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?photo_id=23&method=flickr.photos.getInfo&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("photodetail"), responseHeaders));
	    PhotoDetail photoDetail	=  flickr.photoOperations().getInfo("23");
	    assertPhotoDetail(photoDetail);
    }
    
    @Test
    public void getSizesTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?photo_id=23&method=flickr.photos.getSizes&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("sizes"), responseHeaders));
	    Sizes sizes =  flickr.photoOperations().getSizes("23");
	    assertPhotoSizes(sizes);
    }
    
    
    @Test
    public void getPermsTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?photo_id=23&method=flickr.photos.getPerms&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("perms"), responseHeaders));
	    Perms perms=  flickr.photoOperations().getPerms("23");
	    assertPermission(perms);
    }
    
    @Test
    public void setSafetyLevelTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.setSafetyLevel&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    boolean result=  flickr.photoOperations().setSafetyLevel("23", SafetyLevelEnum.MODERATE);
	    assertStat(result);
    }
    
    @Test
    public void setPermsTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.setPerms&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("photoid"), responseHeaders));
	    Perms perms = new Perms();
	    perms.setId("23");
	    perms.setIsfamily(true);
	    perms.setIsfriend(true);
	    perms.setIspublic(true);
	    perms.setPermaddmeta(PermissionEnum.CONTACTS);
	    perms.setPermcomment(PermissionEnum.CONTACTS);
	    PhotoId photoid=  flickr.photoOperations().setPerms(perms);
	    assertPhotoId(photoid);
    }
    
	@Test
    public void setContentTypeTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.setContentType&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    boolean result=  flickr.photoOperations().setContentType("23", ContentTypeEnum.SCREENSHORT);
	    assertStat(result);
    }
	
	@Test
    public void setMetaTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.setMeta&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    boolean result=  flickr.photoOperations().setMeta("23", "title","desc");
	    assertStat(result);
    }
    
    private void assertPhotoId(PhotoId photoid) {
		Assert.assertEquals("1e77a29be3", photoid.getSecret());
	}
    
    private void assertStat(boolean result){
    	Assert.assertEquals(true, result);
    }
    private void assertPermission(Perms perms) {
    	Assert.assertEquals("6955318342", perms.getId());
	}

	private void assertPhotoSizes(Sizes sizes) {
    	Assert.assertEquals(9, sizes.getSize().size());
	}
	private void assertPhotos(Photos photos){
		Assert.assertEquals(3, photos.getPhoto().size());
	}
	private void assertPersonList(Photo photo) {
		Assert.assertEquals(10, photo.getPerson2().size());
	}
	private void assertPhotoDetail(PhotoDetail photoDetail) {
		Assert.assertEquals("6955318342", photoDetail.getId());
	}
}
