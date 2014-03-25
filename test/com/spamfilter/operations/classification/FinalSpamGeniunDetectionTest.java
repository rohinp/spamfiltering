package com.spamfilter.operations.classification;

import java.io.IOException;

import org.junit.Test;

public class FinalSpamGeniunDetectionTest {

	@Test
	public void test() throws IOException {
		
		FinalSpamGeniunDetection.classifyMail("F:/workplace_practice/spamfilter_v1.0/spam/TRAIN_00000.eml");
		
	}

}
