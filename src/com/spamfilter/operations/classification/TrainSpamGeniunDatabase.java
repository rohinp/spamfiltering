package com.spamfilter.operations.classification;

import java.io.IOException;

import com.spamfilter.services.FileRead;
import com.spamfilter.services.training.GeniuneTraining;
import com.spamfilter.services.training.SpamTraining;

public class TrainSpamGeniunDatabase {

	private static SpamTraining sTraining;
	private static GeniuneTraining gTraining;

	public static void trainSpamGeniunDatabase(String path) throws IOException {
		
		if(DetectSpam.isSpam(path))
		{
			sTraining=new SpamTraining(new StringBuffer(new FileRead().getFileContain(path)));
			sTraining.addEmailId();
			sTraining.addContain();
		}
		else
		{
			gTraining=new GeniuneTraining(new StringBuffer(new FileRead().getFileContain(path)));
			gTraining.addEmailId();
			gTraining.addContain();
		}
	}

}
