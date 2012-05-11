package org.springframework.social.flickr.api;

/**
 * @author HemantS
 *
 */
public enum PrivacyFilterEnum {
	PHOTOS("1"), // public photos
	FRIENDS("2"), // private photos visible to friends
	FAMILY("3"), // private photos visible to family
	FRIENDNFAMILY("4"), // private photos visible to friends & family
	PRIVATE("5"); // completely private photos
	private String privacy;

	PrivacyFilterEnum(String privacy) {
		this.privacy = privacy;
	}

	public String getPrivacy() {
		return privacy;
	}

}
