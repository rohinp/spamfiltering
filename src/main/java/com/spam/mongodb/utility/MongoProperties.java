package com.spam.mongodb.utility;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MongoProperties {
	private static final String BUNDLE_NAME = "com.spam.mongodb.resources.mongodb"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private MongoProperties() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
