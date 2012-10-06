package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Service {
	String id ; 
	String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(LinkedHashMap<String, String> name) {
		this.name = name.get(FlickrConstant.JSONCONTENT);
	}
}
