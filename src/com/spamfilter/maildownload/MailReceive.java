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

import com.sun.mail.pop3.POP3Store;


public class MailReceive {
	private String user;
	private String password;
	private StringBuilder emailcontain=new StringBuilder(" ");
	private StringBuilder msgID=new StringBuilder(" ");
	public MailReceive(String user, String password) {
		this.user=user;
		this.password=password;
	}
	public boolean validateEmailUser(){
		Properties properties = newProperties();
		POP3Store emailStore = getEmailSession(properties);
		try {

			emailStore.connect(user, password);

			return true;
		} catch (MessagingException e) {
			return false;
		}
	}

	public void receive()   {
		Properties properties = newProperties();
		POP3Store emailStore = getEmailSession(properties);
		try {
			emailStore.connect(user, password);
			Folder emailfolder = selectEmailFolder(emailStore);
			getEmailContent(emailStore, emailfolder);
		} catch (MessagingException |IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	

	private void getEmailContent(POP3Store emailStore, Folder emailfolder)
			throws MessagingException, IOException {
		Message[] message = emailfolder.getMessages();
		String id=" ";
		for (int a = 0; a < message.length; a++) { 
			Enumeration headers = message[a].getAllHeaders();
			while (headers.hasMoreElements()) {
				Header h = (Header) headers.nextElement();
				emailcontain.append(h.getName().toString()+":"+h.getValue().toString()+"\n");

			}
			
			emailcontain.append("Bodycontent:"+ message[a].getSentDate()+"\n");
			emailcontain.append("Content:"+message[a].getContent()+"\n");


			Multipart mp =  (Multipart) message[a].getContent();  
			for (int i = 0; i < mp.getCount(); i++) {  
				BodyPart bodyPart = mp.getBodyPart(i);  
				InputStream stream = bodyPart.getInputStream();
				if(bodyPart.isMimeType("text/*")){  
					BufferedReader br = new BufferedReader(new InputStreamReader(stream));  
					while (br.ready()) {  
						emailcontain.append(br.readLine()+"\n");
					}
				}
			}
			msgID=emailcontain;
			id=MailID.getmsgId(msgID);
			WriteToFile.storeInFile(emailcontain,id);
			emailcontain.delete(0, emailcontain.length());
		}

		emailfolder.close(false);
		emailStore.close();
	}	


	private Folder selectEmailFolder(POP3Store emailStore)  {
		Folder emailfolder = null;
		try {
			emailfolder = emailStore.getFolder("INBOX");
			emailfolder.open(Folder.READ_ONLY);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return emailfolder;
	}

	private POP3Store getEmailSession(Properties properties) {
		Session emailSession=Session.getDefaultInstance(properties);
		POP3Store emailStore = null;
		try {
			emailStore = (POP3Store) emailSession.getStore("pop3s");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emailStore;
	}
	private Properties newProperties() {
		Properties properties=new Properties();
		properties.put("mail.pop3s.host", "pop.gmail.com");
		return properties;
	}
}