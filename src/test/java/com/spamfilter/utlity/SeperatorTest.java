package com.spamfilter.utlity;

import static org.junit.Assert.*;

import org.junit.Test;

import com.spamfilter.utility.Seperator;

public class SeperatorTest {

	@Test
	public void itShouldSeperateLineIntoWords() {
		//given
		String line ="I am going to fuck";
		String[] expecteds = {"I","am","going","to","fuck"};
		//when
		Seperator seperator = new Seperator();
		String[] actuals = seperator.wordSeperator(line);
		//then
		System.out.println(actuals);
		assertArrayEquals(expecteds, actuals);
	}

}
