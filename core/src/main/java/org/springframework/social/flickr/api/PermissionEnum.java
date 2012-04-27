package org.springframework.social.flickr.api;

public enum PermissionEnum {
	NOBODY("0"),FRIENDFAMILY("1"),CONTACTS("2"),EVERTYBODY("3");
	
	private String permision; 
	
	PermissionEnum(String permision){
		this.permision = permision ;
	}
	public String getPermision(){
		return permision;
	}
}
