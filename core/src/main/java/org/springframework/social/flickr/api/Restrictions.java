
package org.springframework.social.flickr.api;

import java.util.List;

public class Restrictions{
   	private Number art_ok;
   	private Number has_geo;
   	private Number images_ok;
   	private Number moderate_ok;
   	private Number photos_ok;
   	private Number restricted_ok;
   	private Number safe_ok;
   	private Number screens_ok;
   	private Number videos_ok;

 	public Number getArt_ok(){
		return this.art_ok;
	}
	public void setArt_ok(Number art_ok){
		this.art_ok = art_ok;
	}
 	public Number getHas_geo(){
		return this.has_geo;
	}
	public void setHas_geo(Number has_geo){
		this.has_geo = has_geo;
	}
 	public Number getImages_ok(){
		return this.images_ok;
	}
	public void setImages_ok(Number images_ok){
		this.images_ok = images_ok;
	}
 	public Number getModerate_ok(){
		return this.moderate_ok;
	}
	public void setModerate_ok(Number moderate_ok){
		this.moderate_ok = moderate_ok;
	}
 	public Number getPhotos_ok(){
		return this.photos_ok;
	}
	public void setPhotos_ok(Number photos_ok){
		this.photos_ok = photos_ok;
	}
 	public Number getRestricted_ok(){
		return this.restricted_ok;
	}
	public void setRestricted_ok(Number restricted_ok){
		this.restricted_ok = restricted_ok;
	}
 	public Number getSafe_ok(){
		return this.safe_ok;
	}
	public void setSafe_ok(Number safe_ok){
		this.safe_ok = safe_ok;
	}
 	public Number getScreens_ok(){
		return this.screens_ok;
	}
	public void setScreens_ok(Number screens_ok){
		this.screens_ok = screens_ok;
	}
 	public Number getVideos_ok(){
		return this.videos_ok;
	}
	public void setVideos_ok(Number videos_ok){
		this.videos_ok = videos_ok;
	}
}
