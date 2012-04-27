package org.springframework.social.flickr.api;

public enum ContentTypeEnum {
	PHOTO("1"),SCREENSHORT("2"),OTHER("3");
	private String contentType; 
	ContentTypeEnum(String contentType){
		this.contentType = contentType ;
	}
	public String getType(){
		return contentType;
	}
}
