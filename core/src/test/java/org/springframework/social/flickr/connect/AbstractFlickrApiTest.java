package org.springframework.social.flickr.connect;

import org.junit.Before;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.flickr.api.impl.FlickrTemplate;
import org.springframework.social.test.client.MockRestServiceServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author HemantS
 *
 */
public class AbstractFlickrApiTest {
	
	protected FlickrTemplate flickr;
	
	protected FlickrTemplate unauthorizedFlickr;
	
	protected MockRestServiceServer mockServer;
	protected MockRestServiceServer unauthorizedMockServer;
	
	protected HttpHeaders responseHeaders;
	
	 @Before
	    public void getFlickrTemplate() {
	    	flickr = new FlickrTemplate("consumerKey", "consumerSecret", "accessToken", "accessTokenSecret");
			mockServer = MockRestServiceServer.createServer(flickr.getRestTemplate());
			responseHeaders = new HttpHeaders();
			responseHeaders.setContentType(MediaType.TEXT_PLAIN);
			unauthorizedFlickr = new FlickrTemplate();
			// create a mock server just to avoid hitting real flickr if something gets past the authorization check
			unauthorizedMockServer = MockRestServiceServer.createServer(unauthorizedFlickr.getRestTemplate());//TODO: Hemant Need to check this code.
	    }
	
	 protected Resource jsonResource(String filename) {
		 return new ClassPathResource(filename + ".json", getClass());
	 }

}
