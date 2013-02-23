package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface BlogsOperations.
 *
 * @author HemantS
 */
public interface BlogsOperations {
	
	/**
	 * Gets the list.
	 *
	 * @param service the service
	 * @return the list
	 */
	Blogs getList(String service);// service,

	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	Services getServices();

	/**
	 * Post photo.
	 *
	 * @param blogId the blog id
	 * @param photoId the photo id
	 * @param title the title
	 * @param description the description
	 * @param blogPassword the blog password
	 * @param service the service
	 */
	//TODO : PENDING
	void postPhoto(String blogId, String photoId, String title,
			String description, String blogPassword, String service);// blogId,blogPassword,service,
}