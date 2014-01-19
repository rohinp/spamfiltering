package com.spamfilter.operation;

import static org.junit.Assert.*;


import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.spamfilter.operation.WordCountOps;


public class WordCountOpsTest {
	WordCountOps wordCount;

	@Before
	public void setUp(){
		wordCount = new WordCountOps();
		Map<String,Integer> dummyMap= new HashMap<String,Integer>();
		dummyMap.put("fuck",new Integer(3));
		dummyMap.put("suck", new Integer(2));
		wordCount.setWordCounter(dummyMap);
	}
	@Test
	public void itShouldCheckIfWordExistsInWordCounter() {
		//given
		
		//when
		boolean condition = wordCount.isWordInCounter("fuck");
		//then
		assertTrue(condition);
	}
	
	@Test
	public void itShouldInsertWordOrIncrementWordCounter(){
		//given
		
		//when
		wordCount.insertWord("Ketan");
		wordCount.insertWord("fuck");
		//then
		assertEquals(wordCount.getWordCounter().get("Ketan"), new Integer(1));
		assertEquals(wordCount.getWordCounter().get("fuck"), new Integer(4));
	}

	@Test
	public void itShouldDisplayTheEntireMap(){
		wordCount.displayWordCounter();
	}
	
	
}
