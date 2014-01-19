package com.mongodb.factory;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import com.spam.mongodb.utility.MongoProperties;

public class MongoFactory {

	private static String dbname;
	private static String collection;
	private static String server;
	private static int serverPort;
	private static Mongo mongo;
	private static DB database;

	public static DBCollection getcollection() {
		connectDB();
		return database.getCollection(collection);
	}

	private static void connectDB() {
		createMongoConnection();
		database = mongo.getDB(dbname);
	}

	private static void createMongoConnection() {
		try {
			initMongoConfig();
			if (mongo == null)
				mongo = new Mongo(server, serverPort);
		} catch (UnknownHostException e) {
			throw new MongoDBServerNotFound(e.getMessage());
		}
	}

	private static void initMongoConfig() {
		dbname = MongoProperties.getString("dbname");
		collection = MongoProperties.getString("collection");
		server = MongoProperties.getString("mongoserver");
		serverPort = Integer.parseInt(MongoProperties.getString("mongoport"));
	}

	public static class MongoDBServerNotFound extends RuntimeException {
		private static final long serialVersionUID = -5054958642346496556L;

		public MongoDBServerNotFound(String message) {
			super(message);
		}
	}
}
