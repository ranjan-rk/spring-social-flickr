package org.springframework.social.flickr.api;

/**
 * @author hemant
 *
 */
public class PlaceType {
	private String id ;
	private String _content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String get_content() {
		return _content;
	}
	public void set_content(String _content) {
		this._content = _content;
	}
}
