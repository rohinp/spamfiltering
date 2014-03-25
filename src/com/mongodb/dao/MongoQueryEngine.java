package com.mongodb.dao;


import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.factory.MongoFactory;

public class MongoQueryEngine implements QueryEngine {

	private static BasicDBObject query;
	private static BasicDBObject count;
	private static BasicDBObject probability;
	private static DBCursor cursor; 
	@Override
	public double getScalarValue(String key, String subkey) {
		return getAttribute(key,subkey);
	}

	private Double getAttribute(String key, String subkey) {
		query =getQuery(key);
		cursor = MongoFactory.getcollection("words").find(query);
		Double value=null;
		while(cursor.hasNext()) {
			DBObject obj = cursor.next();
			value = (Double)obj.get(subkey);
			return  value!=null?value :0.0;
		}
		return subkey.equals("Probability")?1.0:0.0;
	}
	private static BasicDBObject getQuery(String wordtype) {
		return getInstanceofDocument().append("word", wordtype);
	}

	private static BasicDBObject getInstanceofDocument() {
		return new BasicDBObject();
	}



	@Override
	public void saveScalarValues(String key, String subkey, Double value,
			Double value2) {
		update( key, subkey,  value, value2);
	}
	private static void update(String word, String attribute,Double frequency,Double prob) {
		query=getQuery(word);
		count=setFrequency(attribute, frequency);
		probability=setProbability(prob);
		MongoFactory.getcollection("words").update(query, count,true,false);
		MongoFactory.getcollection("words").update(query, probability,true,false);
	}
	private static BasicDBObject setProbability(Double prob) {
		return getInstanceofDocument().append("$set", getInstanceofDocument()
				.append("probability", prob));
	}

	private static BasicDBObject  setFrequency(String attribute, Double sfrequency) {
		return getInstanceofDocument().append("$inc", getInstanceofDocument()
				.append(attribute, sfrequency));
	}
	
	@Override
	public void saveSingleValue(String key, String value) {
		insert(key,value);
	}

	private void insert(String key, String id) {
		DBObject doc=new BasicDBObject(key,id);
		MongoFactory.getcollection("emailIdSet").insert(doc);
	}

	@Override
	public boolean isPresent(String key, String value) {
		return isPresentEmailId(key,value);
	}

	private boolean isPresentEmailId(String key, String value) {
		DBObject document=new BasicDBObject(key,value);
		return MongoFactory.getcollection("emailIdSet").findOne(document) != null;	
	}

	@Override
	public void remove(String key, String value) {
		RemoveEmailId( key,  value);
	}

	private void RemoveEmailId(String key, String value) {
		DBObject doc=new BasicDBObject(key,value);
		MongoFactory.getcollection("emailIdSet").remove(doc);
	}
	

}
