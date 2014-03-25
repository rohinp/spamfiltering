package com.spamfilter.maildownload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileRead {


	private static  String contain="";
	private static String str;
	private static BufferedReader br;

	public static String getFileContain(String path) throws IOException {

		FileReader file=new FileReader(path);
		br=new BufferedReader(file);

		while((str=br.readLine())!=null)
			contain=contain+str;

		return contain;
	}
}
