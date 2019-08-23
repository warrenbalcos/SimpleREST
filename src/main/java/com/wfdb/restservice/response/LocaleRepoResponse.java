package com.wfdb.restservice.response;

import java.util.HashMap;

public class LocaleRepoResponse {

	private String name;
	private String language;
	private String region;
	private HashMap<String, String> entries;

	public LocaleRepoResponse(String name, String language, String region, HashMap<String, String> entries) {
		super();
		this.name = name;
		this.language = language;
		this.region = region;
		this.entries = entries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public HashMap<String, String> getEntries() {
		return entries;
	}

	public void setEntries(HashMap<String, String> entries) {
		this.entries = entries;
	}

	@Override
	public String toString() {
		return "LocaleRepoResponse [name=" + name + ", language=" + language + ", region=" + region + ", entries="
				+ entries + "]";
	}

}
