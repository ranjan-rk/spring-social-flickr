package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Photos;

/**
 * @author HemantS
 *
 */
public class InterestingnessTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getListTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.interestingness.getList&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("photos"), responseHeaders));
		Photos photos = unauthorizedFlickr.interestingnessOperations().getList(null, null, null, null);
		assertPhotos(photos);
	}

	private void assertPhotos(Photos photos) {
		Assert.assertEquals(5, photos.getPhoto().size());
	}

}