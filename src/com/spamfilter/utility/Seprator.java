package com.spamfilter.utility;

import java.util.regex.Pattern;

public class Seprator {


	public static String[] separate(String line) {
		Pattern pat=Pattern.compile("[ %/.,^'*_<>/${}@#!:;?]|[\"\"+/-=*)(]");
		return removeSpace(pat.split(line));
		
	}
	private static String[] removeSpace(String[] split) {
		String str="";
		for(int i=0;i<split.length;i++)
		str=(str+" "+split[i]).trim();
	
		return str.split(" ");
	}

}
