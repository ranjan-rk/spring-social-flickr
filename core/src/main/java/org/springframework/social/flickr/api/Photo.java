package org.springframework.social.flickr.api;

public class Photo {
	String id;
	String owner;
	String secret;
	String server;
	String farm;
	String title;
	boolean isPublic;
	boolean isFriend;
	boolean isFamily;
	String url;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getFarm() {
		return farm;
	}

	public void setFarm(String farm) {
		this.farm = farm;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public boolean isFriend() {
		return isFriend;
	}

	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}

	public boolean isFamily() {
		return isFamily;
	}

	public void setFamily(boolean isFamily) {
		this.isFamily = isFamily;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		String tempUrl = "http://farm"+getFarm()+".staticflickr.com/"+getServer()+"/"+getId()+"_"+getSecret()+".jpg";
		url = tempUrl;
		return url;
	}

	public String getUrl(PhotoSizeEnum size) {
		String tempUrl = "http://farm"+getFarm()+".staticflickr.com/"+getServer()+"/"+getId()+"_"+getSecret()+"_"+size+".jpg";
		url = tempUrl;
		return url;
	}
}
