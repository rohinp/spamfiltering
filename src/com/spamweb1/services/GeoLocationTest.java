package com.spamweb1.services;

import java.io.IOException;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

public class GeoLocationTest {
	private float longitude;
	private float latitude;
	private String conutrycode;
	private String countryname;
	private String region;
	private String city;
	private String postalCode;
	private Integer area_code;
	private Integer metro_code;
	public GeoLocationTest(String ipAddress){
		
		LookupService cl;
		try {
			cl = new LookupService(
					"C:\\Users\\ketan\\workspace\\spamweb1\\src\\resource\\GeoIP\\GeoIPCity.dat",
					LookupService.GEOIP_MEMORY_CACHE);
			
			Location l1 = cl.getLocation(ipAddress);
			setLatitude(l1.latitude);
			setLongitude(l1.longitude);
			setConutryCode(l1.countryCode);
			setCountryName(l1.countryName);
			setRegion(l1.region);
			setCity(l1.city);
			setPostalCode(l1.postalCode);
			setArea_Code(l1.area_code);
			setMetro_Code(l1.metro_code);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public String getConutryCode() {
		return conutrycode;
	}
	public void setConutryCode(String conutrycode) {
		this.conutrycode = conutrycode;
	}

	public String getCountryName() {
		return countryname;
	}



	public void setCountryName(String countryname) {
		this.countryname = countryname;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}



	public Integer getArea_Code() {
		return area_code;
	}



	public void setArea_Code(int area_code) {
		this.area_code = area_code;
	}



	public Integer getMetro_Code() {
		return metro_code;
	}



	public void setMetro_Code(int metro_code) {
		this.metro_code = metro_code;
	}
	
	@Override
	public String toString() {
		return "GeoLocationTest [longitude=" + longitude + ", latitude=" + latitude +", conutrycode="+conutrycode+", conutryname="+countryname+", region="+region+", city="+city
				+", postalCode=" + postalCode +", area_code=" + area_code +", metro_code=" + metro_code +"]";
	}
}
