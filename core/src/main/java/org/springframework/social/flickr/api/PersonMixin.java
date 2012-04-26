package org.springframework.social.flickr.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonMixin {

	@JsonProperty("username") String userName;
	@JsonProperty("iconserver") String iconServer;
	@JsonProperty("iconfarm") String iconFarm;
	@JsonProperty("path_alias") String pathAlias;
	@JsonProperty("realname") String realName;
	@JsonProperty("photos") PhotosInfo photos;
}
