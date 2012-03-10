package org.springframework.social.flickr.api;

public class Group {
	String name;
	String nsid;
	String iconFarm;
	String iconServer;
	boolean admin;
	boolean eighteenPlus;
	boolean invitationOnly;
	String members;
	String poolCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
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
}
