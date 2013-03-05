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
import org.springframework.social.flickr.api.CamerasOperations;
import org.springframework.social.flickr.api.CommonsOperations;
import org.springframework.social.flickr.api.ContactsOperations;
import org.springframework.social.flickr.api.FavoritesOperations;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.GalleriesOperations;
import org.springframework.social.flickr.api.GroupsDiscussRepliesOperations;
import org.springframework.social.flickr.api.GroupsDiscussTopicsOperations;
import org.springframework.social.flickr.api.GroupsMembersOperations;
import org.springframework.social.flickr.api.GroupsOperations;
import org.springframework.social.flickr.api.GroupsPoolsOperations;
import org.springframework.social.flickr.api.InterestingnessOperations;
import org.springframework.social.flickr.api.MachinetagsOperations;
import org.springframework.social.flickr.api.PandaOperations;
import org.springframework.social.flickr.api.PeopleOperations;
import org.springframework.social.flickr.api.PhotoCommentOperations;
import org.springframework.social.flickr.api.PhotoLicenseOperations;
import org.springframework.social.flickr.api.PhotoNoteOperations;
import org.springframework.social.flickr.api.PhotoOperations;
import org.springframework.social.flickr.api.PhotosGeoOperations;
import org.springframework.social.flickr.api.PhotosPeopleOperations;
import org.springframework.social.flickr.api.PhotosSuggestionsOperations;
import org.springframework.social.flickr.api.PhotosetOperations;
import org.springframework.social.flickr.api.PhotosetsCommentsOperations;
import org.springframework.social.flickr.api.PlacesOperations;
import org.springframework.social.flickr.api.PrefsOperations;
import org.springframework.social.flickr.api.ReflectionOperations;
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
    private GroupsOperations groupsOperations;
    private PlacesOperations placesOperations;
    private PrefsOperations prefsOperations;
    private CamerasOperations camerasOperations;
    private ContactsOperations contactsOperations;
    private GroupsDiscussRepliesOperations groupsDiscussRepliesOperations;
    private GroupsDiscussTopicsOperations groupsDiscussTopicsOperations;
    private GroupsMembersOperations groupsMembersOperations;
    private GroupsPoolsOperations groupsPoolsOperations;
    private InterestingnessOperations interestingnessOperations;
    private MachinetagsOperations machinetagsOperations;
    private PandaOperations pandaOperations;
    private PhotosGeoOperations photosGeoOperations;
    private PhotosPeopleOperations photosPeopleOperations;
    private PhotosSuggestionsOperations photosSuggestionsOperations;
    private PhotosetsCommentsOperations photosetsCommentsOperations; 
    private ReflectionOperations reflectionOperations;

	public FlickrTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
    	super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
    	initSubApis(null);
    }
    
	public FlickrTemplate(String consumerKey){
    	super();
    	initSubApis(consumerKey);
    }

	private void initSubApis(String consumerKey) {
		this.peopleOperations = new PeopleTemplate(getRestTemplate(),isAuthorized(),consumerKey);
		this.photoOperations = new PhotoTemplate(getRestTemplate(),isAuthorized(),consumerKey); 
		this.activityOperations = new ActivityTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.commonsOperations = new CommonsTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.favoritesOperations = new FavoritesTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.galleriesOperations = new GalleriesTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.photoCommentOperations = new PhotoCommentTemplate(getRestTemplate(),isAuthorized(),consumerKey);
		this.photoLicenseOperations = new PhotoLicenseTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.photoNoteOperations = new PhotoNoteTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.photosetOperations = new PhotosetTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.blogsOperations = new BlogsTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.groupsOperations = new GroupsTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.placesOperations = new PlacesTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.prefsOperations = new PrefsTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.camerasOperations = new CamerasTemplate(getRestTemplate(),  isAuthorized(),consumerKey);
		this.contactsOperations = new ContactsTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.groupsDiscussRepliesOperations = new GroupsDiscussRepliesTemplate(getRestTemplate(), isAuthorized(), consumerKey);
		this.groupsDiscussTopicsOperations  = new GroupsDiscussTopicsTemplate(getRestTemplate(), isAuthorized(), consumerKey);
		this.groupsMembersOperations = new GroupsMembersTemplate(getRestTemplate(), isAuthorized(), consumerKey);
		this.groupsPoolsOperations = new GroupsPoolsTemplate(getRestTemplate(), isAuthorized(), consumerKey);
		this.interestingnessOperations = new InterestingnessTemplate(getRestTemplate(), isAuthorized(), consumerKey);
		this.machinetagsOperations = new MachinetagsTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.pandaOperations = new PandaTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.photosGeoOperations = new PhotosGeoTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.photosPeopleOperations = new PhotosPeopleTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.photosSuggestionsOperations = new PhotosSuggestionsTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.photosetsCommentsOperations = new PhotosetsCommentsTemplate(getRestTemplate(), isAuthorized(),consumerKey);
		this.reflectionOperations = new ReflectionTemplate(getRestTemplate(), isAuthorized(),consumerKey);
	}

	private void initSubApis() {
		//this.peopleOperations = new PeopleTemplate(getRestTemplate(),isAuthorized());
		//this.photoOperations = new PhotoTemplate(getRestTemplate(),isAuthorized()); 
		//this.photoCommentOperations = new PhotoCommentTemplate(getRestTemplate(),isAuthorized() );
		//this.photoLicenseOperations = new PhotoLicenseTemplate(getRestTemplate(), isAuthorized());
		//this.photoNoteOperations = new PhotoNoteTemplate(getRestTemplate(), isAuthorized());
		//this.photosetOperations = new PhotosetTemplate(getRestTemplate(), isAuthorized());
		//this.galleriesOperations = new GalleriesTemplate(getRestTemplate(), isAuthorized());
		//this.favoritesOperations = new FavoritesTemplate(getRestTemplate(), isAuthorized());
		//this.activityOperations = new ActivityTemplate(getRestTemplate(), isAuthorized());
		//this.blogsOperations = new BlogsTemplate(getRestTemplate(), isAuthorized());
		//this.commonsOperations = new CommonsTemplate(getRestTemplate(), isAuthorized());
		//this.groupsOperations = new GroupsTemplate(getRestTemplate(), isAuthorized());
		//this.placesOperations = new PlacesTemplate(getRestTemplate(), isAuthorized());
		//this.prefsOperations = new PrefsTemplate(getRestTemplate(), isAuthorized());
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
    
    public GroupsOperations groupsOperations(){
    	return groupsOperations;
    }
    
    public PlacesOperations placesOperations(){
    	return placesOperations;
    }
    
    public PrefsOperations prefsOperations(){
    	return prefsOperations;
    }
    
    public CamerasOperations camerasOperations(){
    	return camerasOperations;
    }
    public ContactsOperations contactsOperations(){
    	return contactsOperations;
    }
    public GroupsDiscussRepliesOperations groupsDiscussRepliesOperations(){
    	return groupsDiscussRepliesOperations;
    }
    public GroupsDiscussTopicsOperations groupsDiscussTopicsOperations(){
    	return groupsDiscussTopicsOperations;
    }
    public GroupsMembersOperations groupsMembersOperations(){
    	return groupsMembersOperations;
    }
    public GroupsPoolsOperations groupsPoolsOperations(){
    	return groupsPoolsOperations;
    }
    public InterestingnessOperations interestingnessOperations(){
    	return interestingnessOperations;
    }
    public MachinetagsOperations machinetagsOperations(){
    	return machinetagsOperations;
    }
    public PandaOperations pandaOperations(){
    	return pandaOperations;
    }
    public PhotosGeoOperations photosGeoOperations(){
    	return photosGeoOperations;
    }
    public PhotosPeopleOperations photosPeopleOperations(){
    	return photosPeopleOperations;
    }
    public PhotosSuggestionsOperations photosSuggestionsOperations(){
    	return photosSuggestionsOperations;
    }
    public PhotosetsCommentsOperations photosetsCommentsOperations(){
    	return photosetsCommentsOperations;
    }
    public ReflectionOperations reflectionOperations(){
    	return reflectionOperations;
    }
}
