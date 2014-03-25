package com.spamfilter.utility;


public class Removeal {
	static String[] data;
	private static String newline="";
	public static String getReleventData(String line) {
		data=Seprator.separate(line);
		for (int i = 0; i < data.length; i++) {
			if(!isMatch(data[i]))
				newline=newline+data[i]+" ";							
		}
		return newline;
	}

	private static boolean isMatch(String word) {
		return word.matches(StopWord.getString("regx"));
	}
}
