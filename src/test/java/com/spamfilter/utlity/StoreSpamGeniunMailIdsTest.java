package com.spamfilter.utlity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.spamfilter.utility.StoreSpamGeniunMailIds;

public class StoreSpamGeniunMailIdsTest {

	private String id;
	private StoreSpamGeniunMailIds mailId;

	@Before
	public void setUp()
	{
		mailId=new StoreSpamGeniunMailIds();
	}

	@Test
	public void shouldStoreGenuinMailId() {
		id="ketan@gmail.com";
		mailId.setGeniunMailId(id);

	}
	
	@Test
	public void shouldStoreSpamMailId() {
		id="kean@gmail.com";
		mailId.setSpamMailId(id);

	}

	@Test
	public void checkWhetherGeniunDatabaseContainId() {

		id="ketan@gmail.com";
		assertTrue(mailId.geniunContains(id)); 
	}

	@Test
	public void checkWhetherSpamDatabaseContainId() {

		id="kean@gmail.com";
		assertTrue(mailId.spamContains(id)); 
	}

}
