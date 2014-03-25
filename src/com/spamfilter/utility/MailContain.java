package com.spamfilter.utility;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;


public class MailContain {


	public static String getEmailId(StringBuffer mail) {

		StringBuffer str=new StringBuffer(mail.substring(mail.indexOf("From"),mail.length()));
		
		return str.substring(str.indexOf("<")+1,str.indexOf(">"));

	}

	public static String getMailContain(StringBuffer mail) {

		String str=mail.toString();
		if(str.contains("<body"))
		{
			String str1=str.substring(str.indexOf("<body"),str.length());
			str=str.substring(str.indexOf("<body")+str1.indexOf(">")+1,str.indexOf("</body>"));
		}
		else
		{
			str=str.substring(str.indexOf("Message-Id")+"Message-Id".length(),str.length());
		}
		str= removeAllHtml(str);
		//str=str.substring(str.indexOf("Content-Transfer-Encoding: 7bit")+"Content-Transfer-Encoding: 7bit".length(),str.length()-"------000000000000000000000--".length());
		return str.trim();
	}

	public static String removeAllHtml(String htmlContent) {
		return Jsoup.parse(htmlContent).text();
	}

	public static String getIPaddress(StringBuffer mail) {
		String ip ;

		String maildata=mail.toString();
		String data=maildata.substring(maildata.indexOf("client-ip="),maildata.indexOf("Authentication-Results:"));
		ip=data.substring(data.indexOf("client-ip")+10, data.indexOf(";")-1);
		return ip;

	}
	public static String getSubject(StringBuffer mail) {
		//StringBuffer str=new StringBuffer(mail.substring(mail.indexOf("Subject"),mail.length()));
		
		//return str.substring(str.indexOf("<")+1,str.indexOf(">"));
		Pattern pattern = Pattern.compile("(Subject:)(.*)");
	    Matcher matcher = pattern.matcher(mail.toString());
	    String result = "";
	    while (matcher.find()) {
	      result += matcher.group();
	    }
	    //System.out.println(matcher.group(2));
		return result;
	}



}
