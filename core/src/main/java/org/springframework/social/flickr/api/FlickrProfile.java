/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.flickr.api;

public class FlickrProfile {

	public static class User {
		private String nsid;
		private String id;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNsid() {
			return nsid;
		}

		public void setNsid(String nsid) {
			this.nsid = nsid;
		}

		
	}

	private String stat;
	
	private User user; 

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}
}
