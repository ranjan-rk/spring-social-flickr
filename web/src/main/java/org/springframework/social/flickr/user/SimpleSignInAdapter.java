package org.springframework.social.flickr.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

public final class SimpleSignInAdapter implements SignInAdapter {
	private final UserCookieGenerator userCookieGenerator = new UserCookieGenerator();
	
	public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
		SecurityContext.setCurrentUser( request.getNativeRequest(HttpServletRequest.class),new User(userId));
		userCookieGenerator.addCookie(userId, request.getNativeResponse(HttpServletResponse.class));
		return null;
	}

}