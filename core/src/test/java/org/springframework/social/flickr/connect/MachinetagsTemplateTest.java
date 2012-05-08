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
public class MachinetagsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getNamespacesTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.machinetags.getNamespaces&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPairsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.machinetags.getPairs&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPredicatesTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.machinetags.getPredicates&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getRecentValuesTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.machinetags.getRecentValues&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getValuesTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.machinetags.getValues&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}