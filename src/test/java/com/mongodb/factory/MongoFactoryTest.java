package com.mongodb.factory;

import static org.junit.Assert.*;

import org.junit.Test;

public class MongoFactoryTest {

	@Test
	public void test() {
		//given
		String collectionName ="words";
		String collection=MongoFactory.getcollection().toString();
		//when
	
		//then
		assertEquals(collection, collectionName);		
	}

}
