
package org.springframework.social.flickr.api;

import java.util.List;

public class Roles{
   	private String admin;
   	private String member;
   	private String moderator;

 	public String getAdmin(){
		return this.admin;
	}
	public void setAdmin(String admin){
		this.admin = admin;
	}
 	public String getMember(){
		return this.member;
	}
	public void setMember(String member){
		this.member = member;
	}
 	public String getModerator(){
		return this.moderator;
	}
	public void setModerator(String moderator){
		this.moderator = moderator;
	}
}
