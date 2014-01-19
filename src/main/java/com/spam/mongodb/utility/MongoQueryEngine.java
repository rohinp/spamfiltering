package com.spam.mongodb.utility;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.factory.MongoFactory;
import com.mongodb.math.MathOps;

public class MongoQueryEngine {

	private static final String key ="word";
	private  static final  String geniunEmailID="GeniunEmailID";
	private static final String spam_EmailId="SpamEmailID";
	private static BasicDBObject count;
	private static BasicDBObject probability;
	private static DBCursor cursor; 

	public static int getSpamFrequencyCount(String attribute){
		return   getAttribute(attribute,"spamfrequency");
	}

	public static int getGenuinFrequencyCount(String attribute){
		return getAttribute(attribute,"geniunfrequency");
	}

	public  void updateSpamCount(String word, Integer frequency){
		int gfrequency=getGenuinFrequencyCount(word);
		int sfrequency =getSpamFrequencyCount(word)+frequency;
		float prob=genrateProb(sfrequency, gfrequency);
		update(word, "spamfrequency", frequency, prob);
	}

	public void updateGenuinCount(String word, Integer frequency) {
		int sfrequency=getSpamFrequencyCount(word);
		int gfrequency =getGenuinFrequencyCount(word)+frequency;
		float prob=genrateProb(sfrequency, gfrequency);
		update(word, "geniunfrequency", frequency, prob);
	}

	public static void insertGeniuneEmailID(String id) {
		insert(geniunEmailID, id);
	}

	public static  void insertSpamEmailID(String id) {
		insert(spam_EmailId, id);
	}
	public static Boolean ispresentGeniunId(String id) {
		return isPresent(geniunEmailID, id);
	}
	public static Boolean ispresentSpamId(String id) {
		return isPresent(spam_EmailId, id);
	}

	//private Functions
	private static DBCursor createCursor(String attribute){
		return MongoFactory.getcollection().find(query(attribute));
	}
	private static BasicDBObject emptyDocument() {
		return new BasicDBObject();
	}
	private static DBObject document(String key,String value){
		return new BasicDBObject(key,value);
	}
	private static BasicDBObject query(String attribute) {
		return (BasicDBObject) document(key, attribute);
	}
	private static Boolean isPresent(String key,String value){
		return MongoFactory.getcollection().
				findOne(document(key, value)) != null;
	}
	private static void insert(String key,String id) {
		if (!isPresent(key,id))
			MongoFactory.getcollection().insert(document(key, id));	
	}

	private static Integer getAttribute(String attribute,String wordFrequency){
		Integer value=null;
		cursor = createCursor(attribute);
		while(cursor.hasNext()) {
			DBObject obj = cursor.next();
			value = (Integer) obj.get(wordFrequency);
			return  value!=null?value :0;
		}
		return 0;
	}
	private static float genrateProb(int sfrequency,int gfrequency){
		return MathOps.calculateProbablity(sfrequency, gfrequency);
	}
	private static void update(String word, String attribute,Integer frequency,
			float prob) {
		count=setFrequency(attribute, frequency);
		probability=setProbability(prob);
		MongoFactory.getcollection().update(query(word), count,true,false);
		MongoFactory.getcollection().update(query(word), probability,true,false);

	}

	private static BasicDBObject  setFrequency(String attribute, Integer sfrequency) {
		return emptyDocument().append("$inc", emptyDocument()
				.append(attribute, sfrequency));
	}
	private static BasicDBObject setProbability(float prob) {
		return emptyDocument().append("$set", emptyDocument()
				.append("probability", prob));
	}


}
