package com.maxmind.geoip.test;

/* CityLookupTest.java */

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

public class CityLookupIdxTest {
	private static final double DELTA = 1e-5;

	@Test
	public void testCityLookupIdx() throws IOException {

		LookupService cl = new LookupService(
				"C:\\Users\\ketan\\workspace\\spamweb1\\src\\resource\\GeoIP\\GeoIPCity.dat",
				LookupService.GEOIP_INDEX_CACHE);

		Location l1 = cl.getLocation("66.92.181.240");
		System.out.println(l1.countryCode);
		assertEquals("JP", l1.countryCode);
		assertEquals("Japan", l1.countryName);
		assertEquals("40", l1.region);
		assertEquals("Tokyo", l1.city);
		assertEquals(35.6850, l1.latitude, DELTA);
		assertEquals(139.7510, l1.longitude, DELTA);
		assertEquals(0, l1.metro_code);
		assertEquals(0, l1.area_code);
		cl.close();
	}

}
