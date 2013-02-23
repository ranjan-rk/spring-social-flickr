
package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

public class Details{
   	private String lcd_screen_size;
   	private String megapixels;
   	private String zoom;
	private String memory_type;
	
	public String getZoom() {
		return zoom;
	}
	public void setZoom(LinkedHashMap<String,String>  zoom) {
		this.zoom = zoom.get(FlickrConstant.JSONCONTENT);
	}
 	public String getLcd_screen_size(){
		return this.lcd_screen_size;
	}
	public void setLcd_screen_size( LinkedHashMap<String,String>  lcd_screen_size){
		this.lcd_screen_size = lcd_screen_size.get(FlickrConstant.JSONCONTENT);
	}
 	public String getMegapixels(){
		return this.megapixels;
	}
	public void setMegapixels(LinkedHashMap<String,String>  megapixels){
		this.megapixels = megapixels.get(FlickrConstant.JSONCONTENT);
	}
 	public String getMemory_type(){
		return this.memory_type;
	}
	public void setMemory_type(LinkedHashMap<String,String>  memory_type){
		this.memory_type = memory_type.get(FlickrConstant.JSONCONTENT);
	}
}
