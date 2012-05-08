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
	 * @param apiKey the api key
	 * @param service the service
	 * @return the list
	 */
	Blogs getList(String apiKey, String service);// service,

	/**
	 * Gets the services.
	 *
	 * @param apiKey the api key
	 * @return the services
	 */
	Services getServices(String apiKey);

	/**
	 * Post photo.
	 *
	 * @param apiKey the api key
	 * @param blogId the blog id
	 * @param photoId the photo id
	 * @param title the title
	 * @param description the description
	 * @param blogPassword the blog password
	 * @param service the service
	 */
	void postPhoto(String apiKey, String blogId, String photoId, String title,
			String description, String blogPassword, String service);// blogId,blogPassword,service,
}