package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Members;

/**
 * @author HemantS
 *
 */
public class GroupsMembersTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?group_id=1878057%40N24&method=flickr.groups.members.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("members"), responseHeaders));
		Members members = flickr.groupsMembersOperations().getList("1878057@N24", null, null,null);
		assertMembers(members);
	}

	private void assertMembers(Members members) {
		Assert.assertEquals("1",members.getTotal());
	}

}