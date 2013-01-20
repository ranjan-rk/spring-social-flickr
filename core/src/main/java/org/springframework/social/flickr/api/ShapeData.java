package org.springframework.social.flickr.api;

/**
 * @author hemant
 *
 */
public class ShapeData {
	private String created ;
	private String alpha ;
	private String count_points ;
	private String count_edges ;
	private String has_donuthole ;
	private String is_donuthole ;
	private Urls urls;
   	private Polylines polylines;
   	
   	public Polylines getPolylines() {
		return polylines;
	}
	public void setPolylines(Polylines polylines) {
		this.polylines = polylines;
	}
 	public Urls getUrls() {
		return urls;
	}
	public void setUrls(Urls urls) {
		this.urls = urls;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getAlpha() {
		return alpha;
	}
	public void setAlpha(String alpha) {
		this.alpha = alpha;
	}
	public String getCount_points() {
		return count_points;
	}
	public void setCount_points(String count_points) {
		this.count_points = count_points;
	}
	public String getCount_edges() {
		return count_edges;
	}
	public void setCount_edges(String count_edges) {
		this.count_edges = count_edges;
	}
	public String getHas_donuthole() {
		return has_donuthole;
	}
	public void setHas_donuthole(String has_donuthole) {
		this.has_donuthole = has_donuthole;
	}
	public String getIs_donuthole() {
		return is_donuthole;
	}
	public void setIs_donuthole(String is_donuthole) {
		this.is_donuthole = is_donuthole;
	}
}
