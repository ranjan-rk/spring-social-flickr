package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Gallery {
   	private String countComments;
   	private String countPhotos;
   	private String countVideos;
   	private String countViews;
   	private String dateCreate;
   	private String dateUpdate;
   	private String description;
   	private Number iconfarm;
   	private String iconserver;
   	private String id;
   	private String owner;
   	private Number primaryPhotoFarm;
   	private String primaryPhotoId;
   	private String primaryPhotoSecret;
   	private String primaryPhotoServer;
   	private String title;
   	private String url;
   	private String username;

 	public String getCount_comments(){
		return this.countComments;
	}
	public void setCount_comments(String count_comments){
		this.countComments = count_comments;
	}
 	public String getCount_photos(){
		return this.countPhotos;
	}
	public void setCount_photos(String count_photos){
		this.countPhotos = count_photos;
	}
 	public String getCount_videos(){
		return this.countVideos;
	}
	public void setCount_videos(String count_videos){
		this.countVideos = count_videos;
	}
 	public String getCount_views(){
		return this.countViews;
	}
	public void setCount_views(String count_views){
		this.countViews = count_views;
	}
 	public String getDate_create(){
		return this.dateCreate;
	}
	public void setDate_create(String date_create){
		this.dateCreate = date_create;
	}
 	public String getDate_update(){
		return this.dateUpdate;
	}
	public void setDate_update(String date_update){
		this.dateUpdate = date_update;
	}
 	public String getDescription(){
		return this.description;
	}
	public void setDescription(LinkedHashMap<String,String>  description){
		this.description = description.get(FlickrConstant.JSONCONTENT);
	}
 	public Number getIconfarm(){
		return this.iconfarm;
	}
	public void setIconfarm(Number iconfarm){
		this.iconfarm = iconfarm;
	}
 	public String getIconserver(){
		return this.iconserver;
	}
	public void setIconserver(String iconserver){
		this.iconserver = iconserver;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public String getOwner(){
		return this.owner;
	}
	public void setOwner(String owner){
		this.owner = owner;
	}
 	public Number getPrimary_photo_farm(){
		return this.primaryPhotoFarm;
	}
	public void setPrimary_photo_farm(Number primary_photo_farm){
		this.primaryPhotoFarm = primary_photo_farm;
	}
 	public String getPrimary_photo_id(){
		return this.primaryPhotoId;
	}
	public void setPrimary_photo_id(String primary_photo_id){
		this.primaryPhotoId = primary_photo_id;
	}
 	public String getPrimary_photo_secret(){
		return this.primaryPhotoSecret;
	}
	public void setPrimary_photo_secret(String primary_photo_secret){
		this.primaryPhotoSecret = primary_photo_secret;
	}
 	public String getPrimary_photo_server(){
		return this.primaryPhotoServer;
	}
	public void setPrimary_photo_server(String primary_photo_server){
		this.primaryPhotoServer = primary_photo_server;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(LinkedHashMap<String,String> title){
		this.title = title.get(FlickrConstant.JSONCONTENT);;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
 	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}
}
