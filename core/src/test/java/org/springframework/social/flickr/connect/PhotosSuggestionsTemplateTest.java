package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Suggestions;

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
		boolean result = flickr.photosSuggestionsOperations().approveSuggestion("73470061-72157632851232367");
		assertStat(result);
	}

	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.suggestions.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("suggestoinlist"), responseHeaders));
		Suggestions suggestions = flickr.photosSuggestionsOperations().getList(null, null);
		assertSuggestions(suggestions);
	}

	@Test
	public void rejectSuggestionTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.suggestions.rejectSuggestion&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
		boolean result = flickr.photosSuggestionsOperations().rejectSuggestion("73470061-72157632851232367");
		assertStat(result);
	}

	@Test
	public void removeSuggestionTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.suggestions.removeSuggestion&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosSuggestionsOperations().removeSuggestion("73470061-72157632851232367");
		assertStat(result);
	}

	@Test
	public void suggestLocationTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.suggestions.suggestLocation&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("suggestions"), responseHeaders));
		Suggestions suggestions = flickr.photosSuggestionsOperations().suggestLocation("8376145141", "18.531709", "73.853843", null, null, null, null);
		assertSuggestions(suggestions);
	}

	private void assertSuggestions(Suggestions suggestions) {
		Assert.assertEquals("73470061-72157632851232367", suggestions.getSuggestion().get(0).getId());
	}
	private void assertStat(boolean result) {
		Assert.assertEquals(true, result);
	}

}