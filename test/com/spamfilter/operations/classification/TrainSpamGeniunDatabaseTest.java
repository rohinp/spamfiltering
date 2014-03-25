package com.spamfilter.operations.classification;

import java.io.IOException;

import org.junit.Test;


public class TrainSpamGeniunDatabaseTest {

	@Test
	public void shouldTrainSpanAndGeniunDatabse() throws IOException
	{	
		TrainSpamGeniunDatabase.trainSpamGeniunDatabase("F:/workplace_practice/spamfilter_v1.0/spam/TRAIN_00000.eml");
	}
}
