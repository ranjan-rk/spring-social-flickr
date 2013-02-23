package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Replies;
import org.springframework.social.flickr.api.Reply;

/**
 * The Class GroupsDiscussRepliesTemplateTest.
 * 
 * @author HemantS
 */
public class GroupsDiscussRepliesTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void addTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.discuss.replies.add&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(withResponse(jsonResource("reply"), responseHeaders));
		Reply reply = flickr.groupsDiscussRepliesOperations().add("72157632838001086", "message");
		assertReply(reply);
	}

	@Test
	public void deleteTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.discuss.replies.delete&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.groupsDiscussRepliesOperations().delete("72157632838001086", "72157632832940873");
		assertStat(result);
	}
	
	@Test
	public void editTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.discuss.replies.edit&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.groupsDiscussRepliesOperations().edit("72157632838001086", "72157632832940873","test");
		assertStat(result);
	}
	
	@Test
	public void getInfoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?reply_id=72157632832940873&topic_id=72157632838001086&method=flickr.groups.discuss.replies.getInfo&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("reply"), responseHeaders));
		Reply reply = flickr.groupsDiscussRepliesOperations().getInfo("72157632838001086", "72157632832940873");
		assertReply(reply);
	}
	
	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?reply_id=72157632832940873&topic_id=72157632838001086&method=flickr.groups.discuss.replies.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("replies"), responseHeaders));
		Replies replies = flickr.groupsDiscussRepliesOperations().getList("72157632838001086", "72157632832940873");
		assertReplies(replies);
	}
	
	
	private void assertReply(Reply reply) {
		Assert.assertEquals("72157632832940873", reply.getId());
	}
	private void assertReplies(Replies replies) {
		Assert.assertEquals(3, replies.getReply().size());
	}
	private void assertStat(boolean result) {
		Assert.assertEquals(true, result);
	}
	
}
