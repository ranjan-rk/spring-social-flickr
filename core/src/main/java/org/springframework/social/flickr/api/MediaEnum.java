package org.springframework.social.flickr.api;

public enum MediaEnum {
	ALL("all"), PHOTOS("photos"), VIDEOS("videos");
	private String MediaEnum;

	MediaEnum(String MediaEnum) {
		this.MediaEnum = MediaEnum;
	}

	public String getMediaEnum() {
		return MediaEnum;
	}
}
