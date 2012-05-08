package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface PhotosSuggestionsOperations.
 */
/**
 * @author HemantS
 *
 */
public interface PhotosSuggestionsOperations {
	
	/**
	 * Approve suggestion.
	 *
	 * @param apiKey the api key
	 * @param suggestionId the suggestion id
	 */
	void approveSuggestion(String apiKey, String suggestionId);

	/**
	 * Gets the list.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param statusId the status id
	 * @return the list
	 */
	void getList(String apiKey, String photoId, String statusId);// photoId,statusId,

	/**
	 * Reject suggestion.
	 *
	 * @param apiKey the api key
	 * @param suggestionId the suggestion id
	 */
	void rejectSuggestion(String apiKey, String suggestionId);

	/**
	 * Removes the suggestion.
	 *
	 * @param apiKey the api key
	 * @param suggestionId the suggestion id
	 */
	void removeSuggestion(String apiKey, String suggestionId);

	/**
	 * Suggest location.
	 *
	 * @param apiKey the api key
	 * @param photoId the photo id
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @param note the note
	 */
	void suggestLocation(String apiKey, String photoId, String lat, String lon,
			String accuracy, String woeId, String placeId, String note);// accuracy,woeId,placeId,note,
}