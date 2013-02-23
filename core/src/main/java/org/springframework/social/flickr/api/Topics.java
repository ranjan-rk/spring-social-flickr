
package org.springframework.social.flickr.api;

import java.util.List;

public class Topics{
   	private String group_id;
   	private Number iconfarm;
   	private String iconserver;
   	private Number ispoolmoderated;
   	private String lang;
   	private String members;
   	private String name;
   	private Number page;
   	private Number pages;
   	private Number per_page;
   	private String privacy;
   	private List<Topic> topic;
   	private String total;

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
 	public Number getIspoolmoderated(){
		return this.ispoolmoderated;
	}
	public void setIspoolmoderated(Number ispoolmoderated){
		this.ispoolmoderated = ispoolmoderated;
	}
 	public String getLang(){
		return this.lang;
	}
	public void setLang(String lang){
		this.lang = lang;
	}
 	public String getMembers(){
		return this.members;
	}
	public void setMembers(String members){
		this.members = members;
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
 	public String getPrivacy(){
		return this.privacy;
	}
	public void setPrivacy(String privacy){
		this.privacy = privacy;
	}
 	public List<Topic> getTopic(){
		return this.topic;
	}
	public void setTopic(List<Topic> topic){
		this.topic = topic;
	}
 	public String getTotal(){
		return this.total;
	}
	public void setTotal(String total){
		this.total = total;
	}
}
