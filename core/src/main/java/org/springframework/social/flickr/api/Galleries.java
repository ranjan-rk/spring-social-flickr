package org.springframework.social.flickr.api;

import java.util.List;

public class Galleries {
	String page;
	String pages;
	String perpage;
	String total;
	String userId;
	List Gallery;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List getGallery() {
		return Gallery;
	}
	public void setGallery(List gallery) {
		Gallery = gallery;
	}

}
