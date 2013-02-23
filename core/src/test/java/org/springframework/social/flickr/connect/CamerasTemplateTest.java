package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Brands;
import org.springframework.social.flickr.api.Cameras;

public class CamerasTemplateTest  extends AbstractFlickrApiTest{
	@Test
	public void getBrandModelsTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?brand=apple&method=flickr.cameras.getBrandModels&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("cameras"), responseHeaders));
		Cameras cameras = unauthorizedFlickr.camerasOperations().getBrandModels("apple");
		assertCameras(cameras);
	}
	@Test
	public void getBrandsTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.cameras.getBrands&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("brands"), responseHeaders));
		Brands brands= unauthorizedFlickr.camerasOperations().getBrands();
		assertBrands(brands);
	}
	private void assertBrands(Brands brands) {
		Assert.assertEquals(41, brands.getBrand().size());
	}
	private void assertCameras(Cameras cameras) {
		Assert.assertEquals("apple", cameras.getBrand());
		
	}

}
