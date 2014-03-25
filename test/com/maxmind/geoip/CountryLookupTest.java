package com.maxmind.geoip;

/* CountryLookupTest.java */

/* Only works with GeoIP Country Edition */
/* For Geoip City Edition, use CityLookupTest.java */

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.maxmind.geoip.LookupService;

public class CountryLookupTest {
	@Test
	public void testCountryLookup() throws IOException {

		String dbfile = "C:\\Users\\ketan\\workspace\\spamweb1\\src\\resource\\GeoIP\\GeoIP.dat";
		LookupService cl = new LookupService(dbfile,
				LookupService.GEOIP_MEMORY_CACHE);
System.out.println(cl.getCountry("91.216.139.23").getName());
		assertEquals("US", cl.getCountry("64.17.254.216").getCode());
		assertEquals("United States", cl.getCountry("64.17.254.216").getName());
		assertEquals("Italy", cl.getCountry("78.26.70.208").getName());
		assertEquals("France", cl.getCountry("83.206.36.224").getName());
		assertEquals("Germany", cl.getCountry("85.88.2.224").getName());

		cl.close();

	}
}
