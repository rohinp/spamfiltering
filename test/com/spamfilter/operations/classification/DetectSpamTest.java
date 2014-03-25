package com.spamfilter.operations.classification;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DetectSpamTest {

	@Test
	public void shouldCheckWhetherMailIsSpam() throws IOException {
		
		assertTrue(DetectSpam.isSpam("F:/workspace_projects/spamfilterV1/spam/TRAIN_00000.eml"));
	}

}
