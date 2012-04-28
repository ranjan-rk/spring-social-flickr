package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Photosets {
	boolean cancreate;
	String page;
	String pages;
	String perpage;
	String total;
	ArrayList<Photoset> photoset;
	
	public boolean isCancreate() {
		return cancreate;
	}
	public void setCancreate(boolean cancreate) {
		this.cancreate = cancreate;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getPerpage() {
		return perpage;
	}
	public void setPerpage(String perpage) {
		this.perpage = perpage;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public ArrayList<Photoset> getPhotoset() {
		return photoset;
	}
	public void setPhotoset(ArrayList<Photoset> photoset) {
		this.photoset = photoset;
	}
}
