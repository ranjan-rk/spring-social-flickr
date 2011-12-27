/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.flickr.connect;

import org.junit.Test;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.FlickrProfile;
import org.springframework.social.flickr.api.impl.FlickrTemplate;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuthToken;

public class FlickrServiceProviderTest {
    String consumerKey = "consumerKey";
    String consumerSecret = "consumerSecret";

    @Test
    public void getFlickrTemplate() {
	FlickrConnectionFactory flickrConnectionFactory = new FlickrConnectionFactory(consumerKey, consumerSecret);
	OAuth1Operations oauthOperations = flickrConnectionFactory.getOAuthOperations();
	OAuthToken fetchRequestToken = oauthOperations.fetchRequestToken("https://my-callback-url", null);
	
	Flickr flickr = new FlickrTemplate(consumerKey, consumerSecret, fetchRequestToken.getValue(), fetchRequestToken.getSecret());
	FlickrProfile userProfile = flickr.getUserProfile();
	System.out.println(userProfile);
    }
}