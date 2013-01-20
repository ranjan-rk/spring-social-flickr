package org.springframework.social.flickr.api;

import java.util.LinkedHashMap;

/**
 * @author hemants
 *
 */
public class PhotosInfo {
	String firstdatetaken;
	String firstdate;
	String count;
	public String getFirstdatetaken() {
		return firstdatetaken;
	}
	public void setFirstdatetaken(LinkedHashMap<String,String> firstdatetaken) {
		this.firstdatetaken = firstdatetaken.get(FlickrConstant.JSONCONTENT);
	}
	public String getFirstdate() {
		return firstdate;
	}
	public void setFirstdate(LinkedHashMap<String,String> firstdate) {
		this.firstdate = firstdate.get(FlickrConstant.JSONCONTENT);
	}
	public String getCount() {
		return count;
	}
	public void setCount(LinkedHashMap<String,String> count) {
		this.count = count.get(FlickrConstant.JSONCONTENT);
	}
}
