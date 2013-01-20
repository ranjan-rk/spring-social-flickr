
package org.springframework.social.flickr.api;

import java.util.List;

/**
 * @author hemant
 *
 */
public class Tags{
   	private List<Tag> tag;

 	public List<Tag> getTag(){
		return this.tag;
	}
	public void setTag(List<Tag> tag){
		this.tag = tag;
	}
}
