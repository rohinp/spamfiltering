package com.spamfilter.services;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import com.spamfilter.utility.ListOfFiles;
import com.spamweb1.services.EmailInfo;

public class EmailListTest {
	@Test
	public void itShouldAbleToGiveLIstOfMailFile() {
		//given
		EmailList files=new EmailList();
		LinkedList<String>expecteds=new LinkedList<>();
		expecteds.add("TRAIN_00000.eml");

		//when
		LinkedList<String>actual=files.listOf("E:/workspace/spamweb1/spam");	
		assertEquals(expecteds, actual);
	}
	
	@Test
	public void itShouldAbleToGiveLIstOfEMailFile() throws IOException {
		//given
		EmailList files=new EmailList();		

		//when
		LinkedList<EmailInfo>actual=files.emailList();	
		Iterator iterator = actual.iterator();
		while ( iterator.hasNext()) {
			EmailInfo emailInfo = (EmailInfo) iterator.next();
			System.out.println(emailInfo);
		}
		//assertEquals(expecteds, actual);
	}
}
