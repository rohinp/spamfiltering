package com.spamfilter.services;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.spamfilter.operation.WordCountOps;
import com.spamfilter.service.WordCount;

public class WordCountTest {

	@Test
	public void itShouldCountTheWordsFromMyFile() throws FileNotFoundException, IOException {
		//given
		String filePath = "data/file.txt";
		WordCount wordCount = new WordCount();

		//when
		WordCountOps wco = wordCount.countStoreWords(filePath);
		//then
		wco.displayWordCounter();
	}

}
