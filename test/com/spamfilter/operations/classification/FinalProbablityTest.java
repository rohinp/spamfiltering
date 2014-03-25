package com.spamfilter.operations.classification;

import java.io.IOException;

import org.junit.Test;

public class FinalProbablityTest {

	@Test
	public void shouldCalculateProbablity() throws IOException {
		
		FinalProbablity.calculateProbablity("F:/workspace_projects/spamfilter_v1.0/spam/TRAIN_00000.eml");
		
		double probablity=FinalProbablity.getFinalProbablity();
		System.out.println(probablity);
	}

}
