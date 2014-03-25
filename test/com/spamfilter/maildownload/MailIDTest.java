
	package com.spamfilter.maildownload;

	import static org.junit.Assert.*;

	import java.io.IOException;

	import org.junit.Test;

	public class MailIDTest {

		@Test
		public void itShouldgetmsgID() throws IOException {
			String maildata=FileRead.getFileContain("F:/workspace_projects/mailrecieving/downloadedmail/LYRIS-1542219989-9487842-2014.03.21-08.00.06--rockexample123#gmail.com@ifwnewsletters.newsletters.infoworld.com.eml");
			//when
			StringBuilder mail=new StringBuilder(maildata);
			System.out.println(MailID.getmsgId(mail));
			//then
			assertEquals(MailID.getmsgId(mail),"LYRIS-1542219989-9487842-2014.03.21-08.00.06--rockexample123#gmail.com@ifwnewsletters.newsletters.infoworld.com");	
		}
		@Test
		public void itShouldgetmsgIDforword() throws IOException {
			String maildata=FileRead.getFileContain("F:/workspace_projects/mailrecieving/downloadedmail/ok.eml");
			//when
			StringBuilder mail=new StringBuilder(maildata);
			System.out.println(MailID.getmsgId(mail));
			//then
			assertEquals(MailID.getmsgId(mail),"CAO1uGr7o2PnWoVp9sWkQnGA7zj+A9+11QbS4pgFvef3Ba-C4bg@mail.gmail.com");	
		}

	}


