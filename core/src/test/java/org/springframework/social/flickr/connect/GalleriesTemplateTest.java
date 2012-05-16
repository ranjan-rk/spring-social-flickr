package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Galleries;
import org.springframework.social.flickr.api.Gallery;
import org.springframework.social.flickr.api.Photos;

/**
 * @author HemantS
 * 
 */
public class GalleriesTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void addPhotoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.galleries.addPhoto&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		 boolean result = flickr.galleriesOperations().addPhoto("id", "id", "comment");
		 assertStat(result);
	}

	@Test
	public void createTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.galleries.create&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("gallery"), responseHeaders));
		
		Gallery gallery = flickr.galleriesOperations().create("title", "des", "id");
		assertGallery(gallery);
	}

	@Test
	public void editMetaTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.galleries.editMeta&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.galleriesOperations().editMeta("id", "title", "description");
		 assertStat(result);
	}

	@Test
	public void editPhotoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.galleries.editPhoto&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.galleriesOperations().editPhoto("id", "title", "comments");
		 assertStat(result);
	}

	@Test
	public void editPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.galleries.editPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		String a[] = {"id","id"};
		boolean result = flickr.galleriesOperations().editPhotos("id","id",a);
		 assertStat(result);
	}

	@Test
	public void getInfoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?gallery_id=id&method=flickr.galleries.getInfo&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("gallerydetail"), responseHeaders));
		Gallery gallery = flickr.galleriesOperations().getInfo("id");
		assertGalleryDetail(gallery);
	}

	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?user_id=id&method=flickr.galleries.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("galleries"), responseHeaders));
		Galleries galleries =  flickr.galleriesOperations().getList("id", null, null);
		assertGalleries(galleries);
	}

	@Test
	public void getListForPhotoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?photo_id=id&method=flickr.galleries.getListForPhoto&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("galleryforphoto"), responseHeaders));
		 Galleries galleries = flickr.galleriesOperations().getListForPhoto("id",null,null);
		 assertGalleriesPhoto(galleries);
	}

	@Test
	public void getPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?gallery_id=id&method=flickr.galleries.getPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("galleryphotos"), responseHeaders));
		Photos photos = flickr.galleriesOperations().getPhotos("id", null, null, null);
		assertPhotos(photos);
	}
	
	private void assertStat(boolean result) {
		Assert.assertEquals(true, result);
	}
	private void assertPhotos(Photos photos){
		Assert.assertEquals(4, photos.getPhoto().size());
	}
	
	private void assertGallery(Gallery gallery) {
		Assert.assertEquals("73470061-72157629720185926", gallery.getId());
	}
	
	private void assertGalleries(Galleries gallereis) {
		Assert.assertEquals(4, gallereis.getGallery().size());
	}
	
	private void assertGalleriesPhoto(Galleries gallereis) {
		Assert.assertEquals(2, gallereis.getGallery().size());
	}
	
	private void assertGalleryDetail(Gallery gallery) {
		Assert.assertEquals("73470061-72157629552242573", gallery.getId());
	}
	
}