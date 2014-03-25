package com.mongodb.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathOpsTest {

	@Test
	public void test() {
		Double a=new Double(3);
		int ac=1;
		Double d=a+ac;
		Double b=new Double(2);
		Double actual=MathOps.calculateProbablity(d,b);
		System.out.println(actual.toString());
		Double expected=new Double(0.6666666666666666);
		assertEquals(expected, actual);
	}

}
