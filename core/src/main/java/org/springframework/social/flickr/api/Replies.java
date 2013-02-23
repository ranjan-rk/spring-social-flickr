
package org.springframework.social.flickr.api;

import java.util.ArrayList;
import java.util.List;

public class Replies{
   	private ArrayList<Reply> reply;
   	private Topic topic;

 	public List getReply(){
		return this.reply;
	}
	public void setReply( ArrayList<Reply>  reply){
		this.reply = reply;
	}
 	public Topic getTopic(){
		return this.topic;
	}
	public void setTopic(Topic topic){
		this.topic = topic;
	}
}
