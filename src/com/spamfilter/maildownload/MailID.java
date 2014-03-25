package com.spamfilter.maildownload;

public class MailID {

	public static String getmsgId(StringBuilder str) {
		String msgid=str.toString();
		String id= msgid.substring(msgid.indexOf("Message-ID:"),msgid.indexOf("Bodycontent"));
		return id.substring(id.indexOf("<")+1,id.indexOf(">"));
	}

}
