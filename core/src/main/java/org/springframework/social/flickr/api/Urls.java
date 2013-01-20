
package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author hemant
 *
 */
public class Urls{
   	private List<Url> url;
   	private String shapefile;

 	public String getShapefile() {
		return shapefile;
	}
	public void setShapefile(LinkedHashMap<String,String> shapefile) {
		this.shapefile = shapefile.get(FlickrConstant.JSONCONTENT);;
	}
	public List<Url> getUrl(){
		return this.url;
	}
	public void setUrl(List<Url> url){
		this.url = url;
	}
}
