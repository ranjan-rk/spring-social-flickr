package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Blogs;
import org.springframework.social.flickr.api.Services;

/**
 * @author HemantS
 *
 */
public class BlogsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=23&method=flickr.blogs.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("blogs"), responseHeaders));
		Blogs blogs= flickr.blogsOperations().getList("23", null);
		assertBlog(blogs);
	}

	@Test
	public void getServicesTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=23&method=flickr.blogs.getServices&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("blogservice"), responseHeaders));
		Services services= flickr.blogsOperations().getServices("23");
		assertServices(services);
	}

	@Test
	public void postPhotoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.blogs.postPhoto&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	private void assertBlog(Blogs blogs){
		Assert.assertEquals(1, blogs.getBlog().size());
	}
	private void assertServices(Services services){
		Assert.assertEquals(5, services.getService().size());
	}
}