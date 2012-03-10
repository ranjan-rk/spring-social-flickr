package org.springframework.social.flickr.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoMixin {
	@JsonProperty("ispublic") boolean isPublic;
	@JsonProperty("isfriend") boolean isFriend;
	@JsonProperty("isfamily") boolean isFamily;
}
