package com.wfdb.restservice.response;

public class LocalesResponse {
	private String name;
	private String language;
	private String region;

	public LocalesResponse(String name, String language, String region) {
		super();
		this.name = name;
		this.language = language;
		this.region = region;
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

	@Override
	public String toString() {
		return "LocalesResponse [name=" + name + ", language=" + language + ", region=" + region + "]";
	}
}
