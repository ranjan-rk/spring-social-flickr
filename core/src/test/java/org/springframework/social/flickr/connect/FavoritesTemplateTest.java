package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
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
public class FavoritesTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void addTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.favorites.add&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.favoritesOperations().add("id");
		assertStat(result);
	}

	@Test
	public void getContextTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.favorites.getContext&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.favorites.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("favoritephoto"), responseHeaders));
		Photos photos = flickr.favoritesOperations().getList(null, null, null, null , null, null);
		assertPhotos(photos);
	}

	@Test
	public void getPublicListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?user_id=id&method=flickr.favorites.getPublicList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("favoritephoto"), responseHeaders));
		Photos photos = flickr.favoritesOperations().getPublicList("id", null,null,null,null,null);
		assertPhotos(photos);
	}

	@Test
	public void removeTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.favorites.remove&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.favoritesOperations().remove("id");
		assertStat(result);
	}

	private void assertStat(boolean result){
	    	Assert.assertEquals(true, result);
	    }
	
	private void assertPhotos(Photos photos){
		Assert.assertEquals("1337230358", photos.getPhoto().get(0).getDateFaved());
	}
}
