package com.spamfilter.utility;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class UserCreditionalTest {
	UserCreditional us =new UserCreditional();
	@Test
	public void itShouldSaveInToFile() {
		String user="name";
		String password="123";
		us.Save(user,password);


	}
	@Test
	public void itShouldRetriveFormFile() throws IOException {
		/*String user="rockexample123@gmail.com";
		String password="Rock12345";
		us.Save(user,password);*/
		String one=us.Retrive();
		System.out.println(one);
		String two=us.Retrive();
		System.out.println(two);
		String three=us.Retrive();
		System.out.println(three);
		String four=us.Retrive();
		System.out.println(four);
		/*assertEquals(user+" "+password, dispaly);*/
	}

	@Test
	public void itShoulDeleteFormFile() throws IOException {
		
		us.delete();
		String dispaly=us.Retrive();
		assertEquals("", dispaly);

	}
//	@Test
//	public void itShouldNotSaveMoreThanOneFile() throws IOException{
//		String user="ok";
//		String password="123";
//		UserCreditional.Save(user,password);
//		String dispaly=UserCreditional.Retrive();
//		System.out.println(dispaly);
//		assertEquals(user+","+password, dispaly);
//	}


}
