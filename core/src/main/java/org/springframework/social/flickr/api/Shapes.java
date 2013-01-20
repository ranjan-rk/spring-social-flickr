package org.springframework.social.flickr.api;

import java.util.ArrayList;

/**
 * @author hemant
 *
 */
public class Shapes {
	private String total;
	private String woe_id;
	private String place_id;
	private String place_type;
	private String place_type_id;
	private ArrayList<ShapeData> shape ;
	public ArrayList<ShapeData> getShape() {
		return shape;
	}
	public void setShape(ArrayList<ShapeData> shape) {
		this.shape = shape;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getWoe_id() {
		return woe_id;
	}
	public void setWoe_id(String woe_id) {
		this.woe_id = woe_id;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getPlace_type() {
		return place_type;
	}
	public void setPlace_type(String place_type) {
		this.place_type = place_type;
	}
	public String getPlace_type_id() {
		return place_type_id;
	}
	public void setPlace_type_id(String place_type_id) {
		this.place_type_id = place_type_id;
	}
	
}
