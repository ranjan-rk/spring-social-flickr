
package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Camera{
   	private Details details;
   	private String id;
   	private Images images;
   	private String name;

 	public Details getDetails(){
		return this.details;
	}
	public void setDetails(Details details){
		this.details = details;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public Images getImages(){
		return this.images;
	}
	public void setImages(Images images){
		this.images = images;
	}
	public String getName() {
		return name;
	}
	public void setName(LinkedHashMap<String,String>  name) {
		this.name = name.get(FlickrConstant.JSONCONTENT);
	}
 	
}
