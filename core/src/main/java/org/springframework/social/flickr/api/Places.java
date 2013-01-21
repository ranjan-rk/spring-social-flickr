
package org.springframework.social.flickr.api;

import java.util.ArrayList;

/**
 * @author hemant
 *
 */
public class Places{
   	private ArrayList<Place> place;
   	private String query;
   	private Number total;
   	private String latitude;
   	private String longitude;
   	private String accuracy;
   	private String date_start ;
   	private String place_type;
   	private Number pages;
   	public String getPlace_type() {
		return place_type;
	}
	public void setPlace_type(String place_type) {
		this.place_type = place_type;
	}
	public Number getPages() {
		return pages;
	}
	public void setPages(Number pages) {
		this.pages = pages;
	}
	public Number getPage() {
		return page;
	}
	public void setPage(Number page) {
		this.page = page;
	}
	public String getBbox() {
		return bbox;
	}
	public void setBbox(String bbox) {
		this.bbox = bbox;
	}
	private Number page;
   	private String bbox;
   	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}
	private String date_stop ; 

 	public String getDate_stop() {
		return date_stop;
	}
	public void setDate_stop(String date_stop) {
		this.date_stop = date_stop;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public ArrayList<Place> getPlace(){
		return this.place;
	}
	public void setPlace(ArrayList<Place> place){
		this.place = place;
	}
 	public String getQuery(){
		return this.query;
	}
	public void setQuery(String query){
		this.query = query;
	}
 	public Number getTotal(){
		return this.total;
	}
	public void setTotal(Number total){
		this.total = total;
	}
}
