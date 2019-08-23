package com.wfdb.restservice.utils;

public class LanguageUtils {

	public static String getLocaleCode(String language, String region) {
		return language + "-" + region;
	}

}
