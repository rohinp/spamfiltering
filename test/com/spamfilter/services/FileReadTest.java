package com.spamfilter.services;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

import com.spamfilter.utility.ListOfFiles;

public class FileReadTest {
	ListOfFiles file=new ListOfFiles();

	private LinkedList<String> files;

	@Test
	public void shouldReadTheContaintOfFile() throws IOException {
		
		ListOfFiles mails=new ListOfFiles();
		String expected=" hi how are u?";
		files=mails.listOf("D:/virar/data");
		FileRead fr=new FileRead();

		String actual=fr.getFileContain("D:/virar/data/"+files.getFirst());
		System.out.println(actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldStoreContaintOfMultipleFileInDataBase() throws IOException {
		
		ListOfFiles mails=new ListOfFiles();
		String expected="hi how are u?";
		files=mails.listOf("D:/virar/data");
			FileRead fr=new FileRead();
		String actual=fr.getFileContain("D:/virar/data/"+files.getFirst());
		System.out.println(actual);
		assertEquals(expected, actual);
	}
	

}
