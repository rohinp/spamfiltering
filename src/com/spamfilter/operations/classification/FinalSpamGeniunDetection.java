package com.spamfilter.operations.classification;

import java.io.IOException;

import com.spamfilter.services.training.GeniuneTraining;
import com.spamfilter.services.training.SpamTraining;

public class FinalSpamGeniunDetection {

	private static SpamTraining sTraining;
	private static GeniuneTraining gTraining;

	public static void classifyMail(String mailPath) throws IOException {
	
		if(DetectSpam.isSpam(mailPath))
		{
			addMailContainToSpamDatabase(mailPath);
		}
		else
		{
			addMailContainToGeniunDatabase(mailPath);
		}
	}


	private static void addMailContainToGeniunDatabase(String mailPath) {
		
		gTraining=new GeniuneTraining(new StringBuffer(mailPath));
		gTraining.addEmailId();
		gTraining.addContain();
	}

	
	private static void addMailContainToSpamDatabase(String mailPath) {
		
		sTraining=new SpamTraining(new StringBuffer(mailPath));
		sTraining.addEmailId();
		sTraining.addContain();
	}

}
