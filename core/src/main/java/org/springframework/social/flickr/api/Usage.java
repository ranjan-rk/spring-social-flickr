
package org.springframework.social.flickr.api;


/**
 * @author HemantS
 *
 */
public class Usage{
   	private boolean canblog;
   	private boolean candownload;
   	private boolean canprint;
   	private boolean canshare;

 	public boolean getCanblog(){
		return this.canblog;
	}
	public void setCanblog(boolean canblog){
		this.canblog = canblog;
	}
 	public boolean getCandownload(){
		return this.candownload;
	}
	public void setCandownload(boolean candownload){
		this.candownload = candownload;
	}
 	public boolean getCanprint(){
		return this.canprint;
	}
	public void setCanprint(boolean canprint){
		this.canprint = canprint;
	}
 	public boolean getCanshare(){
		return this.canshare;
	}
	public void setCanshare(boolean canshare){
		this.canshare = canshare;
	}
}
