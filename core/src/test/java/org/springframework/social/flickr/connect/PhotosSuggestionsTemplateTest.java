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
public class PhotosSuggestionsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void approveSuggestionTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.suggestions.approveSuggestion&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.suggestions.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void rejectSuggestionTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.suggestions.rejectSuggestion&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void removeSuggestionTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.suggestions.removeSuggestion&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void suggestLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.suggestions.suggestLocation&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}