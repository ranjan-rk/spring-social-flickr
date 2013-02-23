package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Groups;
import org.springframework.social.flickr.api.Photos;

/**
 * @author HemantS
 * 
 */
public class GroupsPoolsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void addTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.pools.add&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.groupsPoolsOperations().add("8376145141", "1878057@N24");
		assertStat(result);
	}

	@Test
	public void getContextTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.pools.getContext&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getGroupsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.pools.getGroups&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("groups2"), responseHeaders));
		Groups groups = flickr.groupsPoolsOperations().getGroups(null,null);
		assertGroups(groups);
	}



	@Test
	public void getPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?group_id=1878057%40N24&method=flickr.groups.pools.getPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("photos"), responseHeaders));
		Photos photos = flickr.groupsPoolsOperations().getPhotos("1878057@N24", null, null, null, null, null);
		assertPhotos(photos);
	}

	@Test
	public void removeTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.pools.remove&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.groupsPoolsOperations().remove("8376145141", "1878057@N24");
		assertStat(result);
	}
	private void assertStat(boolean result) {
		Assert.assertEquals(true, result);
	}
	private void assertPhotos(Photos photos) {
		Assert.assertEquals(5, photos.getPhoto().size());
	}
	private void assertGroups(Groups groups) {
		Assert.assertEquals(3, groups.getGroup().size());
	}
}