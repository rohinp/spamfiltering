package com.mongodb.dao.testdouble;

import com.mongodb.dao.QueryEngine;

public class MockQueryEngine implements QueryEngine {

	

	@SuppressWarnings("unused")
	private String key;
	@SuppressWarnings("unused")
	private String subkey;
	@SuppressWarnings("unused")
	private Double value;
	@SuppressWarnings("unused")
	private Double value2;
	@SuppressWarnings("unused")
	private String id;

	@Override
	public double getScalarValue(String key, String subkey) {
		if (subkey.equals("spamFrequency")) {
			return 1.0;
		}else if (subkey.equals("geniunFrequecy")) {
			return 2.0;
		}
		return 0.33;
	}

	@Override
	public void saveScalarValues(String key, String subkey, Double value,
			Double value2) {
		this.key=key;
		this.subkey=subkey;
		this.value=value;
		this.value2=value2;
	}

	@Override
	public void saveSingleValue(String key, String value) {
		this.key=key;
		this.id=value;
	}

	@Override
	public boolean isPresent(String key, String value) {
		return true;
	}

	@Override
	public void remove(String key, String value) {
		
	}

}
