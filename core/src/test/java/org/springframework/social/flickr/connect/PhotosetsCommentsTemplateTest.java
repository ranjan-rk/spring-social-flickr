package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Comment;
import org.springframework.social.flickr.api.Comments;

/**
 * @author HemantS
 *
 */
public class PhotosetsCommentsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void addCommentTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.comments.addComment&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("photosetcomment"), responseHeaders));
		Comment comment = flickr.photosetsCommentsOperations().addComment("72157629552220359", "nice");
		assertComment(comment);
	}


	@Test
	public void deleteCommentTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.comments.deleteComment&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosetsCommentsOperations().deleteComment("73470061-72157629552220359-72157632915724382");
		assertStat(result);
	}

	@Test
	public void editCommentTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.photosets.comments.editComment&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("stat"), responseHeaders));
		boolean result = flickr.photosetsCommentsOperations().editComment("73470061-72157629552220359-72157632915724382", "awesome");
		assertStat(result);
	}

	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?photoset_id=72157629552220359&method=flickr.photosets.comments.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("photosetcomments"), responseHeaders));
		Comments comments = flickr.photosetsCommentsOperations().getList("72157629552220359");
		assertComments(comments);
	}
	
	private void assertComments(Comments comments) {
		Assert.assertEquals("72157629552220359", comments.getPhotoset_id());
	}


	private void assertComment(Comment comment) {
		Assert.assertEquals("73470061-72157629552220359-72157632915724382", comment.getId());
	}

	private void assertStat(boolean result) {
		Assert.assertEquals(true, result);
	}

}