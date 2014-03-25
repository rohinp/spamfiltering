package com.spamfilter.utility;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class IPaddressFromMsgIDTest {

	@Test
	public void test() throws IOException {
		String path2="11ea09c2e2cc42f3a04373512b4dba08@1856.eml";
		IPAddressFromMsgID ip=new IPAddressFromMsgID();
		String a=ip.getIpGeniun(path2);
		System.out.println(a);
		assertEquals("91.216.139.23", a);
	}

}
