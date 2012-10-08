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
import org.springframework.social.flickr.api.ActivityOperations;
import org.springframework.social.flickr.api.BlogsOperations;
import org.springframework.social.flickr.api.CommonsOperations;
import org.springframework.social.flickr.api.FavoritesOperations;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.GalleriesOperations;
import org.springframework.social.flickr.api.PeopleOperations;
import org.springframework.social.flickr.api.PhotoCommentOperations;
import org.springframework.social.flickr.api.PhotoLicenseOperations;
import org.springframework.social.flickr.api.PhotoNoteOperations;
import org.springframework.social.flickr.api.PhotoOperations;
import org.springframework.social.flickr.api.PhotosetOperations;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;

/**
 * @author HemantS
 *
 */
public class FlickrTemplate extends AbstractOAuth1ApiBinding implements Flickr {
	private PeopleOperations peopleOperations;
    private PhotoOperations photoOperations;
    private PhotoCommentOperations photoCommentOperations;
    private PhotoLicenseOperations photoLicenseOperations;
    private PhotoNoteOperations photoNoteOperations; 
    private PhotosetOperations photosetOperations;
    private GalleriesOperations galleriesOperations;
    private FavoritesOperations favoritesOperations;
    private ActivityOperations activityOperations;
    private BlogsOperations blogsOperations;
    private CommonsOperations commonsOperations;



	public FlickrTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
    	super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    	initSubApis();
    }
    
	public FlickrTemplate(){
    	super();
    	initSubApis();
    }

	private void initSubApis() {
		this.peopleOperations = new PeopleTemplate(getRestTemplate(),isAuthorized());
		this.photoOperations = new PhotoTemplate(getRestTemplate(),isAuthorized()); 
		this.photoCommentOperations = new PhotoCommentTemplate(getRestTemplate(),isAuthorized() );
		this.photoLicenseOperations = new PhotoLicenseTemplate(getRestTemplate(), isAuthorized());
		this.photoNoteOperations = new PhotoNoteTemplate(getRestTemplate(), isAuthorized());
		this.photosetOperations = new PhotosetTemplate(getRestTemplate(), isAuthorized());
		this.galleriesOperations = new GalleriesTemplate(getRestTemplate(), isAuthorized());
		this.favoritesOperations = new FavoritesTemplate(getRestTemplate(), isAuthorized());
		this.activityOperations = new ActivityTemplate(getRestTemplate(), isAuthorized());
		this.blogsOperations = new BlogsTemplate(getRestTemplate(), isAuthorized());
		this.commonsOperations = new CommonsTemplate(getRestTemplate(), isAuthorized());
	}
	
	
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

	public PeopleOperations peopleOperations() {
		return peopleOperations;
	}


	public PhotoOperations photoOperations() {
		return photoOperations;
	}

	public PhotoCommentOperations photoCommentOperations() {
		return photoCommentOperations;
	}

	public PhotoLicenseOperations photoLicenseOperations() {
		return photoLicenseOperations;
	}

	public PhotoNoteOperations photoNoteOperations() {
		return photoNoteOperations;
	}

	public PhotosetOperations photosetOperations() {
		return photosetOperations;
	}

	public GalleriesOperations galleriesOperations() {
		return galleriesOperations;
	}

	public FavoritesOperations favoritesOperations() {
		return favoritesOperations;
	}

	public ActivityOperations activityOperations() {
		return activityOperations;
	}
    
    public BlogsOperations blogsOperations(){
    	return blogsOperations;
    }
    public CommonsOperations commonsOperations(){
    	return commonsOperations;
    }

}
