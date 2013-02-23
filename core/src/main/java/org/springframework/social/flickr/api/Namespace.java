package org.springframework.social.flickr.api;

public class Namespace {
	String _content;
	String usage;
	String predicates;
	public String get_content() {
		return _content;
	}
	public void set_content(String _content) {
		this._content = _content;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getPredicates() {
		return predicates;
	}
	public void setPredicates(String predicates) {
		this.predicates = predicates;
	}
}
