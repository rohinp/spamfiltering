package com.spamfilter.utlity;

import static org.junit.Assert.*;

import org.junit.Test;

import com.spamfilter.utility.RemoveConjunctionArticles;

public class TestRemoveConjunctionArticles {

	@Test
	public void itShouldRemoveConjunctionAndArticles() {

		RemoveConjunctionArticles remove=new RemoveConjunctionArticles();
		
		String given="I am a an the Pankaj Patil a an the and but or nor for yet so and this is my profile the an";
		
		String expecteds="I am Pankaj Patil this is my profile ";
	
		String actuals=remove.getRelevantData(given);
		
		
		assertEquals(expecteds, actuals);
	}

}
