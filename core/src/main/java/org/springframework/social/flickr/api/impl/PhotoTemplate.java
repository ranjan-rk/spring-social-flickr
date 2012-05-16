package org.springframework.social.flickr.api.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.social.flickr.api.ContentTypeEnum;
import org.springframework.social.flickr.api.HiddenEnum;
import org.springframework.social.flickr.api.Perms;
import org.springframework.social.flickr.api.Photo;
import org.springframework.social.flickr.api.PhotoDetail;
import org.springframework.social.flickr.api.PhotoId;
import org.springframework.social.flickr.api.PhotoOperations;
import org.springframework.social.flickr.api.Photos;
import org.springframework.social.flickr.api.RotateEnum;
import org.springframework.social.flickr.api.SafetyLevelEnum;
import org.springframework.social.flickr.api.Sizes;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author HemantS
 *
 */
public class PhotoTemplate extends AbstractFlickrOperations implements PhotoOperations {
	private final RestTemplate restTemplate;
	
	public PhotoTemplate(RestTemplate restTemplate,boolean isAuthorizedForUser) {
		super(isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}
	
	@Override
	public boolean addTags(String photoId, String[] tagList) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("tags", toCommaList(tagList));
		restTemplate.postForObject(buildUri("flickr.photos.addTags"), parameters, Object.class);
		return true;
	}
	
	@Override
	public boolean addTags(String photoId, String tags) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("tags", tags);
		restTemplate.postForObject(buildUri("flickr.photos.addTags"), parameters, Object.class);
		return true;
	}
	

	@Override
	public boolean removeTag(String tagId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("tag_id", tagId);
		restTemplate.postForObject(buildUri("flickr.photos.removeTag"), parameters, Object.class);
		return true;
	}
	
	@Override
	public boolean delete(String photoId) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		restTemplate.postForObject(buildUri("flickr.photos.delete"), parameters, Object.class);
		return true;
	}
	
	@Override
	public Photos getRecent(String perPage, String page, String[] extras) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("per_page", perPage);
		parameters.set("page", page);
		parameters.set("extras", toCommaList(extras));
		return restTemplate.getForObject(buildUri("flickr.photos.getRecent",parameters), Photos.class);		 
	}
	
	@Override
	public Photo getFavorites(String perPage, String page, String photoId) {
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("per_page", perPage);
		parameters.set("page", page);
		parameters.set("photo_id", photoId);
		return restTemplate.getForObject(buildUri("flickr.photos.getFavorites",parameters), Photo.class);	
	}
	
	@Override
	public PhotoDetail getInfo(String photoId) {
		return restTemplate.getForObject(buildUri("flickr.photos.getInfo","photo_id",photoId), PhotoDetail.class);	
	}


	@Override
	public Sizes getSizes(String photoId) {
		return restTemplate.getForObject(buildUri("flickr.photos.getSizes","photo_id",photoId), Sizes.class);	
	}
	
	@Override
	public Perms getPerms(String photoId) {
		requireAuthorization();
		return restTemplate.getForObject(buildUri("flickr.photos.getPerms","photo_id",photoId), Perms.class);	
	}
	
	@Override
	public PhotoId setPerms(Perms perms) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", perms.getId());
		if(perms.isIspublic()){
			parameters.set("is_public", "1");
		}else{
			parameters.set("is_public", "0");
		}
		if(perms.isIsfamily()){
			parameters.set("is_family", "1");
		}else{
			parameters.set("is_family", "0");
		}
		if(perms.isIsfriend()){
			parameters.set("is_friend", "1");
		}else{
			parameters.set("is_friend", "0");
		}
		parameters.set("perm_comment",perms.getPermcomment().getPermision());
		parameters.set("perm_addmeta",perms.getPermcomment().getPermision());
		return restTemplate.postForObject(buildUri("flickr.photos.setPerms"), parameters, PhotoId.class);
	}

	@Override
	public boolean setContentType(String photoId, ContentTypeEnum contentTypeEnum) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("content_type", contentTypeEnum.getType());
		restTemplate.postForObject(buildUri("flickr.photos.setContentType"), parameters, Object.class);
		return true;
	}

	@Override
	public boolean setSafetyLevel(String photoId, SafetyLevelEnum safetyLevel,Boolean hidden) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("safety_level", safetyLevel.getSafetyLevel());
		if(hidden!=null){
			if(hidden == true){
				parameters.set("hidden", "1");
			}else{
				parameters.set("hidden", "0");
			}
		}
		restTemplate.postForObject(buildUri("flickr.photos.setSafetyLevel"), parameters, Object.class);
		return true;
	}

	@Override
	public boolean setSafetyLevel(String photoId, SafetyLevelEnum safetyLevel) {
		return setSafetyLevel(photoId,safetyLevel,null );
	}

	@Override
	public boolean setMeta(String photoId, String title, String description) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("title", title);
		parameters.set("description", description);
		restTemplate.postForObject(buildUri("flickr.photos.setMeta"), parameters, Object.class);
		return true;
	}
	
	@Override
	public PhotoId rotate(String photoId, RotateEnum rotation) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.set("photo_id", photoId);
		parameters.set("degrees",rotation.getRotation());
		return restTemplate.postForObject(buildUri("flickr.photos.transform.rotate"), parameters, PhotoId.class);
	}

	
	private String toCommaList(String[] a){
		if (a == null)
            return "null";
	int iMax = a.length - 1;
	if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        
        for (int i = 0; ; i++) {
            b.append(a[i]);
	    if (i == iMax)
		return b.toString();
            b.append(",");
        }
	}

	@Override
	public Object upload(File photo, String title, String description,
			String[] tags, Perms perms, ContentTypeEnum contentType,
			HiddenEnum hiddenType) {
		requireAuthorization();
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		try {
			InputStream inputStream = new FileInputStream(photo);
			System.out.println(inputStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		parameters.set("photo", photo.toString());
		parameters.set("title",title);
		return restTemplate.postForObject(buildUri("flickr.photos.transform.rotate"), parameters, Object.class);
	}

}
