package org.springframework.social.flickr.api;

// TODO: Auto-generated Javadoc
/**
 * The Interface CamerasOperations.
 * 
 * @author HemantS
 * 
 */
public interface CamerasOperations {
	
	/**
	 * TODO: bug at flickr side 
	 * if detail parameter is empty, they return as array ([])
	 * if detail parameter is not empty , they return as object ( {})
	 * Gets the brand models.
	 *
	 * @param brand the brand
	 * @return the brand models
	 */
	Cameras getBrandModels(String brand);
	
	/**
	 * Gets the brands.
	 *
	 * @return the brands
	 */
	Brands getBrands();
}
