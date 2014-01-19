package com.mongodb.math;

public class MathOps {
	
	


	public static float calculateProbablity(int spamFrequency,int genuineFrequency) {
		
		return ((float)spamFrequency/((float)spamFrequency+(float)genuineFrequency));
	}

}
