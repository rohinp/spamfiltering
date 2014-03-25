package com.spamfilter.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.spamfilter.services.FileRead;
import com.spamweb1.services.EmailInfo;
import com.spamweb1.services.GeoLocationTest;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class ListOfFiles {

	private LinkedList<String> fileList;
	File dir;
	private File[] list;
	private LinkedList<EmailInfo> elist;
	StringBuffer maildata ;
	private String name;
	public ListOfFiles() {
		fileList = new LinkedList<>();
		elist = new LinkedList<>();
	}

	public LinkedList<String> listOf(String path) {
		dir = new File(path);
		list = dir.listFiles();
		for (int i = 0; i < list.length; i++) {
			if (list[i].isFile())
				fileList.add(list[i].getName());
		}
		return fileList;
	}

	
	
	public ArrayList<EmailInfo> listOfSpamEmail() throws IOException {
		return listOfEmail("E:/workspace/spamweb1/spam");
	}

	public ArrayList<EmailInfo> listOfGenuinEmail() throws IOException {
		return listOfEmail("E:/workspace/spamweb1/mails");
	}

	public ArrayList<EmailInfo> listOfEmail(String folder) throws IOException {
		dir=new File(folder);
		String gopath=" ";
		list=dir.listFiles();
		for (int i = 0; i < list.length; i++) {
			gopath=list[i].getAbsolutePath();
			String mail=new FileRead().getFileContain(gopath);
			StringBuffer data=new StringBuffer(mail);
			if (list[i].isFile()) {			
				elist.add(new EmailInfo("From:"+MailContain.getEmailId(data),"MessageID:"+list[i].getName()));
				//	System.out.println(" "+MailContain.getEmailId(maildata));
			}
		}

		return  new ArrayList<EmailInfo>(elist);

	}
}
