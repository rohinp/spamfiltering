package com.spamfilter.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class FileRead {

	
	private   String contain=" ";
	private  String str;
	private  BufferedReader br;

	public  String getFileContain(String path) throws IOException {
		
		FileReader file=new FileReader(path);
		br=new BufferedReader(file);
		
		while((str=br.readLine())!=null)
			contain=contain+str;
		br.close();
		return contain;
	}
	
	public  String getFileContaint(File file) throws IOException {
		
		FileReader filer=new FileReader(file.getAbsolutePath());
		BufferedReader br=new BufferedReader(filer);
		while((str=br.readLine())!=null)
			contain=contain+str;
		br.close();
		return contain;
	}
}
