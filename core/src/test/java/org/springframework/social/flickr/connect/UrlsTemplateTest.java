package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import org.junit.Test;

/**
 * @author HemantS
 *
 */
public class UrlsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getGroupTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.urls.getGroup&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getUserPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.urls.getUserPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getUserProfileTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.urls.getUserProfile&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void lookupGalleryTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.urls.lookupGallery&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void lookupGroupTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.urls.lookupGroup&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void lookupUserTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.urls.lookupUser&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}