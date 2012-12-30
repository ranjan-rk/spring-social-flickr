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

import org.apache.commons.io.IOUtils;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.impl.FlickrException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.inject.Inject;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class HomeController {

    private Flickr flickr;
    private CommonsMultipartResolver multipartResolver;

    @Inject
    public HomeController(CommonsMultipartResolver multipartResolver, Flickr flickr) {
        this.flickr = flickr;
        this.multipartResolver = multipartResolver;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model m) {
        m.addAttribute("flickrUser", flickr.peopleOperations().getPersonProfile().getUserName());
        return "welcome";
    }

    @RequestMapping(value = "/addtags", method = RequestMethod.POST)
    public String addTagsToPhotos(@RequestParam("photoid") String photoId, @RequestParam("tags") String tags, Model model) {
        flickr.photoOperations().addTags(photoId, tags);
        model.addAttribute("messages", "tags : " + tags + " Added successfully..");
        return "welcome";
    }

    @RequestMapping(value = "/deletephoto", method = RequestMethod.POST)
    public String deletePhoto(@RequestParam("photoid") String photoId, Model model) {
        try {
            flickr.photoOperations().delete(photoId);
            model.addAttribute("messages", "Photo Id : " + photoId + " delete successfully..");
        } catch (FlickrException e) {
            model.addAttribute("messages", e.getMessage());
        }
        return "welcome";
    }

    @RequestMapping(value = "/uploadphoto", method = RequestMethod.POST)
    public String create(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam("photo") MultipartFile photo,
            Model model) throws Throwable {

        File tmpFile = File.createTempFile("tmp", photo.getOriginalFilename());
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            outputStream = new FileOutputStream(tmpFile);
            IOUtils.copy(photo.getInputStream(), outputStream);
            Assert.isTrue(tmpFile.exists() && tmpFile.length() > 0, "there must be a file to read from!");
            String photoId = flickr.photoOperations().upload(tmpFile, title, description, null, null, null, null);
            model.addAttribute("photoId", photoId);
        } finally {
            IOUtils.closeQuietly(outputStream);
            IOUtils.closeQuietly(inputStream);
            tmpFile.delete();
        }
        return "welcome";
    }


}