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
public class PushTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getSubscriptionsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.push.getSubscriptions&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getTopicsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.push.getTopics&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void subscribeTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.push.subscribe&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}