package com.spamfilter.maildownload;

import static org.junit.Assert.*;

import org.junit.Test;

public class MailReceiveTest {

	@Test
	public void itshouldRecivingMail() {
		MailReceive mail=new MailReceive("rockexample123@gmail.com", "Rock12345");
		mail.receive();
		
		}
	
	@Test
	public void itshouldValidateMail() {
		MailReceive mail=new MailReceive("rockexample123@gmail.com", "Rock12345");
		assertTrue(mail.validateEmailUser());
		
		}
}
