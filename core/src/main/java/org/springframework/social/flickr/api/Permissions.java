
package org.springframework.social.flickr.api;


public class Permissions{
   	private String permaddmeta;
   	private String permcomment;

 	public String getPermaddmeta(){
		return this.permaddmeta;
	}
	public void setPermaddmeta(String permaddmeta){
		this.permaddmeta = permaddmeta;
	}
 	public String getPermcomment(){
		return this.permcomment;
	}
	public void setPermcomment(String permcomment){
		this.permcomment = permcomment;
	}
}
