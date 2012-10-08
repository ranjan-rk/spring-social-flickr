
package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Institution{
   	private String date_launch;
   	private String name;
   	private String nsid;
   	private Urls urls;

 	public String getDate_launch(){
		return this.date_launch;
	}
	public void setDate_launch(String date_launch){
		this.date_launch = date_launch;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(LinkedHashMap<String,String> name){
		this.name = name.get(FlickrConstant.JSONCONTENT);;
	}
 	public String getNsid(){
		return this.nsid;
	}
	public void setNsid(String nsid){
		this.nsid = nsid;
	}
 	public Urls getUrls(){
		return this.urls;
	}
	public void setUrls(Urls urls){
		this.urls = urls;
	}
}
