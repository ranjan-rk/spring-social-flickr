package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Note;
import org.springframework.social.flickr.api.PhotoNoteOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PhotoNoteTemplate extends AbstractFlickrOperations implements PhotoNoteOperations{
	
private final RestTemplate restTemplate;
	
	public PhotoNoteTemplate(RestTemplate restTemplate,boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser,consumerKey);
		this.restTemplate = restTemplate;
	}

	@Override
	public String add(String photoId, Note note) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("note_x", String.valueOf(note.getX()));
		parameters.set("note_y", String.valueOf(note.getY()));
		parameters.set("note_w", String.valueOf(note.getW()));
		parameters.set("note_h", String.valueOf(note.getH()));
		parameters.set("note_text", note.get_content());
		return restTemplate.postForObject(buildUri("flickr.photos.notes.add"),parameters, Note.class).getId();
		
	}

	@Override
	public boolean delete(String noteId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("note_id", noteId);
		restTemplate.postForObject(buildUri("flickr.photos.notes.delete"),parameters, Object.class);
		return true;
	}

	@Override
	public boolean edit(String noteId, Note note) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("note_id", noteId);
		parameters.set("note_x", String.valueOf(note.getX()));
		parameters.set("note_y", String.valueOf(note.getY()));
		parameters.set("note_w", String.valueOf(note.getW()));
		parameters.set("note_h", String.valueOf(note.getH()));
		parameters.set("note_text", note.get_content());
		restTemplate.postForObject(buildUri("flickr.photos.notes.edit"),parameters, Object.class);
		return true;
	}

}
