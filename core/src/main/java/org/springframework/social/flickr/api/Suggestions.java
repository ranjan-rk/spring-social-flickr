package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Suggestions {
	private String total;
	private String per_page;
	private String page;
	private ArrayList<Suggestion> suggestion;

	public ArrayList<Suggestion> getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(ArrayList<Suggestion> suggestion) {
		this.suggestion = suggestion;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getPer_page() {
		return per_page;
	}

	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}
