package com.spamfilter.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import com.spamfilter.utility.Seprator;

public class SeparatorTest {

	@Test
	public void ItShouldSeparateWordsFroomSentence() {
		String line=" its@^ good. ++to? ()see{} you !%again.";
		String[] actual =Seprator.separate(line);
		String[] expected = {"its","good","to","see","you","again"};
		for (String words : actual) {
			System.out.println(words);
		}
		assertArrayEquals(expected, actual);
	}

}
