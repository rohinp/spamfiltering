package com.spamweb1.services;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
 
public class GeoLocClient {
 
	// http://localhost:8080/RESTfulExample/json/product/get
	public String getLocatonDetails(String ipAddress) {
 
		String output = "";
		String result ="";
	  try {
 
		URL url = new URL("http://www.geoplugin.net/json.gp?ip=" + ipAddress);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
 
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
 
		
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null){
			result += output;
		}
 
		conn.disconnect();
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	  }
	  return result;
 
	}
 
}
