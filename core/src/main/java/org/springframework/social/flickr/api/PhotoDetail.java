
package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class PhotoDetail{
   	
   	private String comments;
   	private Dates dates;
   	private String dateuploaded;
   	private String description;
   	private Editability editability;
   	private String farm;
   	private String id;
   	private boolean isfavorite;
   	private String license;
   	private String media;
   	private Notes notes;
   	private Owner owner;
   	private People people;
   	private Permissions permissions;
   	private Publiceditability publiceditability;
   	private String rotation;
   	private String safety_level;
   	private String secret;
   	private String server;
   	private Tags tags;
   	private String title;
   	private Urls urls;
   	private Usage usage;
   	private String views;
   	private Visibility visibility;

 	public String getComments(){
		return this.comments;
	}
	public void setComments(LinkedHashMap<String,String>  comments){
		this.comments = comments.get(FlickrConstant.JSONCONTENT);
	}
 	public Dates getDates(){
		return this.dates;
	}
	public void setDates(Dates dates){
		this.dates = dates;
	}
 	public String getDateuploaded(){
		return this.dateuploaded;
	}
	public void setDateuploaded(String dateuploaded){
		this.dateuploaded = dateuploaded;
	}
 	public String getDescription(){
		return this.description;
	}
	public void setDescription(LinkedHashMap<String,String> description){
		this.description = description.get(FlickrConstant.JSONCONTENT);
	}
 	public Editability getEditability(){
		return this.editability;
	}
	public void setEditability(Editability editability){
		this.editability = editability;
	}
 	public String getFarm(){
		return this.farm;
	}
	public void setFarm(String farm){
		this.farm = farm;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public boolean getIsfavorite(){
		return this.isfavorite;
	}
	public void setIsfavorite(boolean isfavorite){
		this.isfavorite = isfavorite;
	}
 	public String getLicense(){
		return this.license;
	}
	public void setLicense(String license){
		this.license = license;
	}
 	public String getMedia(){
		return this.media;
	}
	public void setMedia(String media){
		this.media = media;
	}
 	public Notes getNotes(){
		return this.notes;
	}
	public void setNotes(Notes notes){
		this.notes = notes;
	}
 	public Owner getOwner(){
		return this.owner;
	}
	public void setOwner(Owner owner){
		this.owner = owner;
	}
 	public People getPeople(){
		return this.people;
	}
	public void setPeople(People people){
		this.people = people;
	}
 	public Permissions getPermissions(){
		return this.permissions;
	}
	public void setPermissions(Permissions permissions){
		this.permissions = permissions;
	}
 	public Publiceditability getPubliceditability(){
		return this.publiceditability;
	}
	public void setPubliceditability(Publiceditability publiceditability){
		this.publiceditability = publiceditability;
	}
 	public String getRotation(){
		return this.rotation;
	}
	public void setRotation(String rotation){
		this.rotation = rotation;
	}
 	public String getSafety_level(){
		return this.safety_level;
	}
	public void setSafety_level(String safety_level){
		this.safety_level = safety_level;
	}
 	public String getSecret(){
		return this.secret;
	}
	public void setSecret(String secret){
		this.secret = secret;
	}
 	public String getServer(){
		return this.server;
	}
	public void setServer(String server){
		this.server = server;
	}
 	public Tags getTags(){
		return this.tags;
	}
	public void setTags(Tags tags){
		this.tags = tags;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(LinkedHashMap<String,String> title){
		this.title = title.get(FlickrConstant.JSONCONTENT);
	}
 	public Urls getUrls(){
		return this.urls;
	}
	public void setUrls(Urls urls){
		this.urls = urls;
	}
 	public Usage getUsage(){
		return this.usage;
	}
	public void setUsage(Usage usage){
		this.usage = usage;
	}
 	public String getViews(){
		return this.views;
	}
	public void setViews(String views){
		this.views = views;
	}
 	public Visibility getVisibility(){
		return this.visibility;
	}
	public void setVisibility(Visibility visibility){
		this.visibility = visibility;
	}
}
