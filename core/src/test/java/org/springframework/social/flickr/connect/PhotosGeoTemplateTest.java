package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Perms;
import org.springframework.social.flickr.api.Photo;
import org.springframework.social.flickr.api.Photos;

/**
 * @author HemantS
 *
 */
public class PhotosGeoTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void batchCorrectLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.batchCorrectLocation&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void correctLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.correctLocation&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosGeoOperations().correctLocation("7121067493", null, null,null);
		assertStat(result);
	}

	@Test
	public void getLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?photo_id=7121067493&method=flickr.photos.geo.getLocation&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("photogeophotos"), responseHeaders));
		Photo photo = flickr.photosGeoOperations().getLocation("7121067493");
		assertPhoto(photo);
	}



	@Test
	public void getPermsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?photo_id=7121067493&method=flickr.photos.geo.getPerms&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("photogeoperms"), responseHeaders));
		Perms perms = flickr.photosGeoOperations().getPerms("7121067493");
		assertPerms(perms);
	}


	@Test
	public void photosForLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?lat=18.531709&lon=73.853843&accuracy=11&method=flickr.photos.geo.photosForLocation&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("photogeobyloc"), responseHeaders));
		Photos photos = flickr.photosGeoOperations().photosForLocation("18.531709", "73.853843", "11", null, null, null);
		assertPhotos(photos);
	}



	@Test
	public void removeLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.removeLocation&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosGeoOperations().removeLocation("6974984792");
		assertStat(result);
		
	}

	@Test
	public void setContextTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.setContext&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosGeoOperations().setContext("6974984792","1");
		assertStat(result);
	}

	@Test
	public void setLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.setLocation&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosGeoOperations().setLocation("7121067493", "18.531709", "73.853843", "11", "1");
		assertStat(result);
	}

	@Test
	public void setPermsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.setPerms&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosGeoOperations().setPerms("1", "1", "1", "1", "7121067493");
		assertStat(result);
	}
	
	private void assertStat(boolean result) {
		Assert.assertEquals(true, result);
	}
	private void assertPhoto(Photo photo) {
		Assert.assertEquals("7121067493", photo.getId());
	}
	private void assertPerms(Perms perms) {
		Assert.assertEquals("7121067493", perms.getId());
	}
	private void assertPhotos(Photos photos) {
		Assert.assertEquals("6974984792", photos.getPhoto().get(0).getId());
	}


}