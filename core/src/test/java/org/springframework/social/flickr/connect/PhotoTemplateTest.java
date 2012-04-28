package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Comment;
import org.springframework.social.flickr.api.Comments;
import org.springframework.social.flickr.api.ContentTypeEnum;
import org.springframework.social.flickr.api.ExtrasConstant;
import org.springframework.social.flickr.api.LicenseEnum;
import org.springframework.social.flickr.api.Licenses;
import org.springframework.social.flickr.api.Note;
import org.springframework.social.flickr.api.PermissionEnum;
import org.springframework.social.flickr.api.Perms;
import org.springframework.social.flickr.api.Photo;
import org.springframework.social.flickr.api.PhotoDetail;
import org.springframework.social.flickr.api.PhotoId;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.RotateEnum;
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
	
	//For photo comments
	
	@Test
    public void addCommentTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.comments.addComment&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("comment"), responseHeaders));
	    Comment comment =  flickr.PhotoCommentOperations().addComment("23", "commentText");
	    assertComment(comment);
    }
	
	@Test
    public void deleteCommentTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.comments.deleteComment&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    boolean result=  flickr.PhotoCommentOperations().deleteComment("commentID");
	    assertStat(result);
    }
    
	@Test
    public void editCommentTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.comments.editComment&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    boolean result=  flickr.PhotoCommentOperations().editComment("commentID","commenTtext");
	    assertStat(result);
    }
    
	@Test
    public void getCommentListTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.comments.getList&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("comments"), responseHeaders));
	    Comments comments=  flickr.PhotoCommentOperations().getList("23", null, null);
	    assertComments(comments);
    }
    
	//Photo License 
	@Test
    public void getLicenseInfoTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.licenses.getInfo&format=json&nojsoncallback=1"))
	        .andExpect(method(GET))
	        .andRespond(withResponse(jsonResource("licenses"), responseHeaders));
	    Licenses licenses=  flickr.PhotoLicenseOperations().getInfo();
	    assertLicense(licenses);
    }
	
	@Test
    public void setLicenseTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.licenses.setLicense&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    boolean result=  flickr.PhotoLicenseOperations().setLicense("23", LicenseEnum.AllRightsReserved);
	    assertStat(result);
    }
	
	//Photo Note
    
	@Test
    public void addNoteTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.notes.add&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("note"), responseHeaders));
	    Note note = new Note();
	    note.set_content("test");
	    note.setH(2);
	    String id=  flickr.PhotoNoteOperations().add("23",note );
	    assertNoteId(id);
    }
	
	@Test
    public void deleteNoteTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.notes.delete&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    boolean result =  flickr.PhotoNoteOperations().delete("23");
	    assertStat(result);
    }
	
	@Test
    public void editNoteTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.notes.edit&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("stat"), responseHeaders));
	    Note note = new Note();
	    note.set_content("test");
	    note.setH(2);
	    boolean result =  flickr.PhotoNoteOperations().edit("23",note);
	    assertStat(result);
    }
	
	//Photo Rotation
	@Test
    public void rotateTest(){	
	    mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.transform.rotate&format=json&nojsoncallback=1"))
	        .andExpect(method(POST))
	        .andRespond(withResponse(jsonResource("photoid"), responseHeaders));
	    PhotoId photoid=  flickr.photoOperations().rotate("23", RotateEnum.NINETY);
	    assertPhotoId(photoid);
    }
	
    private void assertNoteId(String id) {
    	Assert.assertEquals("72157629917179921", id);
	}

	private void assertLicense(Licenses licenses) {
    	Assert.assertEquals(9, licenses.getLicense().size());
	}

	private void assertComments(Comments comments) {
    	Assert.assertEquals(2, comments.getComment().size());
	}

	private void assertComment(Comment comment) {
    	Assert.assertEquals("73470061-6955318342-72157629916928349", comment.getId());
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
