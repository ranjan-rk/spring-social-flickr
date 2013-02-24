package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Photo extends Extras{
	String id;
	String owner;
	String ownername;
	String secret;
	String server;
	String farm;
	String title;
	boolean isPublic;
	boolean isFriend;
	boolean isFamily;
	boolean isFaved;
	String thumb;
	String media;
	String url;
	String page;
	String pages;
	String perpage;
	String total;
	String dateFaved;
	Location location;
	ArrayList<Person2> person2; //Persons who favorited this photo

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

	public ArrayList<Person2> getPerson2() {
		return person2;
	}

	public void setPerson2(ArrayList<Person2> person2) {
		this.person2 = person2;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getPerpage() {
		return perpage;
	}

	public void setPerpage(String perpage) {
		this.perpage = perpage;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public boolean isFaved() {
		return isFaved;
	}

	public void setFaved(boolean isFaved) {
		this.isFaved = isFaved;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getDateFaved() {
		return dateFaved;
	}

	public void setDateFaved(String dateFaved) {
		this.dateFaved = dateFaved;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
