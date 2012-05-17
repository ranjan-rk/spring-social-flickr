package org.springframework.social.flickr.api;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhotoMixin {
	@JsonProperty("ispublic") boolean isPublic;
	@JsonProperty("isfriend") boolean isFriend;
	@JsonProperty("isfamily") boolean isFamily;
	@JsonProperty("is_faved") boolean isFaved;
	@JsonProperty("dateupload") String dateUpload;
	@JsonProperty("datetaken" ) String dateTaken;
	@JsonProperty("ownername") String ownerName;
	@JsonProperty("iconserver") String iconServer;
	@JsonProperty("originalformat") String originalFormat;
	@JsonProperty("lastupdate") String lastUpdate;
	@JsonProperty("machinetags") String machineTags;
	@JsonProperty("odims") String oDims;
	@JsonProperty("pathalias") String pathAlias;
	@JsonProperty("urlsq") String urlSq;
	@JsonProperty("urlt" ) String urlT;
	@JsonProperty("urls" ) String urlS;
	@JsonProperty("urlq" ) String urlQ;
	@JsonProperty("urlm" ) String urlM;
	@JsonProperty("urln" ) String urlN;
	@JsonProperty("urlz" ) String urlZ;
	@JsonProperty("urlc" ) String urlC;
	@JsonProperty("urll" ) String urlL;
	@JsonProperty("urlo") String urlO;
	@JsonProperty("person") Person2 person2;
	@JsonProperty("date_faved") String dateFaved;
}
