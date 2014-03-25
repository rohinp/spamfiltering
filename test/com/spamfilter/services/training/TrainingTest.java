package com.spamfilter.services.training;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;

public class TrainingTest {

	@Test
	public void shouldSaveSpamTrainingData() throws IOException {
		
		Training training=new Training();
		
		training.trainSpam("F:/workplace_practice/spamfilter_v1.0/spam");
		
		assertNotNull(training);
		
	}
/*	
	@Test
	public void shouldSaveGeniunTrainingData() throws IOException {
		
		Training training=new Training();
		
		training.trainGeniun("F:/workplace_practice/spamfilter_v1.0/spam");
		
		assertNotNull(training);
		
	}*/

}
