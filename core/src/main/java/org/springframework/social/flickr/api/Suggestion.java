package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Suggestion {
	private String id;
	private String photo_id;
	private String date_suggested;
	private Person2 suggested_by;
	private String note; //_content
	private Location location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhoto_id() {
		return photo_id;
	}

	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}

	public String getDate_suggested() {
		return date_suggested;
	}

	public void setDate_suggested(String date_suggested) {
		this.date_suggested = date_suggested;
	}

	public Person2 getSuggested_by() {
		return suggested_by;
	}

	public void setSuggested_by(Person2 suggested_by) {
		this.suggested_by = suggested_by;
	}

	public String getNote() {
		return note;
	}

	public void setNote(LinkedHashMap<String, String> note) {
		this.note = note.get(FlickrConstant.JSONCONTENT);;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
