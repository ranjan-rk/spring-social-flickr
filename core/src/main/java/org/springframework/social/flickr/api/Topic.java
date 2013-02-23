
package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Topic{
   	private String author;
   	private Number author_iconfarm;
   	private String author_iconserver;
   	private String authorname;
   	private Number can_delete;
   	private Number can_edit;
   	private Number can_reply;
   	private String datecreate;
   	private String datelastpost;
   	private String group_id;
   	private Number iconfarm;
   	private String iconserver;
   	private boolean is_locked;
   	private Number is_pro;
   	private Number count_replies;
   	private String is_sticky;
   	private String message;
   	private String name;
   	private Number page;
   	private Number pages;
   	private Number per_page;
   	private String role;
   	private String subject;
   	private String topic_id;
   	private String total;
   	private String id;
   	private String last_reply;

 	public String getAuthor(){
		return this.author;
	}
	public void setAuthor(String author){
		this.author = author;
	}
 	public Number getAuthor_iconfarm(){
		return this.author_iconfarm;
	}
	public void setAuthor_iconfarm(Number author_iconfarm){
		this.author_iconfarm = author_iconfarm;
	}
 	public String getAuthor_iconserver(){
		return this.author_iconserver;
	}
	public void setAuthor_iconserver(String author_iconserver){
		this.author_iconserver = author_iconserver;
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
 	public Number getCan_reply(){
		return this.can_reply;
	}
	public void setCan_reply(Number can_reply){
		this.can_reply = can_reply;
	}
 	public String getDatecreate(){
		return this.datecreate;
	}
	public void setDatecreate(String datecreate){
		this.datecreate = datecreate;
	}
 	public String getDatelastpost(){
		return this.datelastpost;
	}
	public void setDatelastpost(String datelastpost){
		this.datelastpost = datelastpost;
	}
 	public String getGroup_id(){
		return this.group_id;
	}
	public void setGroup_id(String group_id){
		this.group_id = group_id;
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
 	public boolean getIs_locked(){
		return this.is_locked;
	}
	public void setIs_locked(boolean is_locked){
		this.is_locked = is_locked;
	}
 	public Number getIs_pro(){
		return this.is_pro;
	}
	public void setIs_pro(Number is_pro){
		this.is_pro = is_pro;
	}
 	public String getIs_sticky(){
		return this.is_sticky;
	}
	public void setIs_sticky(String is_sticky){
		this.is_sticky = is_sticky;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(LinkedHashMap<String,String>  message){
		this.message = message.get(FlickrConstant.JSONCONTENT);
	}
 	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
 	public Number getPage(){
		return this.page;
	}
	public void setPage(Number page){
		this.page = page;
	}
 	public Number getPages(){
		return this.pages;
	}
	public void setPages(Number pages){
		this.pages = pages;
	}
 	public Number getPer_page(){
		return this.per_page;
	}
	public void setPer_page(Number per_page){
		this.per_page = per_page;
	}
 	public String getRole(){
		return this.role;
	}
	public void setRole(String role){
		this.role = role;
	}
 	public String getSubject(){
		return this.subject;
	}
	public void setSubject(String subject){
		this.subject = subject;
	}
 	public String getTopic_id(){
		return this.topic_id;
	}
	public void setTopic_id(String topic_id){
		this.topic_id = topic_id;
	}
 	public String getTotal(){
		return this.total;
	}
	public void setTotal(String total){
		this.total = total;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Number getCount_replies() {
		return count_replies;
	}
	public void setCount_replies(Number count_replies) {
		this.count_replies = count_replies;
	}
	public String getLast_reply() {
		return last_reply;
	}
	public void setLast_reply(String last_reply) {
		this.last_reply = last_reply;
	}
}
