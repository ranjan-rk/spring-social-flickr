package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Topic;
import org.springframework.social.flickr.api.Topics;

/**
 * The Class GroupsDiscussTopicsTemplateTest.
 * 
 * @author HemantS
 */
public class GroupsDiscussTopicsTemplateTest  extends AbstractFlickrApiTest{
	@Test
	public void addTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.groups.discuss.topics.add&format=json&nojsoncallback=1"))
				.andExpect(method(POST))
				.andRespond(withResponse(jsonResource("topic"), responseHeaders));
		Topic topic = flickr.groupsDiscussTopicsOperations().add("1878057@N24", "where do you live", "india");
		assertTopic(topic);
	}

	@Test
	public void getInfoTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?topic_id=72157632833309573&method=flickr.groups.discuss.topics.add&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("topic"), responseHeaders));
		Topic topic = unauthorizedFlickr.groupsDiscussTopicsOperations().getInfo("72157632833309573");
		assertTopic(topic);
	}
	
	@Test
	public void getListTest() {
		unauthorizedMockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?group_id=1878057%40N24&method=flickr.groups.discuss.topics.getList&format=json&nojsoncallback=1&api_key=consumerKey"))
				.andExpect(method(GET))
				.andRespond(withResponse(jsonResource("topics"), responseHeaders));
		Topics topics = unauthorizedFlickr.groupsDiscussTopicsOperations().getList("1878057@N24",null,null);
		assertTopics(topics);
	}
	
	private void assertTopics(Topics topics) {
		Assert.assertEquals("1878057@N24",topics.getGroup_id());
	}
	private void assertTopic(Topic topic) {
		Assert.assertEquals("72157632833309573", topic.getId());
	}

}
