package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Values {
	String namespace;
	String predicate;
	String page;
	String pages;
	String perpage;
	String total;
	ArrayList<Value> value;
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getPredicate() {
		return predicate;
	}
	public void setPredicate(String predicate) {
		this.predicate = predicate;
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
	public ArrayList<Value> getValue() {
		return value;
	}
	public void setValue(ArrayList<Value> value) {
		this.value = value;
	}
}
