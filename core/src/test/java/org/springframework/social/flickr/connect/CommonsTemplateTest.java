package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Institutions;

/**
 * @author HemantS
 *
 */
public class CommonsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getInstitutionsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=23&method=flickr.commons.getInstitutions&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("institute"), responseHeaders));
		Institutions institutions = flickr.commonsOperations().getInstitutions("23");
		assertInstitutions(institutions);
	}

	private void assertInstitutions(Institutions institutions) {
		Assert.assertEquals(56,institutions.getInstitution().size());
		
	}
	

}