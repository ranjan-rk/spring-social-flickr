package org.springframework.social.flickr.api.impl;

import org.springframework.social.flickr.api.Comment;
import org.springframework.social.flickr.api.Comments;
import org.springframework.social.flickr.api.PhotoCommentOperations;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PhotoCommentTemplate extends AbstractFlickrOperations implements PhotoCommentOperations{

	private final RestTemplate restTemplate;
	
	public PhotoCommentTemplate(RestTemplate restTemplate,boolean isAuthorizedForUser,String consumerKey) {
		super(isAuthorizedForUser, consumerKey);
		this.restTemplate = restTemplate;
	}
	
	@Override
	public Comment addComment(String photoId, String commentText) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("comment_text", commentText);
		return restTemplate.postForObject(buildUri("flickr.photos.comments.addComment"), parameters, Comment.class);
	}

	@Override
	public boolean deleteComment(String commentId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("comment_id", commentId);
		restTemplate.postForObject(buildUri("flickr.photos.comments.deleteComment"), parameters, Object.class);
		return true;
	}

	@Override
	public boolean editComment(String commentId, String commentText) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("comment_id", commentId);
		parameters.set("comment_text", commentText);
		restTemplate.postForObject(buildUri("flickr.photos.comments.editComment"), parameters, Object.class);
		return true;
	}

	@Override
	public Comments getList(String photoId, String minCommentDate, String maxCommentDate) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photoId", photoId);
		if(minCommentDate!=null){
			parameters.set("min_comment_date", minCommentDate);
		}
		if(maxCommentDate!=null){
			parameters.set("max_comment_date", maxCommentDate);
		}
		return restTemplate.postForObject(buildUri("flickr.photos.comments.getList"), parameters, Comments.class);
	}


}
