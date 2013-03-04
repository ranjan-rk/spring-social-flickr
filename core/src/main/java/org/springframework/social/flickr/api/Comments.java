package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Comments {
	String photoId;
	String photoset_id;
	ArrayList<Comment> comment;
	
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public ArrayList<Comment> getComment() {
		return comment;
	}
	public void setComment(ArrayList<Comment> comment) {
		this.comment = comment;
	}
	public String getPhotoset_id() {
		return photoset_id;
	}
	public void setPhotoset_id(String photoset_id) {
		this.photoset_id = photoset_id;
	}
}
