package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Group2;

/**
 * @author HemantS
 *
 */
public class GroupsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void browseTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.browse&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void searchTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.search&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}
	
	@Test
	public void infoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=23&group_id=1878057%40N24&method=flickr.groups.getInfo&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("group"), responseHeaders));
		Group2 group =  flickr.groupsOperations().getInfo("23", "1878057@N24", null);
		assertGroup(group);
	}

	private void assertGroup(Group2 group) {
		Assert.assertEquals("goa", group.getDescription());
		
	}

}