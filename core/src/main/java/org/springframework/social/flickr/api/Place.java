
package org.springframework.social.flickr.api;


/**
 * @author hemants
 *
 */
public class Place{
   	private String _content;
   	private String latitude;
   	private String longitude;
   	private String place_id;
   	private String place_type;
   	private String place_type_id;
   	private String place_url;
   	private String timezone;
   	private String woe_name;
   	private String woeid;
   	private String photo_count;
   	private String names;
   	private Locality locality;
   	private Locality country;
   	private Locality region;
   	private Locality county;
   	private boolean has_shapedata;
   	private ShapeData shapedata;
	public ShapeData getShapedata() {
		return shapedata;
	}
	public void setShapedata(ShapeData shapedata) {
		this.shapedata = shapedata;
	}
	public Locality getLocality() {
		return locality;
	}
	public void setLocality(Locality locality) {
		this.locality = locality;
	}
	public Locality getCountry() {
		return country;
	}
	public void setCountry(Locality country) {
		this.country = country;
	}
	public Locality getRegion() {
		return region;
	}
	public void setRegion(Locality region) {
		this.region = region;
	}
	public Locality getCounty() {
		return county;
	}
	public void setCounty(Locality county) {
		this.county = county;
	}
	public boolean isHas_shapedata() {
		return has_shapedata;
	}
	public void setHas_shapedata(boolean has_shapedata) {
		this.has_shapedata = has_shapedata;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getPhoto_count() {
		return photo_count;
	}
	public void setPhoto_count(String photo_count) {
		this.photo_count = photo_count;
	}
	public String get_content(){
		return this._content;
	}
	public void set_content(String _content){
		this._content = _content;
	}
 	public String getLatitude(){
		return this.latitude;
	}
	public void setLatitude(String latitude){
		this.latitude = latitude;
	}
 	public String getLongitude(){
		return this.longitude;
	}
	public void setLongitude(String longitude){
		this.longitude = longitude;
	}
 	public String getPlace_id(){
		return this.place_id;
	}
	public void setPlace_id(String place_id){
		this.place_id = place_id;
	}
 	public String getPlace_type(){
		return this.place_type;
	}
	public void setPlace_type(String place_type){
		this.place_type = place_type;
	}
 	public String getPlace_type_id(){
		return this.place_type_id;
	}
	public void setPlace_type_id(String place_type_id){
		this.place_type_id = place_type_id;
	}
 	public String getPlace_url(){
		return this.place_url;
	}
	public void setPlace_url(String place_url){
		this.place_url = place_url;
	}
 	public String getTimezone(){
		return this.timezone;
	}
	public void setTimezone(String timezone){
		this.timezone = timezone;
	}
 	public String getWoe_name(){
		return this.woe_name;
	}
	public void setWoe_name(String woe_name){
		this.woe_name = woe_name;
	}
 	public String getWoeid(){
		return this.woeid;
	}
	public void setWoeid(String woeid){
		this.woeid = woeid;
	}
}
