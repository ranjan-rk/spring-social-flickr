package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class User {
	
	String id ;
	String nsid;
	String username;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(LinkedHashMap<String, String> username) {
		this.username = username.get(FlickrConstant.JSONCONTENT);
	}
	public String getNsid() {
		return nsid;
	}
	public void setNsid(String nsid) {
		this.nsid = nsid;
	}	
	
	
}
