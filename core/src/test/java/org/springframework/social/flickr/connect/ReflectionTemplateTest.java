package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;

import org.junit.Test;
import org.springframework.social.flickr.api.Methods;

/**
 * @author HemantS
 *
 */
public class ReflectionTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getMethodInfoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.reflection.getMethodInfo&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getMethodsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.reflection.getMethods&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("methods"), responseHeaders));
		Methods methods = flickr.reflectionOperations().getMethods();
		System.out.println(methods.getMethod());
		
	}

}