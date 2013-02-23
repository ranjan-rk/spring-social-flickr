package org.springframework.social.flickr.api;

public class Group {
	String name;
	String nsid;
	String iconFarm;
	String iconServer;
	String admin;
	boolean eighteenPlus;
	boolean invitationOnly;
	String members;
	String poolCount;
	String topicCount;
	String privacy;
	Number photos;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String isAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getNsid() {
		return nsid;
	}

	public void setNsid(String nsid) {
		this.nsid = nsid;
	}

	public String getIconFarm() {
		return iconFarm;
	}

	public void setIconFarm(String iconFarm) {
		this.iconFarm = iconFarm;
	}

	public String getIconServer() {
		return iconServer;
	}

	public void setIconServer(String iconServer) {
		this.iconServer = iconServer;
	}

	public String getPoolCount() {
		return poolCount;
	}

	public void setPoolCount(String poolCount) {
		this.poolCount = poolCount;
	}

	public boolean isEighteenPlus() {
		return eighteenPlus;
	}

	public void setEighteenPlus(boolean eighteenPlus) {
		this.eighteenPlus = eighteenPlus;
	}

	public boolean isInvitationOnly() {
		return invitationOnly;
	}

	public void setInvitationOnly(boolean invitationOnly) {
		this.invitationOnly = invitationOnly;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(String topicCount) {
		this.topicCount = topicCount;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public Number getPhotos() {
		return photos;
	}

	public void setPhotos(Number photos) {
		this.photos = photos;
	}
}
