
package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Group2{
   	private String description;//
   	private Number iconfarm;
   	private String iconserver;
   	private String id;
   	private Number is_admin;
   	private Number is_member;
   	private Number is_moderator;
   	private Number ispoolmoderated;
   	private String lang;
   	private String members;//
   	private String name;//
   	private String pool_count;//
   	private String privacy;//
   	private Restrictions restrictions;
   	private Roles roles;
   	private String rules;//
   	private Throttle throttle;
   	private String topic_count;//

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
 	public Number getIs_admin(){
		return this.is_admin;
	}
	public void setIs_admin(Number is_admin){
		this.is_admin = is_admin;
	}
 	public Number getIs_member(){
		return this.is_member;
	}
	public void setIs_member(Number is_member){
		this.is_member = is_member;
	}
 	public Number getIs_moderator(){
		return this.is_moderator;
	}
	public void setIs_moderator(Number is_moderator){
		this.is_moderator = is_moderator;
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
	public void setMembers(LinkedHashMap<String,String>  members){
		this.members = members.get(FlickrConstant.JSONCONTENT);;
	}
 	public String getName(){
		return this.name;
	}
	public void setName(LinkedHashMap<String,String> name){
		this.name = name.get(FlickrConstant.JSONCONTENT);
	}
 	public String getPool_count(){
		return this.pool_count;
	}
	public void setPool_count(LinkedHashMap<String,String> pool_count){
		this.pool_count = pool_count.get(FlickrConstant.JSONCONTENT);
	}
 	public String getPrivacy(){
		return this.privacy;
	}
	public void setPrivacy(LinkedHashMap<String,String> privacy){
		this.privacy = privacy.get(FlickrConstant.JSONCONTENT);
	}
 	public Restrictions getRestrictions(){
		return this.restrictions;
	}
	public void setRestrictions(Restrictions restrictions){
		this.restrictions = restrictions;
	}
 	public Roles getRoles(){
		return this.roles;
	}
	public void setRoles(Roles roles){
		this.roles = roles;
	}
 	public String getRules(){
		return this.rules;
	}
	public void setRules(LinkedHashMap<String,String> rules){
		this.rules = rules.get(FlickrConstant.JSONCONTENT);
	}
 	public Throttle getThrottle(){
		return this.throttle;
	}
	public void setThrottle(Throttle throttle){
		this.throttle = throttle;
	}
 	public String getTopic_count(){
		return this.topic_count;
	}
	public void setTopic_count(LinkedHashMap<String,String> topic_count){
		this.topic_count = topic_count.get(FlickrConstant.JSONCONTENT);
	}
}
