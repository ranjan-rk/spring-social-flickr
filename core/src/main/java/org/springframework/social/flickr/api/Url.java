
package org.springframework.social.flickr.api;


/**
 * @author hemant
 *
 */
public class Url{
   	private String _content;
   	private String type;

 	public String get_content(){
		return this._content;
	}
	public void set_content(String _content){
		this._content = _content;
	}
 	public String getType(){
		return this.type;
	}
	public void setType(String type){
		this.type = type;
	}
}
