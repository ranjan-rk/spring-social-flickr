
package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Activity{
   	private ArrayList<Event> event;

 	public ArrayList<Event> getEvent(){
		return this.event;
	}
	public void setEvent(ArrayList<Event> event){
		this.event = event;
	}
}
