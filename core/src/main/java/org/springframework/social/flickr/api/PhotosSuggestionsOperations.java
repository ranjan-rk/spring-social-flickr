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
	 * @param suggestionId the suggestion id
	 * @return true, if successful
	 */
	boolean approveSuggestion(String suggestionId);

	/**
	 * Gets the list.
	 *
	 * @param photoId the photo id
	 * @param statusId the status id
	 * @return the list
	 */
	Suggestions getList(String photoId, String statusId);// photoId,statusId,

	/**
	 * Reject suggestion.
	 *
	 * @param suggestionId the suggestion id
	 * @return true, if successful
	 */
	boolean rejectSuggestion(String suggestionId);

	/**
	 * Removes the suggestion.
	 *
	 * @param suggestionId the suggestion id
	 * @return true, if successful
	 */
	boolean removeSuggestion(String suggestionId);

	/**
	 * Suggest location.
	 *
	 * @param photoId the photo id
	 * @param lat the lat
	 * @param lon the lon
	 * @param accuracy the accuracy
	 * @param woeId the woe id
	 * @param placeId the place id
	 * @param note the note
	 * @return the suggestions
	 */
	Suggestions suggestLocation(String photoId, String lat, String lon,
			String accuracy, String woeId, String placeId, String note);// accuracy,woeId,placeId,note,
}