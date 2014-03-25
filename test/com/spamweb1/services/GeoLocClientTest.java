package com.spamweb1.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeoLocClientTest {

	@Test
	public void test() {
		GeoLocClient geoc = new GeoLocClient();
		System.out.println(geoc.getLocatonDetails("66.186.127.22"));
	}

}
