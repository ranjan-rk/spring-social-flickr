package org.springframework.social.flickr.api;

public class Blog{
	String id;
	String name;
	String service;
	String needspassword;
	String url;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getNeedspassword() {
		return needspassword;
	}
	public void setNeedspassword(String needspassword) {
		this.needspassword = needspassword;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}