package org.springframework.social.flickr.connect;

import org.springframework.social.flickr.api.impl.FlickrTemplate;

public class FlickStandaloneTest {
	public static void main(String arg[]) {
		FlickrTemplate ft = new FlickrTemplate("97adef5462494f36731a65b4de683ac5");
		System.out.println(ft.photoOperations().getInfo("8376145141").getOwner().getRealname()) ;
		System.out.println(ft.commonsOperations().getInstitutions().getInstitution().get(0).getName()) ;
		System.out.println(ft.prefsOperations().getContentType().getDescription()) ;
	}

}
