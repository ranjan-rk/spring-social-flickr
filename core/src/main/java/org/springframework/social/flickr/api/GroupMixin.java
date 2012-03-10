package org.springframework.social.flickr.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupMixin {
	@JsonProperty("iconserver") String iconServer;
	@JsonProperty("iconfarm") String iconFarm;
	@JsonProperty("eighteenplus") String eighteenPlus;
	@JsonProperty("invitation_only") String invitationOnly;
	@JsonProperty("pool_count") String poolCount;
	
}
