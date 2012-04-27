package org.springframework.social.flickr.api;

public class PhotoId {
	
	private String _content;
	private String secret;
	private String originalsecret;

	public String get_content() {
		return _content;
	}

	public void set_content(String _content) {
		this._content = _content;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getOriginalsecret() {
		return originalsecret;
	}

	public void setOriginalsecret(String originalsecret) {
		this.originalsecret = originalsecret;
	}

}
