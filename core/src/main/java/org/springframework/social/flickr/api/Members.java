package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Members {

   	private ArrayList<Member> member;
   	private Number page;
   	private Number pages;
   	private Number perpage;
   	private String total;

 	public ArrayList<Member> getMember(){
		return this.member;
	}
	public void setMember(ArrayList<Member> member){
		this.member = member;
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
 	public String getTotal(){
		return this.total;
	}
	public void setTotal(String total){
		this.total = total;
	}

}
