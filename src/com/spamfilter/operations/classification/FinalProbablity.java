package com.spamfilter.operations.classification;

import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

import com.mongodb.dao.MongoQueryEngine;
import com.mongodb.dao.SpamDAO;
import com.spamfilter.services.FileRead;
import com.spamfilter.utility.MailContain;
import com.spamfilter.utility.Removeal;
import com.spamfilter.utility.Seprator;

public class FinalProbablity {


	static Removeal ConjunctionArticles=new Removeal();
	static TreeSet<String> set;
	static double probList[];

	static private String mail;
	static double probablity;
	private static String id;
	private static SpamDAO dbDAO=new SpamDAO(new MongoQueryEngine());
	public static void calculateProbablity(String path) throws IOException {
	
		mail=MailContain.getMailContain(new StringBuffer(new FileRead().getFileContain(path)));
		id=MailContain.getEmailId(new StringBuffer(new FileRead().getFileContain(path)));
		String[] contain =Seprator.separate(mail);
		
		set=new TreeSet<String>();
		
		for(int i=0;i<contain.length;i++)
		{
			set.add(contain[i]);
		}
		
		probList=new double[set.size()];

		int i=0;
		for (String word : set) 
		{
			probList[i]=dbDAO.getProbability(word);
			i++;
		}
		
		Arrays.sort(probList);

			calculate();
	}
	
	private static void calculate() {
		
		probablity=1.0f;
		int size=10;
		
		if(probList.length<=20)
			size=size/2;
		
		for(int i=0;i<size;i++)
		{
			probablity=probablity*probList[i];
		}
		
		if(dbDAO.ispresentGeniunId(id))
			probablity=probablity-0.2;
		else if(dbDAO.ispresentSpamId(id))
			probablity=probablity+0.2;
	}
	
	public static double getFinalProbablity() {
		
		return probablity;
	}



}
