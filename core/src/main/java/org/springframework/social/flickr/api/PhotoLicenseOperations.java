package org.springframework.social.flickr.api;

/**
 * The Interface PhotoLicenseOperations.
 *
 * @author HemantS
 */
public interface PhotoLicenseOperations {

	/**
	 * Fetches a list of available photo licenses for Flickr.
	 * 
	 * This method does not require authentication.
	 * 
	 * @return Licenses
	 */
	Licenses getInfo();
	
	/**
	 * flickr.photos.licenses.setLicense
	 * 
	 * This method requires authentication with 'write' permission.
	 * 
	 * @param photoId
	 * @param license
	 * @return
	 */
	boolean setLicense(String photoId ,LicenseEnum license);
	
}
