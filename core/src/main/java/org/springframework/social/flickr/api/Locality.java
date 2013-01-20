package org.springframework.social.flickr.api;

/**
 * @author hemant
 *
 */
public class Locality {
		private String _content ;
		private String place_id ;
		private String woeid ;
		private String latitude ;
		private String longitude ;
		private String place_url ;
		public String get_content() {
			return _content;
		}
		public void set_content(String _content) {
			this._content = _content;
		}
		public String getPlace_id() {
			return place_id;
		}
		public void setPlace_id(String place_id) {
			this.place_id = place_id;
		}
		public String getWoeid() {
			return woeid;
		}
		public void setWoeid(String woeid) {
			this.woeid = woeid;
		}
		public String getLatitude() {
			return latitude;
		}
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		public String getLongitude() {
			return longitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public String getPlace_url() {
			return place_url;
		}
		public void setPlace_url(String place_url) {
			this.place_url = place_url;
		}
}
