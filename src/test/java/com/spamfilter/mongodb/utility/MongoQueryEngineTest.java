package com.spamfilter.mongodb.utility;

import static org.junit.Assert.*;

import org.junit.Test;
import com.spam.mongodb.utility.MongoQueryEngine;

public class MongoQueryEngineTest {
	@Test
	public void itShouldAbleToCreateNewDocumentSpamCountIfNotPresent(){
		//give
		String word="wos";
		Integer sf=new Integer(8);
		//when
		MongoQueryEngine query=new MongoQueryEngine();
		query.updateSpamCount(word, sf);
		//then
		assertNotNull(query);
	}

	@Test
	public void  itShouldAbleToCreateNewDocumentWithGenuinCountIfNotPresent(){
		//give
		String word="wos";
		Integer sf=new Integer(4);
		//when
		MongoQueryEngine query=new MongoQueryEngine();
		query.updateGenuinCount(word, sf);
		//then
		assertNotNull(query);
	}
	@Test
	public void itShouldRetriveSpamCountOFDocument() {
		//given
		String attribute="wos";
		//when
		Integer actual=MongoQueryEngine.getSpamFrequencyCount(attribute);
		Integer expected=8;
		System.out.println(actual);
		//then
		assertEquals(expected, actual);
		
	}
	@Test
	public void itShouldRetriveGniueCountOFDocument() {
		//given
		String attribute="wos";
		//when
		Integer  actual=MongoQueryEngine.getGenuinFrequencyCount(attribute);
		System.out.println(actual);
		Integer expected=12;
		//then
		assertEquals(expected, actual);
		
	}
@Test 
public void itShouldUpdateGniueCountOFDocument(){
	//give
	String word="good";
	Integer gf=new Integer(8);
	//when
	MongoQueryEngine query=new MongoQueryEngine();
	query.updateGenuinCount(word, gf);
	
}
@Test 
public void itShouldUpdateSpamCountOFDocument(){
	//give
	String word="good";
	Integer sf=new Integer(4);
	//when
	MongoQueryEngine query=new MongoQueryEngine();
	query.updateSpamCount(word, sf);
	
}
@Test
public  void itShouldStoreGeniuneEmailId() {
	//give
		String id="kqw.jain@gmail.com";
		//when
		MongoQueryEngine.insertGeniuneEmailID(id);
		//then
		assertTrue(MongoQueryEngine.ispresentGeniunId(id));
}
@Test
public  void itShouldStoreSpamEmailId() {
	//give
		String id1="raam.atil@gmail.com";
		//when
		MongoQueryEngine.insertSpamEmailID(id1);
		//then
		assertTrue(MongoQueryEngine.ispresentSpamId(id1));
}


}


