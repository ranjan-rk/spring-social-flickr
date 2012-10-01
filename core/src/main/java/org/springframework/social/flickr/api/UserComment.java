
package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class UserComment{
   	private ArrayList<Item> item;
    private Number page;
   	private Number pages;
   	private Number perpage;
   	private Number total;

 	public ArrayList<Item> getItem(){
		return this.item;
	}
	public void setItem(ArrayList<Item> items){
		this.item = items;
	}
	public Number getPage(){
		return this.page;
	}
	public void setPage(Number page){
		this.page = page;
	}
 	public Number getPages(){
		return this.pages;
	}
	public void setPages(Number pages){
		this.pages = pages;
	}
 	public Number getPerpage(){
		return this.perpage;
	}
	public void setPerpage(Number perpage){
		this.perpage = perpage;
	}
 	public Number getTotal(){
		return this.total;
	}
	public void setTotal(Number total){
		this.total = total;
	}
}
