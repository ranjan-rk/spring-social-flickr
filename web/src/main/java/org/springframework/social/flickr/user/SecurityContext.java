package org.springframework.social.flickr.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SecurityContext {

    private static Map<String, User> mapOfSessionsToUsers = new ConcurrentHashMap<String, User>();

    public static User getCurrentUser(HttpServletRequest r) {
        String sessionId = r.getSession(true).getId();
        return mapOfSessionsToUsers.get(sessionId);
    }

    public static void setCurrentUser(HttpServletRequest r, User user) {
        mapOfSessionsToUsers.put(session(r).getId(), user);
    }

    private static HttpSession session(HttpServletRequest request) {
        return request.getSession(true);
    }

    public static boolean userSignedIn(HttpServletRequest request) {
        return getCurrentUser(request) != null;
    }

    public static void remove(HttpServletRequest request) {
        mapOfSessionsToUsers.remove(session(request).getId());
    }

}
