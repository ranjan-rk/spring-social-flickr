package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Pandas;
import org.springframework.social.flickr.api.Photos;

/**
 * @author HemantS
 *
 */
public class PandaTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getListTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.panda.getList&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("pandas"), responseHeaders));
		Pandas pandas = unauthorizedFlickr.pandaOperations().getList();
		assertPandas(pandas);
	}

	@Test
	public void getPhotosTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?panda_name=ling+ling&method=flickr.panda.getPhotos&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("pandaphotos"), responseHeaders));
		Photos photos = unauthorizedFlickr.pandaOperations().getPhotos("ling ling", null, null, null);
		assertPhotos(photos);
	}
	
	private void assertPhotos(Photos photos){
		Assert.assertEquals(18, photos.getPhoto().size());
	}

	private void assertPandas(Pandas pandas) {
			Assert.assertEquals(3, pandas.getPanda().size());
	}


}