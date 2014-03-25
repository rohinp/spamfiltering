package com.mongodb.dao;

public class MathOps {

	private static Double defultValue=1.0;

	public static Double calculateProbablity(Double spamFrequency,
			Double genuineFrequency) {
		 Double prob=spamFrequency/(spamFrequency+genuineFrequency);
		return prob>0.85?defultValue:prob;
	}

}
