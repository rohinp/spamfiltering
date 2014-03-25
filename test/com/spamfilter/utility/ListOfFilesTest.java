package com.spamfilter.utility;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import com.spamweb1.services.EmailInfo;

public class ListOfFilesTest {

	@Test
	public void itShouldAbleToGiveLIstOfMailFile() {
		//given
		ListOfFiles files=new ListOfFiles();
		LinkedList<String>expecteds=new LinkedList<>();
		expecteds.add("TRAIN_00000.eml");

		//when
		LinkedList<String>actual= files.listOf("E:/workspace/spamweb1/spam");	
		assertEquals(expecteds, actual);
	}
	@Test
	public void itShouldAbleToGiveLIstOfGeniunEMailFile() throws IOException {
		//given
		ListOfFiles files=new ListOfFiles();
		LinkedList<EmailInfo>expecteds=new LinkedList<>();
		expecteds.add(new EmailInfo("Form:bengreen@mindupmerchants.com","MessageID:TRAIN_00000.eml"));
		//when
		ArrayList<EmailInfo>actual= files.listOfGenuinEmail();	
		for (Iterator iterator = actual.iterator(); iterator.hasNext();) {
			EmailInfo emailInfo = (EmailInfo) iterator.next();
			System.out.println(emailInfo.toString());
		}
		//assertEquals(expecteds.toString(), actual.toString());

	}
	@Test
	public void itShouldAbleToGiveLIstOfSpamFile() throws IOException {
		//given
		ListOfFiles files=new ListOfFiles();
		LinkedList<EmailInfo>expecteds=new LinkedList<>();
		expecteds.add(new EmailInfo("Form:bengreen@mindupmerchants.com","MessageID:TRAIN_00000.eml"));
		//when
		ArrayList<EmailInfo>actual= files.listOfSpamEmail();	
		for (Iterator iterator = actual.iterator(); iterator.hasNext();) {
			EmailInfo emailInfo = (EmailInfo) iterator.next();
			System.out.println(emailInfo.toString());
		}
		//assertEquals(expecteds.toString(), actual.toString());

	}
}
