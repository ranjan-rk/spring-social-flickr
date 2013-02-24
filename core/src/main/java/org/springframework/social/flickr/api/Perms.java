package org.springframework.social.flickr.api;

public class Perms {

	private String id;
	private boolean ispublic;
	private boolean isfriend; 
	private boolean isfamily;
	private boolean iscontact;
	private PermissionEnum permcomment;
	private PermissionEnum permaddmeta;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isIspublic() {
		return ispublic;
	}
	public void setIspublic(boolean ispublic) {
		this.ispublic = ispublic;
	}
	public boolean isIsfriend() {
		return isfriend;
	}
	public void setIsfriend(boolean isfriend) {
		this.isfriend = isfriend;
	}
	public boolean isIsfamily() {
		return isfamily;
	}
	public void setIsfamily(boolean isfamily) {
		this.isfamily = isfamily;
	}
	public PermissionEnum getPermcomment() {
		return permcomment;
	}
	public void setPermcomment(PermissionEnum permcomment) {
		this.permcomment = permcomment;
	}
	public PermissionEnum getPermaddmeta() {
		return permaddmeta;
	}
	public void setPermaddmeta(PermissionEnum permaddmeta) {
		this.permaddmeta = permaddmeta;
	}
	public boolean isIscontact() {
		return iscontact;
	}
	public void setIscontact(boolean iscontact) {
		this.iscontact = iscontact;
	} 
}
