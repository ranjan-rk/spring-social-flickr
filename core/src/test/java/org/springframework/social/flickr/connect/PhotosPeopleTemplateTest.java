package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.People;

/**
 * @author HemantS
 *
 */
public class PhotosPeopleTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void addTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.people.add&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosPeopleOperations().add(null, null, null, null, null, null);
		assertStat(result);
		
	}

	@Test
	public void deleteTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.people.delete&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosPeopleOperations().delete("2342", "2w3432");
		assertStat(result);
	}

	@Test
	public void deleteCoordsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.people.deleteCoords&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosPeopleOperations().deleteCoords("2342", "2w3432");
		assertStat(result);
	}

	@Test
	public void editCoordsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photos.people.editCoords&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosPeopleOperations().editCoords(null, null, null, null, null, null);
		assertStat(result);
	}

	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?photo_id=7121067493&method=flickr.photos.people.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("people"), responseHeaders));
		People people = flickr.photosPeopleOperations().getList("7121067493");
		assertPeople(people);
	}
	private void assertPeople(People people) {
		Assert.assertEquals("1", people.getTotal());
	}

	private void assertStat(boolean result) {
		Assert.assertEquals(true, result);
	}

}