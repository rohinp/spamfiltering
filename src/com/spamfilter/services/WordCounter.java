package com.spamfilter.services;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordCounter {

	private  Map<String, Integer> wordcounter;
	private Integer defultCount=1;

	public WordCounter(){
		setwordCounter(new HashMap<String, Integer>());
	}
	public void setwordCounter(Map<String, Integer> dummy) {
		this.wordcounter=dummy;
	}


	public boolean isWordPresent(String word) {
		return wordcounter.containsKey(word);
	}
	public void insert(String word) {
		if(isWordPresent(word)){
			wordcounter.put(word, wordcounter.get(word)+1);
		}else
			wordcounter.put(word, defultCount);
	}

	public Map<String, Integer>  getwordCounter() {
		return wordcounter;
	}
	public void dispaly() {
		Iterator<String> it=wordcounter.keySet().iterator();
		while (it.hasNext()) {
			String key=it.next();
			Integer values=wordcounter.get(key);
			System.out.println(key+"="+values);

		}
	}
	public void insertWords(String[] words){
		for (String word : words) 
			insert(word);
	}
}

