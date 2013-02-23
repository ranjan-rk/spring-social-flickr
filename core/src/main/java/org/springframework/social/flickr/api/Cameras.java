
package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Cameras{
   	private String brand;
   	private ArrayList<Camera> camera;

 	public String getBrand(){
		return this.brand;
	}
	public void setBrand(String brand){
		this.brand = brand;
	}
 	public ArrayList<Camera> getCamera(){
		return this.camera;
	}
	public void setCamera(ArrayList<Camera> camera){
		this.camera = camera;
	}
}
