package com.spamfilter.utility.mathutility;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathOpsTest {

	@Test
	public void ItShouldCalculatingProbability() {
		//given
		int sfrquency=30;
		int gfrquency=5;
	
		Double expected=1.0;
		//when
		Double actual=MathOps.calculatingProbability(sfrquency,gfrquency);
		//then
		assertEquals(expected, actual);
	}

}
