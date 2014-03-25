package com.mongodb.dao;

public interface QueryEngine {

	public double getScalarValue(String key,String subkey);
	void saveScalarValues(String key, String subkey, Double value,Double value2);
	void saveSingleValue(String key, String value);
	boolean isPresent(String key,String value);
	void remove(String key,String value);
}
