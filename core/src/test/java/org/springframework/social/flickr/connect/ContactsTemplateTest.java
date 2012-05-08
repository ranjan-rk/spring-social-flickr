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
public class ContactsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getListRecentlyUploadedTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.contacts.getListRecentlyUploaded&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPublicListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.contacts.getPublicList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getTaggingSuggestionsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.contacts.getTaggingSuggestions&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}