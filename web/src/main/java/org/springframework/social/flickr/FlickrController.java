package org.springframework.social.flickr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.api.FlickrProfile;
import org.springframework.social.flickr.api.impl.FlickrTemplate;
import org.springframework.social.flickr.connect.FlickrConnectionFactory;
import org.springframework.social.oauth1.OAuth1Operations;
import org.springframework.social.oauth1.OAuthToken;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class FlickrController extends AbstractController {
	private String message;
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		String consumerKey = "consumerKey";
		String  consumerSecret= "consumerSecret";
		FlickrConnectionFactory flickrConnectionFactory = new FlickrConnectionFactory(consumerKey, consumerSecret);
		OAuth1Operations oauthOperations = flickrConnectionFactory.getOAuthOperations();
		String callbackUrl = "http://localhost:8080/spring-social-flickr-web/hello.jsp";
		OAuthToken fetchRequestToken = oauthOperations.fetchRequestToken(callbackUrl, null);
		Flickr flickr = new FlickrTemplate(consumerKey, consumerSecret, fetchRequestToken.getValue(), fetchRequestToken.getSecret());
		FlickrProfile userProfile =null;
		try{
			userProfile = flickr.getUserProfile();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		System.out.println(userProfile.getStat());
		
		return new ModelAndView("welcomePage", "welcomeMessage", message);
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
