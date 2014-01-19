package com.spamfilter.operation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordCountOps {
	private Map<String, Integer> wordCounter;
	private final Integer defaultWordCount = new Integer(1);
	private Iterator<String> wordIndex;

	public WordCountOps(){
		setWordCounter(new HashMap<String,Integer>());
	}

	public Map<String, Integer> getWordCounter() {
		return wordCounter;
	}

	public void setWordCounter(Map<String, Integer> wordCounter) {
		this.wordCounter = wordCounter;
	}

	public void insertWord(String word){
		if(isWordInCounter(word)){
			incrementWordCount(word);
		}else{
			getWordCounter().put(word, defaultWordCount);
		}
	}

	public void insertWords(String[] words){
		for(int index = 0; index < words.length; index++)
			insertWord(words[index]);
	}

	public boolean isWordInCounter(String word){
		return getWordCounter().containsKey(word);
	}

	public Integer getDefaultWordCount() {
		return defaultWordCount;
	}

	public void incrementWordCount(String word){
		getWordCounter().put(word, getWordCounter().get(word) + 1);
	}

	public void displayWordCounter(){
		setWordIndex(getWordCounter().keySet().iterator());
		while(getWordIndex().hasNext()){
			String aKey   = getWordIndex().next();
			Integer  aValue = getWordCounter().get(aKey);
			System.out.println(aKey + " = " + aValue);
		}
	}

	public Iterator<String> getWordIndex() {
		return wordIndex;
	}

	public void setWordIndex(Iterator<String> wordIndex) {
		this.wordIndex = wordIndex;
	}

}
