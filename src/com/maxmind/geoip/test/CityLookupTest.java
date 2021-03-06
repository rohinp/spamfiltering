package com.maxmind.geoip.test;

/* CityLookupTest.java */

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;
import com.maxmind.geoip.timeZone;

public class CityLookupTest {
	private static final double DELTA = 1e-5;

	@Test
	public void testCityLookup() throws IOException {

		LookupService cl = new LookupService(
				"C:\\Users\\ketan\\workspace\\spamweb1\\src\\resource\\GeoIP\\GeoIPCity.dat",
				LookupService.GEOIP_MEMORY_CACHE);

		Location l1 = cl.getLocation("91.216.139.23");
		Location l2 = cl.getLocation("66.92.181.240");
		System.out.println(l2.latitude);
		System.out.println(l2.longitude);
		System.out.println("di"+l1.countryName);
		/*assertEquals("US", l2.countryCode);
		assertEquals("United States", l2.countryName);
		assertEquals("CA", l2.region);
		assertEquals("California",
				regionName.regionNameByCode(l2.countryCode, l2.region));
		assertEquals("Fremont", l2.city);
		assertEquals("94538", l2.postalCode);
		assertEquals(37.507904, l2.latitude, DELTA);
		assertEquals(-121.96, l2.longitude, DELTA);
		assertEquals(512.893498, l2.distance(l1), DELTA);
		assertEquals(l2.distance(l1), l1.distance(l2), DELTA);
		assertEquals(807, l2.metro_code);
		assertEquals(510, l2.area_code);
		assertEquals("America/Los_Angeles",
				timeZone.timeZoneByCountryAndRegion(l2.countryCode, l2.region));*/

		cl.close();

	}

}
