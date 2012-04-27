
package org.springframework.social.flickr.api;

import java.util.List;

public class Sizes{
   	private boolean canblog;
   	private boolean candownload;
   	private boolean canprint;
   	private List<Size> size;

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
 	public List<Size> getSize(){
		return this.size;
	}
	public void setSize(List<Size> size){
		this.size = size;
	}
}
