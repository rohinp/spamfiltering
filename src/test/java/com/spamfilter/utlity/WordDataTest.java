package com.spamfilter.utlity;
import org.junit.Before;
import org.junit.Test;

import com.spamfilter.utility.WordData;

public class WordDataTest {
	
	private WordData word;

	@Before
	public void setUp()
	{
		word=new WordData();
	}

	@Test
	public void itShouldUpdateDocument() {
		
		//given
		int spamFrequency=2;
		int genuineFrequency=1;
		String attribute="ok";
		//when
		word.setGenuineFrequency(attribute, genuineFrequency);
		word.setSpamFrequency(attribute, spamFrequency);
		//then
		
	}
	
	

	}
