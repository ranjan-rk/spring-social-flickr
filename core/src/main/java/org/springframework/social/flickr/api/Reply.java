package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Reply {

   	private String author;
   	private String authorname;
   	private Number can_delete;
   	private Number can_edit;
   	private String datecreate;
   	private Number iconfarm;
   	private String iconserver;
   	private String id;
   	private Number is_pro;
   	private String lastedit;
   	private String message;
   	private String role;

 	public String getAuthor(){
		return this.author;
	}
	public void setAuthor(String author){
		this.author = author;
	}
 	public String getAuthorname(){
		return this.authorname;
	}
	public void setAuthorname(String authorname){
		this.authorname = authorname;
	}
 	public Number getCan_delete(){
		return this.can_delete;
	}
	public void setCan_delete(Number can_delete){
		this.can_delete = can_delete;
	}
 	public Number getCan_edit(){
		return this.can_edit;
	}
	public void setCan_edit(Number can_edit){
		this.can_edit = can_edit;
	}
 	public String getDatecreate(){
		return this.datecreate;
	}
	public void setDatecreate(String datecreate){
		this.datecreate = datecreate;
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
 	public Number getIs_pro(){
		return this.is_pro;
	}
	public void setIs_pro(Number is_pro){
		this.is_pro = is_pro;
	}
 	public String getLastedit(){
		return this.lastedit;
	}
	public void setLastedit(String lastedit){
		this.lastedit = lastedit;
	}
 	public String getMessage(){
		return this.message;
	}
	public void setMessage(LinkedHashMap<String,String>  message){
		this.message = message.get(FlickrConstant.JSONCONTENT);
	}
 	public String getRole(){
		return this.role;
	}
	public void setRole(String role){
		this.role = role;
	}
}
