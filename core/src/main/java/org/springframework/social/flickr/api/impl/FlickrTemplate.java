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
package org.springframework.social.flickr.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.UserOperations;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;

public class FlickrTemplate extends AbstractOAuth1ApiBinding implements Flickr {
    //private String URL_TO_ACCESS_PROFILE = "http://api.flickr.com/services/rest/?method=flickr.test.login&format=json&nojsoncallback=1";
	private UserOperations userOperations;
    



	public FlickrTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
    	super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    	initSubApis();
    }
    
	public FlickrTemplate(){
    	super();
    	initSubApis();
    }

	private void initSubApis() {
		System.out.println("isAuthorized() :"+isAuthorized());
		this.userOperations = new UserTemplate(getRestTemplate(),isAuthorized());
		
	}
	/*
    @Override
    public FlickrProfile getUserProfile() {
    System.out.println("And the url is :  " + URL_TO_ACCESS_PROFILE);
	FlickrProfile flickrProfile = getRestTemplate().getForObject(URL_TO_ACCESS_PROFILE, FlickrProfile.class);
	return flickrProfile;
    }
    */
    @Override
    protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super.getJsonMessageConverter();			
		FlickrObjectMapper objectMapper = new FlickrObjectMapper();
		objectMapper.registerModule(new FlickrModule());
		objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.enable(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE);
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.TEXT_PLAIN);
		supportedMediaTypes.add(MediaType.TEXT_XML);
		supportedMediaTypes.add(MediaType.APPLICATION_JSON);
		converter.setSupportedMediaTypes(supportedMediaTypes);
		converter.setObjectMapper(objectMapper);
		return converter;
    }
    
    public UserOperations userOperations() {
		return userOperations;
	}

}
