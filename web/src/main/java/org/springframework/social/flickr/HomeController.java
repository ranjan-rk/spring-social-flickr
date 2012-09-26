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

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.impl.FlickrException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class HomeController {

	private final Flickr flickr;
	
	
	@Inject
	private CommonsMultipartResolver multipartResolver ; 
	
	@Inject
	public HomeController(Flickr flickr) {
		this.flickr = flickr;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println(multipartResolver);
		model.addAttribute("welcomeMessage","Welcome to spring social flickr,  "+ flickr.peopleOperations().getPersonProfile().getUserName());
		return "welcomePage";
	}

	@RequestMapping(value = "/addtags", method = RequestMethod.POST)
	public String addtags(@RequestParam("photoid") String photoId,@RequestParam("tags") String tags,Model model) {
		flickr.photoOperations().addTags(photoId, tags);
		model.addAttribute("messages","tags : "+tags+" Added successfully..");
		return "welcomePage";
	}
	
	@RequestMapping(value = "/deletephoto", method = RequestMethod.POST)
	public String addtags(@RequestParam("photoid") String photoId , Model model) {
		try{
			flickr.photoOperations().delete(photoId);
		}catch(FlickrException e){
			model.addAttribute("messages",e.getMessage());
			return "welcomePage";
		}
		model.addAttribute("messages","Photo Id : "+photoId+" delete successfully..");
		return "welcomePage";
	}
	
	 @RequestMapping(value = "/uploadphoto",method = RequestMethod.POST)
     public String create(UploadItem uploadItem, BindingResult result,
                     HttpServletRequest request, HttpServletResponse response,
                     HttpSession session) {
             if (result.hasErrors()) {
                     for (ObjectError error : result.getAllErrors()) {
                             System.err.println("Error: " + error.getCode() + " - "
                                             + error.getDefaultMessage());
                     }
                     return "/uploadfile";
             }

             // Some type of file processing...
             System.err.println("-------------------------------------------");
             try {
                     MultipartFile file = uploadItem.getFileData();
                     String fileName = null;
                     InputStream inputStream = null;

                     if (file.getSize() > 0) {
                             inputStream = file.getInputStream();
                             if (file.getSize() > 100000) {
                                     System.out.println("File Size:::" + file.getSize());
                                     return "/uploadfile";
                             }
                             System.out.println("size::" + file.getSize());
                             
                             
                             System.out.println("fileName:" + file.getOriginalFilename());

                             int readBytes = 0;
                             byte[] buffer = new byte[10000];
                             while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                                     System.out.println(readBytes);
                             }
                             //Object obj = flickr.photoOperations().upload(photo , title, null , null , null , null , null )
                             inputStream.close();
                     }

                     // ..........................................
                     session.setAttribute("uploadFile", file.getOriginalFilename());
             } catch (Exception e) {
                     e.printStackTrace();
             }
             return "welcomePage";
     }

	/*Pending
	@RequestMapping(value = "/uploadphoto", method = RequestMethod.POST, headers={"content-type=multipart/form-data"})
	public String addtags(@RequestParam("photo")  byte[]  photo ,@RequestParam("title") String title, Model model ) {
		Object obj =null; 
		try{
				//System.out.println(c);
				System.out.println(photo);
			//obj = flickr.photoOperations().upload(photo , title, null , null , null , null , null );
		}catch(FlickrException e){
			model.addAttribute("messages",e.getMessage());
			return "welcomePage";
		}
		if(obj!=null)
			model.addAttribute("messages","Photo Id : "+obj.toString()+" added successfully..");
		return "welcomePage";
	}
	*/
	
}