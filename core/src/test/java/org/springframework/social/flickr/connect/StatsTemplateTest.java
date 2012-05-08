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
public class StatsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getCollectionDomainsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getCollectionDomains&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getCollectionReferrersTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getCollectionReferrers&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getCollectionStatsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getCollectionStats&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPhotoDomainsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPhotoDomains&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPhotoReferrersTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPhotoReferrers&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPhotosetDomainsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPhotosetDomains&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPhotosetReferrersTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPhotosetReferrers&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPhotosetStatsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPhotosetStats&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPhotoStatsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPhotoStats&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPhotostreamDomainsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPhotostreamDomains&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPhotostreamReferrersTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPhotostreamReferrers&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPhotostreamStatsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPhotostreamStats&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getPopularPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getPopularPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getTotalViewsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.stats.getTotalViews&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}