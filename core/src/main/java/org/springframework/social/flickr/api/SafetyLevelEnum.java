package org.springframework.social.flickr.api;

//1 for Safe, 2 for Moderate, and 3 for Restricted.
public enum SafetyLevelEnum {
	SAFE("1"),MODERATE("2"),RESTRICTED("3")
;
	private String safetyLevel;
	
	SafetyLevelEnum(String safetyLevel){
		this.safetyLevel = safetyLevel;
	}
	public String getSafetyLevel(){
		return safetyLevel;
	}
}
