package org.springframework.social.flickr.api;

public class Location extends Locality {

	private String accuracy;
	private String context;
   	private Locality locality;
   	private Locality country;
   	private Locality region;
   	private Locality county;
   	private Locality neighbourhood;
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
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
	public Locality getNeighbourhood() {
		return neighbourhood;
	}
	public void setNeighbourhood(Locality neighbourhood) {
		this.neighbourhood = neighbourhood;
	}
}
