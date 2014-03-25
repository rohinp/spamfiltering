package com.spamfilter.services.training;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import com.spamfilter.services.FileRead;
import com.spamfilter.utility.ListOfFiles;

public class Training {

	GeniuneTraining gTraining;
	SpamTraining sTraining;
	ListOfFiles mails;
	LinkedList<String> list;
	Iterator< String> itr;
	
	public void trainSpam(String path) throws IOException {
		
		
		
		mails=new ListOfFiles();
		
		list=mails.listOf(path);
		
		itr=list.iterator();
		
		while(itr.hasNext())
		{
			sTraining=new SpamTraining(new StringBuffer(new FileRead().getFileContain(path+"/"+itr.next())));
			sTraining.addEmailId();
			sTraining.addContain();
		}
		
	}

	public void trainGeniun(String path) throws IOException {
		

		mails=new ListOfFiles();
		
		list=mails.listOf(path);
		
		itr=list.iterator();
		
		while(itr.hasNext())
		{
			gTraining=new GeniuneTraining(new StringBuffer(new FileRead().getFileContain(path+"/"+itr.next())));
			gTraining.addEmailId();
			gTraining.addContain();
		}
	}
	

}
