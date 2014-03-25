package com.mongodb.factory;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoFactory {

	private static DB database;
	private static Mongo mongo;

	public static DBCollection getcollection(String collectionName) {
		connectDB();
		return database.getCollection(collectionName);
	}
	private static void connectDB() {
		createMongoConnection();
		database = mongo.getDB("words");
	}

	private static void createMongoConnection() {
		try {
			if (mongo == null)
				mongo = new Mongo("localhost", 27017);
		} catch (UnknownHostException e) {
			throw new MongoDBServerNotFound(e.getMessage());
		}
	}
	public static class MongoDBServerNotFound extends RuntimeException {
		private static final long serialVersionUID = -5054958642346496556L;

		public MongoDBServerNotFound(String message) {
			super(message);
		}
	}
}
