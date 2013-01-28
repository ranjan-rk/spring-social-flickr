package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Person;

/**
 * @author HemantS
 *
 */
public class PrefsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getContentTypeTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=id&method=flickr.prefs.getContentType&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("prefsgetcontenttype"), responseHeaders));
		Person person = flickr.prefsOperation().getContentType("id");
		assertContentType(person);
	}



	@Test
	public void getGeoPermsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=id&method=flickr.prefs.getGeoPerms&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("prefsgetgeoperms"), responseHeaders));
		Person person = flickr.prefsOperation().getGeoPerms("id");
		assertGeoPerms(person);
	}

	

	@Test
	public void getHiddenTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=id&method=flickr.prefs.getHidden&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("prefsgethidden"), responseHeaders));
		Person person = flickr.prefsOperation().getHidden("id");
		assertHidden(person);
	}

	


	@Test
	public void getPrivacyTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=id&method=flickr.prefs.getPrivacy&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("prefsgetprivacy"), responseHeaders));
		Person person = flickr.prefsOperation().getPrivacy("id");
		assertPrivacy(person);
	}

	private void assertPrivacy(Person person) {
		Assert.assertEquals("1", person.getPrivacy());
	}



	@Test
	public void getSafetyLevelTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?api_key=id&method=flickr.prefs.getSafetyLevel&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("prefsgetsafetylevel"), responseHeaders));
		Person person = flickr.prefsOperation().getSafetyLevel("id");
		assertSafetyLevel(person);
	}
	
	private void assertSafetyLevel(Person person) {
		Assert.assertEquals("1", person.getSafety_level());
	}
	
	private void assertContentType(Person person) {
		Assert.assertEquals("1", person.getContent_type());
	}

	private void assertGeoPerms(Person person) {
		Assert.assertEquals("1", person.getGeoperms());
	}

	private void assertHidden(Person person) {
		Assert.assertEquals("1", person.getHidden());
	}

	
}