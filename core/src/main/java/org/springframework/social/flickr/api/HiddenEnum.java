package org.springframework.social.flickr.api;

public enum HiddenEnum {
    //Set to 1 to keep the photo in global search results, 2 to hide from public searches.
    
    SHOW("1"),HIDE("2");
    private String hiddenType; 
    HiddenEnum(String hiddenType){
		this.hiddenType = hiddenType ;
	}
	public String getHiddenType(){
		return hiddenType;
	}
	
	
}
