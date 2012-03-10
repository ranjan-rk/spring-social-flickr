package org.springframework.social.flickr.api;

public enum PhotoSizeEnum {
	//TODO:need to work on o , original image option
	/*
		s	small square 75x75
		q	large square 150x150
		t	thumbnail, 100 on longest side
		m	small, 240 on longest side
		n	small, 320 on longest side
		z	medium 640, 640 on longest side
		b	large, 1024 on longest side*
		o	original image, either a jpg, gif or png, depending on source format
	 */
	s,q,t,m,n,z,b,o;
}
