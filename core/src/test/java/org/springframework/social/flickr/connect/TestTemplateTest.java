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
public class TestTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void echoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.test.echo&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void loginTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.test.login&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void nullTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.test.null&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}