
package org.springframework.social.flickr.api;


public class Visibility{
   	private boolean isfamily;
   	private boolean isfriend;
   	private boolean ispublic;

 	public boolean getIsfamily(){
		return this.isfamily;
	}
	public void setIsfamily(boolean isfamily){
		this.isfamily = isfamily;
	}
 	public boolean getIsfriend(){
		return this.isfriend;
	}
	public void setIsfriend(boolean isfriend){
		this.isfriend = isfriend;
	}
 	public boolean getIspublic(){
		return this.ispublic;
	}
	public void setIspublic(boolean ispublic){
		this.ispublic = ispublic;
	}
}
