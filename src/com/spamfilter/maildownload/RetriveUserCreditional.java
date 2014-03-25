package com.spamfilter.maildownload;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;

import com.spamfilter.utility.UserCreditional;
import com.sun.mail.pop3.POP3Store;

public class RetriveUserCreditional {
	private String data;
	private String user;
	private String pass;
	MailReceive receive;
	public RetriveUserCreditional()  {
		try {
			data=new UserCreditional().Retrive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] userdata=data.split(" "); 
		for (int i = 0; i < userdata.length; i++) {
			user=userdata[0];
			pass=userdata[1];
		}
		System.out.println("user:"+user+"\n"+"pass:"+pass);
		receive=new MailReceive(user,pass);
	}
	public void fetchEmail(){
		receive.receive();
		//check spam here...
	}


}




