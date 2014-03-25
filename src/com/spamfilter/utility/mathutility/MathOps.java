package com.spamfilter.utility.mathutility;

public class MathOps {
	private static double defultValue=1.0;
	public static Double calculatingProbability(int sfrquency, int gfrquency) {
		Double prob=  (((double)sfrquency/ ((double)sfrquency+(double)gfrquency)));
		return prob>=0.85?defultValue:prob;
	}
	public static Double calculateProbablity(Double spamFrequency,
			Double genuineFrequency) {
		Double prob=spamFrequency/ (spamFrequency+genuineFrequency);
		return prob>=0.85?defultValue:prob;
	}

}
