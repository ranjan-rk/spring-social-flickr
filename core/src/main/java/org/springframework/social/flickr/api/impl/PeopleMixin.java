package org.springframework.social.flickr.api.impl;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.flickr.api.PhotoPerson;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleMixin {
	@JsonProperty("person") PhotoPerson person;
}
