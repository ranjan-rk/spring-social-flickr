package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.GET;
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

public class PhotosetTemplateTest extends AbstractFlickrApiTest {

	@Test
	public void createTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.create&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("photoset"), responseHeaders));
		Photoset photoset = flickr.photosetOperations().create("title",
				"description", "23");
		assertPhotoset(photoset);
	}

	@Test
	public void addPhotoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.addPhoto&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosetOperations().addPhoto("23", "23");
		assertStat(result);
	}

	@Test
	public void editMetaTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.editMeta&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosetOperations().editMeta("23", "title",
				"desc");
		assertStat(result);
	}

	@Test
	public void editPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.editPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(withResponse(jsonResource("stat"), responseHeaders));
		List<String> listOfPhots = new ArrayList<String>();
		listOfPhots.add("24");
		listOfPhots.add("25");
		boolean result = flickr.photosetOperations().editPhotos("23", "title",
				listOfPhots);
		assertStat(result);
	}

	@Test
	public void getInfoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.getInfo&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("photosetdetail"),
								responseHeaders));
		Photoset photoset = flickr.photosetOperations().getInfo("23");
		assertPhotoset(photoset);
	}

	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.getList&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("photosets"), responseHeaders));
		Photosets photosets = flickr.photosetOperations().getList("23", null,
				null);
		assertPhotosets(photosets);
	}

	@Test
	public void deleteTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.delete&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosetOperations().delete("2");
		assertStat(result);
	}

	@Test
	public void getPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?photoset_id=23&method=flickr.photosets.getPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("photoset2"), responseHeaders));
		Photoset  photoset = flickr.photosetOperations().getPhotos("23",null,null, null, null, null);
		assertPhotoset(photoset);
	}

	@Test
	public void orderSetsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.orderSets&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(withResponse(jsonResource("stat"), responseHeaders));
		String ids[]={"1","2"};
		boolean result = flickr.photosetOperations().orderSets(ids);
		assertStat(result);
	}

	@Test
	public void removePhotoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.removePhoto&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosetOperations().removePhoto("2", "3");
		assertStat(result);
	}

	@Test
	public void removePhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.removePhotos&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		String ids[]={"1","2"};
		boolean result = flickr.photosetOperations().removePhotos("2",ids);
		assertStat(result);
	}

	@Test
	public void reorderPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.reorderPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		String ids[]={"1","2"};
		boolean result = flickr.photosetOperations().reorderPhotos("2",ids);
		assertStat(result);
	}

	@Test
	public void setPrimaryPhotoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.setPrimaryPhoto&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	/*
	 * @Test public void getContextTest(){ mockServer.expect(requestTo(
	 * "http://api.flickr.com/services/rest/?method=flickr.photosets.getContext&format=json&nojsoncallback=1"
	 * )) .andExpect(method(POST))
	 * .andRespond(withResponse(jsonResource("photocount"), responseHeaders));
	 * PhotoCount photoCount = flickr.PhotosetOperations().getContext("23",
	 * "34"); assertPhotoCount(photoCount); }
	 */

	private void assertPhotosets(Photosets photosets) {
		Assert.assertEquals(4, photosets.getPhotoset().size());
	}

	private void assertPhotoCount(PhotoCount photoCount) {
		Assert.assertEquals(3, photoCount.get_content());
	}

	private void assertPhotoset(Photoset photoset) {
		Assert.assertEquals("72157629917337143", photoset.getId());
	}
	private void assertPhotoset2(Photoset photoset) {
		Assert.assertEquals("2", photoset.getPhoto().size());
	}

	private void assertStat(boolean result) {
		Assert.assertEquals(true, result);
	}
}
