package org.springframework.social.flickr.api;

public enum RotateEnum {
	NINETY("90"),ONEEIGHTY("180"),TWOSEVENTY("270");
	
	String rotation;
	
	RotateEnum(String rotation){
		this.rotation = rotation;
	}
	
	public String getRotation(){
		return rotation;
	}
	
}
