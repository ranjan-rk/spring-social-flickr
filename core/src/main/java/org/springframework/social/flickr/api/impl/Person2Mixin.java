package org.springframework.social.flickr.api.impl;

import org.codehaus.jackson.annotate.JsonProperty;

public class Person2Mixin {
	@JsonProperty("username") String userName;
	@JsonProperty("iconserver") String iconServer;
	@JsonProperty("iconfarm") String iconFarm;
	@JsonProperty("favedate") String faveDate;
}
