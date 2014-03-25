package com.spamfilter.utility;

import java.io.IOException;

import com.spamfilter.services.FileRead;

public class IPAddressFromMsgID {

	private  String data="";
	private  String path="";
	private  StringBuffer maildata=new StringBuffer(0);

	public String getIpGeniun(String filename){

		return getIP("E:/workspace/spamweb1/mails/",filename);
	}
	public String getIpSpam(String filename){

		return getIP("E:/workspace/spamweb1/spam/",filename);
	}
	public String getIP(String dir,String filename) {
		path="E:/workspace/spamweb1/mails/".concat(filename);
		try {
			data=new FileRead().getFileContain(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maildata=new StringBuffer(data);
		path=" ";
		return MailContain.getIPaddress(maildata);
	}

}
