package org.springframework.social.flickr.api;

public class Comment {
	private String id ;
	private String author;
	private String authorname;
	private String iconserver;
	private String iconfarm;
	private String datecreate;
	private String permalink;
	private String _content;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getIconserver() {
		return iconserver;
	}

	public void setIconserver(String iconserver) {
		this.iconserver = iconserver;
	}

	public String getIconfarm() {
		return iconfarm;
	}

	public void setIconfarm(String iconfarm) {
		this.iconfarm = iconfarm;
	}

	public String getDatecreate() {
		return datecreate;
	}

	public void setDatecreate(String datecreate) {
		this.datecreate = datecreate;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public String get_content() {
		return _content;
	}

	public void set_content(String _content) {
		this._content = _content;
	}
}
