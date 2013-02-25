package org.springframework.social.flickr.api;

import org.springframework.social.ApiBinding;

// TODO: Auto-generated Javadoc
/**
 * The Interface Flickr.
 *
 * @author HemantS
 */
public interface Flickr extends ApiBinding {
	
	/**
	 * People operations.
	 *
	 * @return the people operations
	 */
	PeopleOperations peopleOperations();
	/**
	 * Photo operations.
	 *
	 * @return the photo operations
	 */
	PhotoOperations photoOperations();
	/**
	 * Activity operations.
	 *
	 * @return the activity operations
	 */
	ActivityOperations activityOperations(); 
	
	/**
	 * Commons operations.
	 *
	 * @return the commons operations
	 */
	CommonsOperations commonsOperations();
	/**
	 * Favorites operations.
	 *
	 * @return the favorites operations
	 */
	FavoritesOperations favoritesOperations();
	
	/**
	 * Galleries operations.
	 *
	 * @return the galleries operations
	 */
	GalleriesOperations galleriesOperations();
	/**
	 * Photo comment operations.
	 *
	 * @return the photo comment operations
	 */
	PhotoCommentOperations photoCommentOperations();
	
	/**
	 * Photo license operations.
	 *
	 * @return the photo license operations
	 */
	PhotoLicenseOperations photoLicenseOperations();
	
	/**
	 * Photo note operations.
	 *
	 * @return the photo note operations
	 */
	PhotoNoteOperations photoNoteOperations();
	
	/**
	 * Photoset operations.
	 *
	 * @return the photoset operations
	 */
	PhotosetOperations photosetOperations();

	/**
	 * Blogs operations.
	 *
	 * @return the blogs operations
	 */
	BlogsOperations blogsOperations();
	
	/**
	 * Groups operations.
	 *
	 * @return the groups operations
	 */
	GroupsOperations groupsOperations();
	/**
	 * Places operations.
	 *
	 * @return the places operations
	 */
	PlacesOperations placesOperations();
	/**
	 * Prefs operations.
	 *
	 * @return the prefs operations
	 */
	PrefsOperations prefsOperations();
	
	/**
	 * Cameras operations.
	 *
	 * @return the cameras operations
	 */
	CamerasOperations camerasOperations();
	
	/**
	 * Contacts operations.
	 *
	 * @return the contacts operations
	 */
	ContactsOperations contactsOperations();
	
	/**
	 * Groups discuss replies operations.
	 *
	 * @return the groups discuss replies operations
	 */
	GroupsDiscussRepliesOperations groupsDiscussRepliesOperations();
	
	/**
	 * Groups discuss topics operations.
	 *
	 * @return the groups discuss topics operations
	 */
	GroupsDiscussTopicsOperations groupsDiscussTopicsOperations();
	
	/**
	 * Groups members operations.
	 *
	 * @return the groups members operations
	 */
	GroupsMembersOperations groupsMembersOperations();
	
	/**
	 * Groups pools operations.
	 *
	 * @return the groups pools operations
	 */
	GroupsPoolsOperations groupsPoolsOperations();
	
	/**
	 * Interestingness operations.
	 *
	 * @return the interestingness operations
	 */
	InterestingnessOperations interestingnessOperations();
	
	/**
	 * Machinetags operations.
	 *
	 * @return the machinetags operations
	 */
	MachinetagsOperations machinetagsOperations();
	
	/**
	 * Panda operations.
	 *
	 * @return the panda operations
	 */
	PandaOperations pandaOperations();
	
	/**
	 * Photos geo operations.
	 *
	 * @return the photos geo operations
	 */
	PhotosGeoOperations photosGeoOperations();
	
	/**
	 * Photos people operations.
	 *
	 * @return the photos people operations
	 */
	PhotosPeopleOperations photosPeopleOperations();
	
	/**
	 * Photos suggestions operations.
	 *
	 * @return the photos suggestions operations
	 */
	PhotosSuggestionsOperations photosSuggestionsOperations();

}
