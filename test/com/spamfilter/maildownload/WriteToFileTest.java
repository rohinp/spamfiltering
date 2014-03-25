package com.spamfilter.maildownload;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class WriteToFileTest {

	@Test
	public void test() throws IOException {
		StringBuilder data=new StringBuilder("ok dude its over");
		WriteToFile.storeInFile(data, "ok");
		assertEquals("ok dude its over", FileRead.getFileContain("E:\\workspace\\spamweb1\\mails\\ok.eml"));
	}

}
