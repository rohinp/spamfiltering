package com.spamfilter.utility;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class StopWord {
	private static final String BUNDLE_NAME = "com.spamfilter.utility.stopwords"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private StopWord() {
	}

	public static String getStopWords(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
