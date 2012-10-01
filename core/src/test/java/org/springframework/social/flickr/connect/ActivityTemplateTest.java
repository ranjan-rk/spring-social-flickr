package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.UserComment;

/**
 * @author HemantS
 *
 */
public class ActivityTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void userCommentsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=23&method=flickr.activity.userComments&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("activity"), responseHeaders));
		UserComment comments = flickr.activityOperations().userComments("23", null, null);
		assertUserComment(comments);
	}
	
	@Test
	public void userPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=23&method=flickr.activity.userPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("activity2"), responseHeaders));
		UserComment comments = flickr.activityOperations().userPhotos("23", null, null,null);
		assertUserPhotos(comments);
	}

	private void assertUserComment(UserComment comments) {
		Assert.assertEquals("cute", comments.getItem().get(0).getActivity().getEvent().get(0).get_content());
	}
	private void assertUserPhotos(UserComment comments) {
		Assert.assertEquals("good one", comments.getItem().get(0).getActivity().getEvent().get(0).get_content());
	}

	

}