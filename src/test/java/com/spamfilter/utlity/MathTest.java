package com.spamfilter.utlity;



import static org.junit.Assert.*;

import java.util.WeakHashMap;

import org.junit.Test;

import com.spamfilter.utility.MathOps;

public final class MathTest {
	@Test
	public void shouldIncrementSpamAndGenuineFrquency() {

		//given
		int spamFrequency=2;
		int genuineFrequency=1;
		float actual=0.6666667f;
		//when
		float prob=MathOps.calculateProbablity(spamFrequency, genuineFrequency);
		System.out.println(prob);
		//then
		assertEquals(actual,prob,prob);
		
		
	}

}
