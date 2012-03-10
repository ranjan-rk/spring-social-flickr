package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Photos {
	String page;
	String pages;
	String perpage;
	String total;
	ArrayList<Photo> photo;

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

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public ArrayList<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(ArrayList<Photo> photo) {
		this.photo = photo;
	}

	public String getPerpage() {
		return perpage;
	}

	public void setPerpage(String perpage) {
		this.perpage = perpage;
	}
}
