package org.springframework.social.flickr.api;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlickrProfileMixin {
    @JsonCreator
    FlickrProfileMixin(@JsonProperty("nsid") long nsid){}
    
    @JsonProperty("url")
    private String url;
    
    @JsonProperty("stat")
    private String stat;
}
