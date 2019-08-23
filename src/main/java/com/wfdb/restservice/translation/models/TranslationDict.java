package com.wfdb.restservice.translation.models;

import java.util.HashMap;

public class TranslationDict {

	private LocaleInfo localeInfo;

	private HashMap<String, String> entries;

	public TranslationDict(LocaleInfo localeInfo) {
		super();
		this.localeInfo = localeInfo;
	}

	public TranslationDict(LocaleInfo localeInfo, HashMap<String, String> entries) {
		super();
		this.localeInfo = localeInfo;
		this.entries = entries;
	}

	public LocaleInfo getLocaleInfo() {
		return localeInfo;
	}

	public void setLocaleInfo(LocaleInfo localeInfo) {
		this.localeInfo = localeInfo;
	}

	public HashMap<String, String> getEntries() {
		return entries;
	}

	public void setEntries(HashMap<String, String> entries) {
		this.entries = entries;
	}

	@Override
	public String toString() {
		return "TranslationDict [localeInfo=" + localeInfo + ", entries=" + entries + "]";
	}

}
