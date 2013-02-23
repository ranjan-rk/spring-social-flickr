package org.springframework.social.flickr.api;

public class Predicate {
	String _content;
	String usage;
	String namespaces;
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
	public String getNamespaces() {
		return namespaces;
	}
	public void setNamespaces(String namespaces) {
		this.namespaces = namespaces;
	}
}
