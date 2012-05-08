package org.springframework.social.flickr.connect;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import org.junit.Test;
public class PlacesTemplateTest extends AbstractFlickrApiTest  {
@Test
public void findTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.find&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void findByLatLonTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.findByLatLon&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void getChildrenWithPhotosPublicTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.getChildrenWithPhotosPublic&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void getInfoTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.getInfo&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void getInfoByUrlTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.getInfoByUrl&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void getPlaceTypesTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.getPlaceTypes&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void getShapeHistoryTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.getShapeHistory&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void getTopPlacesListTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.getTopPlacesList&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void placesForBoundingBoxTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.placesForBoundingBox&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void placesForContactsTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.placesForContacts&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void placesForTagsTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.placesForTags&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void placesForUserTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.placesForUser&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void resolvePlaceIdTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.resolvePlaceId&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void resolvePlaceURLTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.resolvePlaceURL&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}
@Test
public void tagsForPlaceTest (){
mockServer.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.tagsForPlace&format=json&nojsoncallback=1"))
.andExpect(method(GET))
 .andRespond(withResponse(jsonResource("testuser"), responseHeaders));}

}