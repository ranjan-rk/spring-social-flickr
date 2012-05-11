package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;
import java.util.List;

public class Photoset {
	String id;
	String owner;
	String primary;
	String secret;
	String farm;
	String photos;
	String videos;
	Integer countViews;
	Integer countComments;
	Integer countPhotos;
	Integer countVideos;
	String title;
	String description;
	boolean canComment;
	String dateCreate;
	String dateUpdate;
	String url;
	String needsInterstitial;
	String visibilityCanSeeSet;
	List<Photo> photo;
	String page;
	String pages;
	String perpage;
	String total;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getFarm() {
		return farm;
	}
	public void setFarm(String farm) {
		this.farm = farm;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public Integer getCountViews() {
		return countViews;
	}
	public void setCountViews(Integer countViews) {
		this.countViews = countViews;
	}
	public Integer getCountComments() {
		return countComments;
	}
	public void setCountComments(Integer countComments) {
		this.countComments = countComments;
	}
	public Integer getCountPhotos() {
		return countPhotos;
	}
	public void setCountPhotos(Integer countPhotos) {
		this.countPhotos = countPhotos;
	}
	public Integer getCountVideos() {
		return countVideos;
	}
	public void setCountVideos(Integer countVideos) {
		this.countVideos = countVideos;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(LinkedHashMap<String, String> title) {
		this.title = title.get(FlickrConstant.JSONCONTENT);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(LinkedHashMap<String, String> description) {
		this.description = description.get(FlickrConstant.JSONCONTENT);
	}
	public boolean isCanComment() {
		return canComment;
	}
	public void setCanComment(boolean canComment) {
		this.canComment = canComment;
	}
	public String getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(String dateCreate) {
		this.dateCreate = dateCreate;
	}
	public String getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(String dateUpdate) {
		this.dateUpdate = dateUpdate;
	}
	public String getVideos() {
		return videos;
	}
	public void setVideos(String videos) {
		this.videos = videos;
	}
	public String getNeedsInterstitial() {
		return needsInterstitial;
	}
	public void setNeedsInterstitial(String needsInterstitial) {
		this.needsInterstitial = needsInterstitial;
	}
	public String getVisibilityCanSeeSet() {
		return visibilityCanSeeSet;
	}
	public void setVisibilityCanSeeSet(String visibilityCanSeeSet) {
		this.visibilityCanSeeSet = visibilityCanSeeSet;
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
	public List<Photo> getPhoto() {
		return photo;
	}
	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}
}
