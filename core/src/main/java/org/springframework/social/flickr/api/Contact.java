package org.springframework.social.flickr.api;

public class Contact {

	private Number family;
	private Number friend;
	private Number iconfarm;
	private String iconserver;
	private Number ignored;
	private String location;
	private String nsid;
	private String path_alias;
	private String realname;
	private String username;

	public Number getFamily() {
		return this.family;
	}

	public void setFamily(Number family) {
		this.family = family;
	}

	public Number getFriend() {
		return this.friend;
	}

	public void setFriend(Number friend) {
		this.friend = friend;
	}

	public Number getIconfarm() {
		return this.iconfarm;
	}

	public void setIconfarm(Number iconfarm) {
		this.iconfarm = iconfarm;
	}

	public String getIconserver() {
		return this.iconserver;
	}

	public void setIconserver(String iconserver) {
		this.iconserver = iconserver;
	}

	public Number getIgnored() {
		return this.ignored;
	}

	public void setIgnored(Number ignored) {
		this.ignored = ignored;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getNsid() {
		return this.nsid;
	}

	public void setNsid(String nsid) {
		this.nsid = nsid;
	}

	public String getPath_alias() {
		return this.path_alias;
	}

	public void setPath_alias(String path_alias) {
		this.path_alias = path_alias;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
