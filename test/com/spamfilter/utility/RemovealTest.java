package com.spamfilter.utility;

import static org.junit.Assert.*;

import org.junit.Test;

import com.spamfilter.utility.Removeal;

public class RemovealTest {

	@Test
	public void itShouldRemoveAwantedWords() {
		//given
		String str="this is a boy who working for me as well as you too";
		String expected="boy working me you ";
		//when
		String actual=Removeal.getReleventData(str);
		//System.out.println(Removeal.getReleventData(str));
		 assertEquals(expected, actual);
	}

}
