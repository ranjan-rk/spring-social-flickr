package org.springframework.social.flickr.api;


public class Person2 {
	String nsid;
	String userName;
	String realName;
	String faveDate; //Need to convert it into Date
	String iconServer;
	String iconFarm;
	String location;
	public String getNsid() {
		return nsid;
	}
	public void setNsid(String nsid) {
		this.nsid = nsid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFaveDate() {
		return faveDate;
	}
	public void setFaveDate(String faveDate) {
		this.faveDate = faveDate;
	}
	public String getIconServer() {
		return iconServer;
	}
	public void setIconServer(String iconServer) {
		this.iconServer = iconServer;
	}
	public String getIconFarm() {
		return iconFarm;
	}
	public void setIconFarm(String iconFarm) {
		this.iconFarm = iconFarm;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
