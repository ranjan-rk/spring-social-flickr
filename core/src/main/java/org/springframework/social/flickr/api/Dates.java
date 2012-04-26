
package org.springframework.social.flickr.api;


public class Dates{
   	private String lastupdate;
   	private String posted;
   	private String taken;
   	private String takengranularity;

 	public String getLastupdate(){
		return this.lastupdate;
	}
	public void setLastupdate(String lastupdate){
		this.lastupdate = lastupdate;
	}
 	public String getPosted(){
		return this.posted;
	}
	public void setPosted(String posted){
		this.posted = posted;
	}
 	public String getTaken(){
		return this.taken;
	}
	public void setTaken(String taken){
		this.taken = taken;
	}
 	public String getTakengranularity(){
		return this.takengranularity;
	}
	public void setTakengranularity(String takengranularity){
		this.takengranularity = takengranularity;
	}
}
