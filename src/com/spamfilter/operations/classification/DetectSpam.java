package com.spamfilter.operations.classification;

import java.io.IOException;

public class DetectSpam {

	public static boolean isSpam(String path) throws IOException {
		FinalProbablity.calculateProbablity(path);
		System.out.println(FinalProbablity.getFinalProbablity());
		return FinalProbablity.getFinalProbablity()>=0.5;
	}

}
