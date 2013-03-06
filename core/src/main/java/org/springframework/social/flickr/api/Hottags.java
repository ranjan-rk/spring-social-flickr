package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Hottags {
	private String period;
	private String count;
	private ArrayList<Tag> tag;
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public ArrayList<Tag> getTag() {
		return tag;
	}
	public void setTag(ArrayList<Tag> tag) {
		this.tag = tag;
	}
}
