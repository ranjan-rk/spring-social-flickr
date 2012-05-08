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
public class TagsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getClusterPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getClusterPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getClustersTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getClusters&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getHotListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getHotList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getListPhotoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getListPhoto&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getListUserTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getListUser&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getListUserPopularTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getListUserPopular&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getListUserRawTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getListUserRaw&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getMostFrequentlyUsedTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getMostFrequentlyUsed&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getRelatedTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getRelated&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}