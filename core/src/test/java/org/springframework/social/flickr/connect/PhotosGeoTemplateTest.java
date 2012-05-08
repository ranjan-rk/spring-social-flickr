package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import org.junit.Test;

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
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.getLocation&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPermsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.getPerms&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void photosForLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.photosForLocation&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void removeLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.removeLocation&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void setContextTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.setContext&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void setLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.setLocation&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void setPermsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.geo.setPerms&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}