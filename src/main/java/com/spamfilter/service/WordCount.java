package com.spamfilter.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.spamfilter.operation.WordCountOps;
import com.spamfilter.utility.RemoveConjunctionArticles;
import com.spamfilter.utility.Seperator;

public class WordCount {
	
	String line;
	String[] words;
	Seperator seperator;
	WordCountOps wordCountOps;
	RemoveConjunctionArticles removeConjunctionArticles;
	
	public WordCount(){
		line = "";
		seperator = new Seperator();
		wordCountOps = new WordCountOps();
		removeConjunctionArticles=new RemoveConjunctionArticles();
	}
	
	public WordCountOps countStoreWords(String filePath) throws FileNotFoundException, IOException{
		//BufferedReader bf = FileRead.getFileObject(filePath);
		//while ((line = bf.readLine()) != null) {
			//System.out.println(removeConjunctionArticles.getRelevantData(line));
			wordCountOps.insertWords(seperator.wordSeperator(removeConjunctionArticles.getRelevantData(line)));
		//}
		//bf.close();
		return wordCountOps;
	}
}
