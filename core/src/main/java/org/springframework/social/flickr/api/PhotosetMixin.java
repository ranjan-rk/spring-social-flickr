package org.springframework.social.flickr.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotosetMixin {
	@JsonProperty("count_views") String countViews;
	@JsonProperty("count_comments") String countComments;
	@JsonProperty("count_photos") String countPhotos;
	@JsonProperty("count_videos") String countVideos;
	@JsonProperty("can_comment") boolean canComment;
	@JsonProperty("date_create") String dateCreate;
	@JsonProperty("date_update") String dateUpdate;
	@JsonProperty("needs_interstitial") String needsInterstitial;
	@JsonProperty("visibility_can_see_set") String visibilityCanSeeSet;

}
