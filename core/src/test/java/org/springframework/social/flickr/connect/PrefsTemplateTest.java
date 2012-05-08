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
public class PrefsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getContentTypeTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.prefs.getContentType&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getGeoPermsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.prefs.getGeoPerms&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getHiddenTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.prefs.getHidden&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPrivacyTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.prefs.getPrivacy&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getSafetyLevelTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.prefs.getSafetyLevel&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}