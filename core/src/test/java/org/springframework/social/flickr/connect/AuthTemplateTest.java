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
public class AuthTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void checkTokenTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.auth.checkToken&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getFrobTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.auth.getFrob&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getFullTokenTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.auth.getFullToken&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getTokenTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.auth.getToken&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}