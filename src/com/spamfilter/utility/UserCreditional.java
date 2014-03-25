package com.spamfilter.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UserCreditional {

	private static BufferedReader br;
	private static String str;
	private static String data;
	private static String userdata="";
	private static FileWriter fw;

	public  void Save(String user, String password) {
		String username=user;
		String pass=password;
		try {

			File file = new File("E:/workspace/spamweb1/logs.dat");
			if (!file.exists()) {
				file.createNewFile();
			}
			delete();
			br=new BufferedReader(new FileReader(file));
			if(br.read()==-1){
				fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);	
			bw.write(user + " " + pass);
			bw.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  String Retrive() throws IOException {
		FileReader file=new FileReader("E:/workspace/spamweb1/logs.dat");
		br=new BufferedReader(file);
		while((data=br.readLine())!=null)
			userdata=data;
		 
		return userdata;
	}


	public  void delete() throws FileNotFoundException {
		File file = new File("E:/workspace/spamweb1/logs.dat");
		PrintWriter empty=new PrintWriter(file);
		empty.write(0);
		
	}

}

