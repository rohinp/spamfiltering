package com.spamfilter.utility;

public class MathOps {
	
	static WordData word=new WordData();

	

	public static float calculateProbablity(int spamFrequency,int genuineFrequency) {
		
		return ((float)spamFrequency/((float)spamFrequency+(float)genuineFrequency));
	}

}
