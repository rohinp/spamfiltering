package com.spamfilter.utility;

import com.spam.mongodb.utility.MongoQueryEngine;

public class StoreSpamGeniunMailIds {

	public void setGeniunMailId(String id) {
		MongoQueryEngine.insertGeniuneEmailID(id);
		
	}

	public void setSpamMailId(String id) {
		MongoQueryEngine.insertSpamEmailID(id);
	}

	public boolean spamContains(String id) {
		return MongoQueryEngine.ispresentSpamId(id);
	}

	public boolean geniunContains(String id) {
		return MongoQueryEngine.ispresentGeniunId(id);
	}

}
