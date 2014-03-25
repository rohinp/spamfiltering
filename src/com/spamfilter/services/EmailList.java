package com.spamfilter.services;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;



import com.spamfilter.utility.MailContain;
import com.spamweb1.services.EmailInfo;

public class EmailList {

	private LinkedList<EmailInfo> EmailList;
	private LinkedList<String> fileList;
	File dir;
	private File[] list;

	public EmailList() {
		fileList = new LinkedList<>();
		EmailList = new LinkedList<>();
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

	public LinkedList<EmailInfo> emailList() throws IOException {
		dir = new File("E:/workspace/spamweb1/mails");
		list = dir.listFiles();
		Map<String,StringBuffer> fileContents = new HashMap<>();
		for(File f : list){
			fileContents.put(f.getName(),new StringBuffer( new FileRead().getFileContaint(f)));
		}
		
		  Iterator<String> it = fileContents.keySet().iterator();
		  while (it.hasNext()) {
			String key=it.next();
			 StringBuffer values = fileContents.get(key);
			EmailList.add(new EmailInfo("from:"+MailContain.getEmailId(values),"msgID"+ key));
		}
		
		/*for (int i = 0; i < list.length; i++) {
			maildata = FileRead.getFileContain("E:/workspace/spamweb1/mails/"
					+ list[i].getName());
			EmailList
					.add(new EmailInfo(MailContain.getEmailId(new StringBuffer(
							maildata)), list[i].getName()));
		}*/
		return EmailList;
	}

}
