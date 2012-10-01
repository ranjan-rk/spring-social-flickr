
package org.springframework.social.flickr.api;

import java.util.List;

public class Event{
   	private String _content;
   	private String commentid;
   	private String dateadded;
   	private Number iconfarm;
   	private String iconserver;
   	private String type;
   	private String user;
   	private String username;

 	public String get_content(){
		return this._content;
	}
	public void set_content(String _content){
		this._content = _content;
	}
 	public String getCommentid(){
		return this.commentid;
	}
	public void setCommentid(String commentid){
		this.commentid = commentid;
	}
 	public String getDateadded(){
		return this.dateadded;
	}
	public void setDateadded(String dateadded){
		this.dateadded = dateadded;
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
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
 	public String getUser(){
		return this.user;
	}
	public void setUser(String user){
		this.user = user;
	}
 	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}
}
