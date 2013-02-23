
package org.springframework.social.flickr.api;


public class Member{
   	private Number iconfarm;
   	private String iconserver;
   	private String membertype;
   	private String nsid;
   	private String realname;
   	private String username;

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
 	public String getMembertype(){
		return this.membertype;
	}
	public void setMembertype(String membertype){
		this.membertype = membertype;
	}
 	public String getNsid(){
		return this.nsid;
	}
	public void setNsid(String nsid){
		this.nsid = nsid;
	}
 	public String getRealname(){
		return this.realname;
	}
	public void setRealname(String realname){
		this.realname = realname;
	}
 	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username = username;
	}
}
