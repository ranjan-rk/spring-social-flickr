
package org.springframework.social.flickr.api;


public class Editability{
   	private boolean canaddmeta;
   	private boolean cancomment;

 	public boolean getCanaddmeta(){
		return this.canaddmeta;
	}
	public void setCanaddmeta(boolean canaddmeta){
		this.canaddmeta = canaddmeta;
	}
 	public boolean getCancomment(){
		return this.cancomment;
	}
	public void setCancomment(boolean cancomment){
		this.cancomment = cancomment;
	}
}
