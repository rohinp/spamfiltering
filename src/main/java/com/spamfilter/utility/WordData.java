package com.spamfilter.utility;


import com.spam.mongodb.utility.MongoQueryEngine;

public class WordData {

	private int spamFrequency;
	private int genuineFrequency;
	private MongoQueryEngine query=new MongoQueryEngine();
	public void setSpamFrequency(String word,int spamfrequency)  {

		this.spamFrequency=spamfrequency;
		query.updateSpamCount(word,spamFrequency);
	}

	public void setGenuineFrequency(String word,int genuinefrequency) {

		this.genuineFrequency=genuinefrequency;
		query.updateGenuinCount(word, genuineFrequency);
	}

	public int getGenuineFrequency(String word) {
		return MongoQueryEngine.getGenuinFrequencyCount(word);
	}

	public int getSpamFrequency(String word)  {
		return	MongoQueryEngine.getSpamFrequencyCount(word);
	}


}
