
package org.springframework.social.flickr.api;


/**
 * @author hemant
 *
 */
public class Tag{
   	private String _content;
   	private String author;
   	private String authorname;
   	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	private String id;
   	private String machine_tag;
   	private String raw;
   	private Number count;
   	private Number score;

 	public Number getScore() {
		return score;
	}
	public void setScore(Number score) {
		this.score = score;
	}
	public Number getCount() {
		return count;
	}
	public void setCount(Number count) {
		this.count = count;
	}
	public String get_content(){
		return this._content;
	}
	public void set_content(String _content){
		this._content = _content;
	}
 	public String getAuthor(){
		return this.author;
	}
	public void setAuthor(String author){
		this.author = author;
	}
 	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
 	public String getMachine_tag(){
		return this.machine_tag;
	}
	public void setMachine_tag(String machine_tag){
		this.machine_tag = machine_tag;
	}
 	public String getRaw(){
		return this.raw;
	}
	public void setRaw(String raw){
		this.raw = raw;
	}
}
