package org.springframework.social.flickr.api;

import java.util.ArrayList;

public class Clusters {
	private String source;
	private Number total;
	private ArrayList<Cluster> cluster;

	public ArrayList<Cluster> getCluster() {
		return cluster;
	}

	public void setCluster(ArrayList<Cluster> cluster) {
		this.cluster = cluster;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Number getTotal() {
		return total;
	}

	public void setTotal(Number total) {
		this.total = total;
	}
}
