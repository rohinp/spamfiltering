package com.spamfilter.services.training;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import com.mongodb.dao.MongoQueryEngine;
import com.mongodb.dao.SpamDAO;
import com.spamfilter.utility.MailContain;

public class GeniuneTrainingTest {

	@Test
	public void shouldStoreIdToSpamDatabase() throws FileNotFoundException, IOException  {
		
		StringBuffer mail=new StringBuffer("MIME-Version: 1.0 X-Received: by 10.224.69.4 with SMTP id x4mr39418489qai.59.1385623365812; Wed, 27 Nov 2013 23:22:45 -0800 (PST) Received: by 10.140.40.167 with HTTP; Wed, 27 Nov 2013 23:22:45 -0800 (PST) Date: Thu, 28 Nov 2013 12:52:45 +0530 Message-ID: <CAO1uGr546Vgv5rJpqiaHgrEUGmTUYN21oqe2O59hHvJpJLe2Zw@mail.gmail.com> Subject:  From: ketan jain <jain.ketan2008@gmail.com> To: Pankaj Patil <panpatil88@gmail.com>Content-Type: multipart/mixed; boundary=001a11c2fe6c83e62104ec37941b hi how r u");
		GeniuneTraining training=new GeniuneTraining(mail);
	
		 training.addEmailId();
		 training.addContain();
		 
		 assertTrue(new SpamDAO(new MongoQueryEngine()).ispresentGeniunId(MailContain.getEmailId(mail)));
		 
	}

}
