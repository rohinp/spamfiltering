package com.spamfilter.maildownload;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
 
public class WriteToFile {
	public static void  storeInFile(StringBuilder data,String msgID) {
		String maildata=data.toString();
		try {

			File file = new File("E:/workspace/spamweb1/mails/"+msgID+".eml");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(maildata);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}