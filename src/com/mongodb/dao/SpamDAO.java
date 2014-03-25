package com.mongodb.dao;


public class SpamDAO {

	private QueryEngine queryEngine;

	public SpamDAO(QueryEngine queryEngine) {
		this.queryEngine=queryEngine;
	}

	public double getSpamFrequencyCount(String key) {
		return queryEngine.getScalarValue(key,"spamFrequency");
	}

	public double getGenuinFrequencyCount(String key) {
		return queryEngine.getScalarValue(key, "genuineFrequency");
	}

	public double getProbability(String key) {
		return queryEngine.getScalarValue(key, "Probability");
	}

	public void updateSpamFrequency(String key, Integer value) {
		Double sf=new Double(value);
		Double spamFrequency=getSpamFrequencyCount(key)+value;
		Double genuineFrequency=getGenuinFrequencyCount(key);
		Double prob=MathOps.calculateProbablity(spamFrequency, genuineFrequency);
		queryEngine.saveScalarValues(key, "spamFrequency",sf, prob);
	}

	public void updateGeniunFrequency(String key, Integer value) {
		Double gf=new Double(value);
		Double spamFrequency=getSpamFrequencyCount(key);
		Double genuineFrequency=getGenuinFrequencyCount(key)+value;
		Double prob=MathOps.calculateProbablity(spamFrequency, genuineFrequency);
		queryEngine.saveScalarValues(key,"genuineFrequency",gf, prob);		
	}

	public void insertGeniuneEmailID(String id) {
		if(!ispresentGeniunId(id)&&!ispresentSpamId(id))
		queryEngine.saveSingleValue("geniuneEmailId", id);
	}

	public void insertSpamEmailID(String id) {
		if(!ispresentSpamId(id)&&!ispresentGeniunId(id))
		queryEngine.saveSingleValue("spamEmailId", id);
	}

	public boolean ispresentGeniunId(String id) {
		return queryEngine.isPresent("geniuneEmailId", id);
	}

	public boolean ispresentSpamId(String id) {
		return queryEngine.isPresent("spamEmailId", id);
	}

	public void removeSpamEmailID(String id) {
		queryEngine.remove("spamEmailId", id);
	}

	public void removeGeninueEmailID(String id) {
		queryEngine.remove("geniuneEmailId", id);
		
	}

	
}
