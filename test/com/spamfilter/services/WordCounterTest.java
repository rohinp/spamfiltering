package com.spamfilter.services;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class WordCounterTest {
	WordCounter counter=new WordCounter();

	@Before
	public  void setup() {
		Map<String, Integer>dummy=new HashMap<String,Integer>();
		dummy.put("ketan", new Integer(1));
		dummy.put("jain", new Integer(5));
		counter.setwordCounter(dummy);
	}
	@Test
	public void itShouldCheckwheterWordPresentExistsWordCounter() {
		
		boolean condition=counter.isWordPresent("jain");
		assertTrue(condition);
	}
	@Test
	public void itShouidInsertWordOrIncrementCount(){
		counter.insert("ketan");
		counter.insert("hitesh");
		assertEquals(counter.getwordCounter().get("ketan"), new Integer(2));
		assertEquals(counter.getwordCounter().get("hitesh"), new Integer(1));
	}
	@Test
	public void itShouldDisplay(){
		counter.dispaly();
	}
	

}
