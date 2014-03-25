package com.spamfilter.services;
import org.junit.Test;

import com.spamfilter.services.WordsCount;

public class WordCountTest {
	@Test
	public void itShouldCountWordsFromivenSentence() {
		String setence="this is a boy who working for me as well as you too";
		WordsCount wds=new WordsCount();
		WordCounter wc=new WordCounter();
		 wc=wds.Counts(setence);
		wc.dispaly();
	}

}
