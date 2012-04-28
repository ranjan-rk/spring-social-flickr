package org.springframework.social.flickr.api;

public class PhotoCount {

	String _content;
	Photo prevphoto;
	Photo nextphoto;
	
	public String get_content() {
		return _content;
	}
	public void set_content(String _content) {
		this._content = _content;
	}
	public Photo getPrevphoto() {
		return prevphoto;
	}
	public void setPrevphoto(Photo prevphoto) {
		this.prevphoto = prevphoto;
	}
	public Photo getNextphoto() {
		return nextphoto;
	}
	public void setNextphoto(Photo nextphoto) {
		this.nextphoto = nextphoto;
	}
}
