package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Namespaces;
import org.springframework.social.flickr.api.Pairs;
import org.springframework.social.flickr.api.Predicates;
import org.springframework.social.flickr.api.Values;

/**
 * @author HemantS
 *
 */
public class MachinetagsTemplateTest extends AbstractFlickrApiTest {
	
	@Test
	public void getNamespacesTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.machinetags.getNamespaces&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("namespaces"), responseHeaders));
		Namespaces namespaces = unauthorizedFlickr.machinetagsOperations().getNamespaces(null, null, null);
		assertNamespaces(namespaces);
	}

	@Test
	public void getPairsTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.machinetags.getPairs&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("pairs"), responseHeaders));
		Pairs pairs = unauthorizedFlickr.machinetagsOperations().getPairs(null, null, null, null);
		assertPairs(pairs);
	}

	

	@Test
	public void getPredicatesTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.machinetags.getPredicates&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("predicates"), responseHeaders));
		Predicates predicates = unauthorizedFlickr.machinetagsOperations().getPredicates(null, null, null);
		assertPredicates(predicates);
	}

	
	@Test
	public void getRecentValuesTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.machinetags.getRecentValues&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getValuesTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?namespace=a&predicate=a&method=flickr.machinetags.getValues&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("values"), responseHeaders));
		 Values values = unauthorizedFlickr.machinetagsOperations().getValues("a", "a", null, null);
		 assertValue(values);
	}
	
	
	private void assertValue(Values values) {
		Assert.assertEquals("a",values.getNamespace());
	}

	private void assertNamespaces(Namespaces namespaces) {
		Assert.assertEquals(5, namespaces.getNamespace().size());
	}

	private void assertPairs(Pairs pairs) {
		Assert.assertEquals(4,  pairs.getPair().size());
	}

	private void assertPredicates(Predicates predicates) {
		Assert.assertEquals(3,  predicates.getPredicate().size());
	}

}