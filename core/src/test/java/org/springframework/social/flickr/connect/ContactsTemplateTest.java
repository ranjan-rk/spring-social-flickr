package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Contacts;

/**
 * @author HemantS
 *
 */
public class ContactsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.contacts.getList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("contacts"), responseHeaders));
		Contacts contacts= flickr.contactsOperations().getList(null, null, null, null);
		assertContacts(contacts);
	}
	
	@Test
	public void getListRecentlyUploadedTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?user_id=73562874%40N08&method=flickr.contacts.getPublicList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("contacts"), responseHeaders));
		Contacts contacts=flickr.contactsOperations().getPublicList("73562874@N08", null, null);
		assertContacts(contacts);
	}

	@Test
	public void getPublicListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.contacts.getPublicList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getTaggingSuggestionsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.contacts.getTaggingSuggestions&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("contacts"), responseHeaders));
		Contacts contacts=flickr.contactsOperations().getTaggingSuggestions(null, null);
		assertContacts(contacts);
	}
	
	private void assertContacts(Contacts contacts) {
		Assert.assertEquals("PixBeast", contacts.getContact().get(0).getUsername());
	}


}