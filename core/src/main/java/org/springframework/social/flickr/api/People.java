
package org.springframework.social.flickr.api;

import java.util.ArrayList;


public class People{
   	private String haspeople;
   	private ArrayList<PhotoPerson> person;
   	private String photo_width;
   	private String photo_height;
   	private String total;

 	public String getHaspeople(){
		return this.haspeople;
	}
	public void setHaspeople(String haspeople){
		this.haspeople = haspeople;
	}
	public ArrayList<PhotoPerson> getPerson() {
		return person;
	}
	public void setPerson(ArrayList<PhotoPerson> person) {
		this.person = person;
	}
	public String getPhoto_width() {
		return photo_width;
	}
	public void setPhoto_width(String photo_width) {
		this.photo_width = photo_width;
	}
	public String getPhoto_height() {
		return photo_height;
	}
	public void setPhoto_height(String photo_height) {
		this.photo_height = photo_height;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
}
