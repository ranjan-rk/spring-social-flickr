package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Person {
	String id;
	String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(LinkedHashMap<String, String> username) {
		this.username = username.get("_content");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
