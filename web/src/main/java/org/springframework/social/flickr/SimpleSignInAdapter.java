package org.springframework.social.flickr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public final class SimpleSignInAdapter implements SignInAdapter {
	
	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		//SecurityContext.setCurrentUser(new User(userId));
		System.out.println("inside simple sign adapter");
		return null;
	}

}