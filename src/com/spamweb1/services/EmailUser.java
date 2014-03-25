package com.spamweb1.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.spamfilter.maildownload.MailReceive;
import com.spamfilter.utility.ListOfFiles;
import com.spamfilter.utility.UserCreditional;

public class EmailUser {
	private String uname;
	private String pass;
	MailReceive mailreceive;

	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean validateUser(){
		mailreceive = new MailReceive(this.uname, this.pass);
		mailreceive.receive();
		if(mailreceive.validateEmailUser()){
			UserCreditional.Save(this.uname, this.pass);
			return true;
		}
		return false;
	}

	public List<EmailInfo> getEmails(){
		ListOfFiles lof = new ListOfFiles();

		try {
			return lof.listOfGenuinEmail();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public List<EmailInfo> getSpamEmails(){

		ListOfFiles lof = new ListOfFiles();

		try {
			return lof.listOfSpamEmail();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}


}
