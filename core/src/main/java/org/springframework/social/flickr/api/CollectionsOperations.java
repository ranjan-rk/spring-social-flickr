package org.springframework.social.flickr.api;

import java.util.Collections;

// TODO: Auto-generated Javadoc
/**
 * The Interface CollectionsOperations.
 */
/**
 * @author HemantS
 *
 */
public interface CollectionsOperations{

/**
 * Gets the info.
 *
 * @param apiKey the api key
 * @param collectionId the collection id
 * @return the info
 */
void getInfo (String apiKey,String collectionId);

/**
 * Gets the tree.
 *
 * @param apiKey the api key
 * @param collectionId the collection id
 * @param userId the user id
 * @return the tree
 */
Collections getTree (String apiKey,String collectionId,String userId);//collectionId,userId,
}