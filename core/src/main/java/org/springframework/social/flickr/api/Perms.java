package org.springframework.social.flickr.api;

public class Perms {

	private String id;
	private boolean ispublic;
	private boolean isfriend; 
	private boolean isfamily;
	private String permcomment;
	private String permaddmeta;
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
	public String getPermcomment() {
		return permcomment;
	}
	public void setPermcomment(String permcomment) {
		this.permcomment = permcomment;
	}
	public String getPermaddmeta() {
		return permaddmeta;
	}
	public void setPermaddmeta(String permaddmeta) {
		this.permaddmeta = permaddmeta;
	} 
}
