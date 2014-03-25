package com.spamfilter.services.training;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.mongodb.dao.MongoQueryEngine;
import com.mongodb.dao.SpamDAO;
import com.spamfilter.services.WordCounter;
import com.spamfilter.services.WordsCount;
import com.spamfilter.utility.MailContain;

public class GeniuneTraining {

	private StringBuffer mail;
	SpamDAO dbDao;
	WordCounter wco;
	WordsCount wc;
	private Map<String, Integer> map;
	private Set<String> set;
	public GeniuneTraining(StringBuffer mail) {
		this.mail=mail;
		dbDao=new SpamDAO(new MongoQueryEngine());
		wco=new WordCounter();
		wc=new WordsCount();
		map=new HashMap<String,Integer>();
	}

	public void addEmailId() {
		dbDao.insertGeniuneEmailID(MailContain.getEmailId(mail));
	}

	public void addContain() {
		wco = wc.Counts(MailContain.getMailContain(mail));
		map=wco.getwordCounter();
		set=map.keySet();
		Iterator<String> itr=set.iterator();

		while(itr.hasNext())
		{
			String word=itr.next().toString();
			Integer frequency=map.get(word);
			System.out.println(word+" "+frequency);
			dbDao.updateGeniunFrequency(word, frequency);
			//	new MongoQueryEngine().updateGenuinCount(word, frequency);

		}

	}

}
