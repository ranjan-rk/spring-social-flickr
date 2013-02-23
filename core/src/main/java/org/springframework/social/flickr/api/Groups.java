package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Groups {
	String page;
	String pages;
	String perpage;
	String total;
	ArrayList<Group> group;

	public ArrayList<Group> getGroup() {
		return group;
	}

	public void setGroup(ArrayList<Group> group) {
		this.group = group;
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
}
