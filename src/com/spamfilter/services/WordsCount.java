package com.spamfilter.services;
import com.spamfilter.utility.Removeal;
import com.spamfilter.utility.Seprator;

public class WordsCount {
	WordCounter wc=new WordCounter();
	
	public  WordCounter Counts(String line) {
		String[]a=Seprator.separate(Removeal.getReleventData(line));
		 wc.insertWords(a);
		return wc;
	}

}
