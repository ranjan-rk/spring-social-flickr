
package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Item{
   	private Activity activity;
   	private Number comments;
   	private Number farm;
   	private Number faves;
   	private Number iconfarm;
   	private String iconserver;
   	private String id;
   	private String media;
   	private Number notes;
   	private String owner;
   	private String ownername;
   	private String secret;
   	private String server;
   	private String title;
   	private String type;
   	private Number views;

 	public Activity getActivity(){
		return this.activity;
	}
	public void setActivity(Activity activity){
		this.activity = activity;
	}
 	public Number getComments(){
		return this.comments;
	}
	public void setComments(Number comments){
		this.comments = comments;
	}
 	public Number getFarm(){
		return this.farm;
	}
	public void setFarm(Number farm){
		this.farm = farm;
	}
 	public Number getFaves(){
		return this.faves;
	}
	public void setFaves(Number faves){
		this.faves = faves;
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
 	public String getMedia(){
		return this.media;
	}
	public void setMedia(String media){
		this.media = media;
	}
 	public Number getNotes(){
		return this.notes;
	}
	public void setNotes(Number notes){
		this.notes = notes;
	}
 	public String getOwner(){
		return this.owner;
	}
	public void setOwner(String owner){
		this.owner = owner;
	}
 	public String getOwnername(){
		return this.ownername;
	}
	public void setOwnername(String ownername){
		this.ownername = ownername;
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
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(LinkedHashMap<String,String> title){
		this.title = title.get(FlickrConstant.JSONCONTENT);
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
 	public Number getViews(){
		return this.views;
	}
	public void setViews(Number views){
		this.views = views;
	}
}
