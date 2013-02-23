package org.springframework.social.flickr.api;

import java.util.Collections;

// TODO: Auto-generated Javadoc
/**
 * The Interface CollectionsOperations.
 */
/**
 * TODO: collectoin is only availabe to  pro account as pointed here http://www.flickr.com/help/collections/
 * I need pro account to implement this api, as i need .json to test 
 * 
 * @author HemantS
 *
 */
public interface CollectionsOperations{

/**
 * Gets the info.
 * @param collectionId the collection id
 *
 * @return the info
 */
void getInfo (String collectionId);

/**
 * Gets the tree.
 * @param collectionId the collection id
 * @param userId the user id
 *
 * @return the tree
 */
Collections getTree (String collectionId,String userId);//collectionId,userId,
}