package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Contacts {
	ArrayList<Contact> contact;
	Number page; 
	Number pages;
	String perpage;
	String per_page;
	Number total;

	public ArrayList<Contact> getContact() {
		return contact;
	}

	public void setContact(ArrayList<Contact> contact) {
		this.contact = contact;
	}

	public Number getPage() {
		return page;
	}

	public void setPage(Number page) {
		this.page = page;
	}

	public Number getPages() {
		return pages;
	}

	public void setPages(Number pages) {
		this.pages = pages;
	}

	public String getPerpage() {
		return perpage;
	}

	public void setPerpage(String perpage) {
		this.perpage = perpage;
	}

	public Number getTotal() {
		return total;
	}

	public void setTotal(Number total) {
		this.total = total;
	}

	public String getPer_page() {
		return per_page;
	}

	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}
}
