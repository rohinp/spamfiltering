package com.spamfilter.services.training;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.mongodb.dao.MongoQueryEngine;
import com.mongodb.dao.SpamDAO;
import com.spamfilter.services.WordCounter;
import com.spamfilter.services.WordsCount;
import com.spamfilter.utility.MailContain;

public class SpamTraining {

	private StringBuffer mail;
	private SpamDAO db;
	private WordCounter wco;
	private WordsCount wc;
	private Map<String, Integer> map;
	public SpamTraining(StringBuffer mail) {
		this.mail=mail;
		db=new SpamDAO(new MongoQueryEngine());
		wco=new WordCounter();
		wc=new WordsCount();
		map=new HashMap<String,Integer>();
	}

	public void addEmailId() {
		db.insertSpamEmailID(MailContain.getEmailId(mail));
	}

	public void addContain() {
		wco=wc.Counts(MailContain.getMailContain(mail));
		map=wco.getwordCounter();
		Iterator<String>it=map.keySet().iterator();
		while (it.hasNext()) {
			String word = (String) it.next();
			Integer frequency=map.get(word);
			System.out.println(word+" "+frequency);
			db.updateSpamFrequency(word, frequency);
		}
		
		
	}

}
