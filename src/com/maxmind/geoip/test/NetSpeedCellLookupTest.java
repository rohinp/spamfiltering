package com.maxmind.geoip.test;

/* OrgLookupTest.java */

// Need a binary sample dataset

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.maxmind.geoip.LookupService;

public class NetSpeedCellLookupTest {
	public void testNetSpeedCellLookup() throws IOException {
		LookupService ns = new LookupService(
				"src/resources/GeoIP/GeoIPNetSpeedCell.dat");
		assertEquals("Cable/DSL", "89.66.148.0");
		ns.close();
	}
}
