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
package org.springframework.social.flickr;

import javax.inject.Inject;

import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.FlickrProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private final Flickr flickr;
	
	@Inject
	public HomeController(Flickr flickr) {
		this.flickr = flickr;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		//FlickrProfile fp = flickr.getUserProfile();
		//System.out.println(fp.getStat());
		System.out.println(flickr.userOperations().getUserProfile().getUsername());
		model.addAttribute("welcomeMessage","Welcome to spring social flickr,  "+ flickr.userOperations().getUserProfile().getUsername());
		return "welcomePage";
	}

}