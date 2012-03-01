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

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.Person;
import org.springframework.web.client.HttpClientErrorException;

public class FlickrAdapter implements ApiAdapter<Flickr> {

    public boolean test(Flickr flickr) {
	try {
	    flickr.peopleOperations().getPersonProfile();
	    return true;
	} catch (HttpClientErrorException e) {
	    e.printStackTrace();
	    return false;
	}
    }

    @Override
    public UserProfile fetchUserProfile(Flickr api) {
    	System.out.println("TODO : Implement fetchUserProfile");
    	return null;
    }

    @Override
    public void setConnectionValues(Flickr flickr, ConnectionValues values) {
    	Person person = flickr.peopleOperations().getPersonProfile();
		values.setProviderUserId(person.getId());
		values.setDisplayName(person.getUserName());
    }

    public void updateStatus(Flickr flickr, String message) {
    	throw new UnsupportedOperationException();
    }
}
