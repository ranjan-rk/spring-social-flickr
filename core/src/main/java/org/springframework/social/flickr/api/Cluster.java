package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Cluster {
	private Number total;
	private ArrayList<Tag> tag;
	public Number getTotal() {
		return total;
	}
	public void setTotal(Number total) {
		this.total = total;
	}
	public ArrayList<Tag> getTag() {
		return tag;
	}
	public void setTag(ArrayList<Tag> tag) {
		this.tag = tag;
	}
}
