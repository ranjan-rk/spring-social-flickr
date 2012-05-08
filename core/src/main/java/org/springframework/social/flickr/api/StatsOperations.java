package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface StatsOperations.
 *
 * @author HemantS
 */
public interface StatsOperations {
	
	/**
	 * Gets the collection domains.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param collectionId the collection id
	 * @param perPage the per page
	 * @param page the page
	 * @return the collection domains
	 */
	Domains getCollectionDomains(String apiKey, String date,
			String collectionId, String perPage, String page);// collectionId,perPage,page,

	/**
	 * Gets the collection referrers.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param domain the domain
	 * @param collectionId the collection id
	 * @param perPage the per page
	 * @param page the page
	 * @return the collection referrers
	 */
	Domain getCollectionReferrers(String apiKey, String date, String domain,
			String collectionId, String perPage, String page);// collectionId,perPage,page,

	/**
	 * Gets the collection stats.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param collectionId the collection id
	 * @return the collection stats
	 */
	Stats getCollectionStats(String apiKey, String date, String collectionId);

	/**
	 * Gets the photo domains.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param photoId the photo id
	 * @param perPage the per page
	 * @param page the page
	 * @return the photo domains
	 */
	Domains getPhotoDomains(String apiKey, String date, String photoId,
			String perPage, String page);// photoId,perPage,page,

	/**
	 * Gets the photo referrers.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param domain the domain
	 * @param photoId the photo id
	 * @param perPage the per page
	 * @param page the page
	 * @return the photo referrers
	 */
	Domain getPhotoReferrers(String apiKey, String date, String domain,
			String photoId, String perPage, String page);// photoId,perPage,page,

	/**
	 * Gets the photoset domains.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param photosetId the photoset id
	 * @param perPage the per page
	 * @param page the page
	 * @return the photoset domains
	 */
	Domains getPhotosetDomains(String apiKey, String date, String photosetId,
			String perPage, String page);// photosetId,perPage,page,

	/**
	 * Gets the photoset referrers.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param domain the domain
	 * @param photosetId the photoset id
	 * @param perPage the per page
	 * @param page the page
	 * @return the photoset referrers
	 */
	Domain getPhotosetReferrers(String apiKey, String date, String domain,
			String photosetId, String perPage, String page);// photosetId,perPage,page,

	/**
	 * Gets the photoset stats.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param photosetId the photoset id
	 * @return the photoset stats
	 */
	Stats getPhotosetStats(String apiKey, String date, String photosetId);

	/**
	 * Gets the photo stats.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param photoId the photo id
	 * @return the photo stats
	 */
	Stats getPhotoStats(String apiKey, String date, String photoId);

	/**
	 * Gets the photostream domains.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param perPage the per page
	 * @param page the page
	 * @return the photostream domains
	 */
	Domains getPhotostreamDomains(String apiKey, String date, String perPage,
			String page);// perPage,page,

	/**
	 * Gets the photostream referrers.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param domain the domain
	 * @param perPage the per page
	 * @param page the page
	 * @return the photostream referrers
	 */
	Domain getPhotostreamReferrers(String apiKey, String date, String domain,
			String perPage, String page);// perPage,page,

	/**
	 * Gets the photostream stats.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @return the photostream stats
	 */
	Stats getPhotostreamStats(String apiKey, String date);

	/**
	 * Gets the popular photos.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @param sort the sort
	 * @param perPage the per page
	 * @param page the page
	 * @return the popular photos
	 */
	Photos getPopularPhotos(String apiKey, String date, String sort,
			String perPage, String page);// date,sort,perPage,page,

	/**
	 * Gets the total views.
	 *
	 * @param apiKey the api key
	 * @param date the date
	 * @return the total views
	 */
	Stats getTotalViews(String apiKey, String date);// date,
	
	/**
	 * Gets the cSV files.
	 *
	 * @param apiKey the api key
	 * @return the cSV files
	 */
	Stats getCSVFiles(String apiKey);
}