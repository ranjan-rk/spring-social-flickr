package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Group2;
import org.springframework.social.flickr.api.Groups;

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
				.expect(requestTo("http://api.flickr.com/services/rest/?text=sun&method=flickr.groups.search&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("groups"), responseHeaders));
		Groups groups = flickr.groupsOperations().search("sun", null, null);
		assertGroups(groups);
	}
	
	@Test
	public void infoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?group_id=1878057%40N24&method=flickr.groups.getInfo&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("group"), responseHeaders));
		Group2 group =  flickr.groupsOperations().getInfo("1878057@N24", null);
		assertGroup(group);
	}
	
	@Test
	public void joinTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.join&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result =  flickr.groupsOperations().join("1878057@N24", null);
		assertStat(result);
	}
	@Test
	public void joinRequestTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.joinRequest&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result =  flickr.groupsOperations().joinRequest("1878057@N24", null,null);
		assertStat(result);
	}
	
	@Test
	public void leaveTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.leave&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result =  flickr.groupsOperations().leave("1878057@N24", null);
		assertStat(result);
	}

	private void assertGroup(Group2 group) {
		Assert.assertEquals("goa", group.getDescription());
		
	}
	private void assertStat(boolean result) {
		Assert.assertEquals(true, result);
	}
	private void assertGroups(Groups groups) {
		Assert.assertEquals(2, groups.getGroup().size());
	}

}