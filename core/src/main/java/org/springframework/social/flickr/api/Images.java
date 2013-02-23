
package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Images{
   	private String large;
   	private String small;

 	public String getLarge(){
		return this.large;
	}
	public void setLarge(LinkedHashMap<String,String>  large){
		this.large = large.get(FlickrConstant.JSONCONTENT);
	}
 	public String getSmall(){
		return this.small;
	}
	public void setSmall(LinkedHashMap<String,String>  small){
		this.small = small.get(FlickrConstant.JSONCONTENT);
	}
}
