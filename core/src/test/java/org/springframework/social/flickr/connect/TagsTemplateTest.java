package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Clusters;
import org.springframework.social.flickr.api.Hottags;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.Who;

/**
 * @author HemantS
 *
 */
public class TagsTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void getClusterPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?tag=apple&method=flickr.tags.getClusterPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("tagphotos"), responseHeaders));
		Photos photos = flickr.tagsOperations().getClusterPhotos("apple", null);
		assertPhotos(photos);
	}



	@Test
	public void getClustersTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?tag=apple&method=flickr.tags.getClusters&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("clusters"), responseHeaders));
		Clusters clusters = flickr.tagsOperations().getClusters("apple");
		assertClusters(clusters);
	}





	@Test
	public void getHotListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getHotList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("hottags"), responseHeaders));
		Hottags hottags = flickr.tagsOperations().getHotList(null, null);
		assertClusters(hottags);
	}





	@Test
	public void getListPhotoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getListPhoto&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
		
	}

	@Test
	public void getListUserTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getListUser&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("who"), responseHeaders));
		Who who = flickr.tagsOperations().getListUser(null);
		assertWho(who);
	}

	@Test
	public void getListUserPopularTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getListUserPopular&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getListUserRawTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getListUserRaw&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getMostFrequentlyUsedTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getMostFrequentlyUsed&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void getRelatedTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.tags.getRelated&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}
	private void assertPhotos(Photos photos) {
		Assert.assertEquals(24, photos.getPhoto().size());
	}
	private void assertClusters(Clusters clusters) {
		Assert.assertEquals(4,clusters.getCluster().size());
	}
	private void assertClusters(Hottags hottags) {
		Assert.assertEquals("20", hottags.getCount());
	}
	private void assertWho(Who who) {
		Assert.assertEquals("73562874@N08", who.getId());
	}


}