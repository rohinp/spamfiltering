package com.spamfilter.utility;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.spamfilter.services.FileRead;

public class MailContantTest {
FileRead fr=new FileRead();
	@Test
	public void shouldSeprateIdFromEmail() throws IOException {

		//given
		String maildata=fr.getFileContain("E:/workspace/spamweb1/spam/TRAIN_00000.eml");
		//when
		StringBuffer mail=new StringBuffer(maildata);		
		//when

		System.out.println(MailContain.getEmailId(mail));
		//then
		assertEquals(MailContain.getEmailId(mail),"bengreen@mindupmerchants.com");	
	}

	@Test
	public void shouldSeprateContainFromEmail() throws IOException {	
		//given
		String actual=fr.getFileContain("E:/workspace/spamweb1/spam/TRAIN_00000.eml");
		StringBuffer mail=new StringBuffer(actual);
		//when
		System.out.println(MailContain.getMailContain(mail));
		//then
	}
	@Test
	public void shouldSeprateIpAddressFromEmail() throws IOException {

		//given
		String maildata=fr.getFileContain("E:/workspace/spamweb1/mails/11ea09c2e2cc42f3a04373512b4dba08@1856.eml");
		//when
		StringBuffer mail=new StringBuffer(maildata);

		System.out.println(MailContain.getIPaddress(mail));
		//then
		assertEquals(MailContain.getIPaddress(mail),"204.92.22.13");	
	}
	@Test
	public void itShouldSeprateSubjectAddress() throws IOException{
		//given
		String maildata=fr.getFileContain("E:/workspace/spamweb1/mails/11ea09c2e2cc42f3a04373512b4dba08@1856.eml");
		//when
		StringBuffer mail=new StringBuffer(maildata);
		System.out.println("----------");
		System.out.println(MailContain.getSubject(mail));
		assertEquals(MailContain.getSubject(mail)," Assessment for CIOs and IT Leadership Teams");

	}


}
