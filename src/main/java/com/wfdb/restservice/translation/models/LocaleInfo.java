package com.wfdb.restservice.translation.models;

import com.opencsv.bean.CsvBindByName;
import com.wfdb.restservice.utils.LanguageUtils;

public class LocaleInfo {

	@CsvBindByName
	private String name;

	@CsvBindByName
	private String language;

	@CsvBindByName
	private String region;

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

	public String getLocaleCode() {
		return LanguageUtils.getLocaleCode(language, region);
	}

	@Override
	public String toString() {
		return "LocaleInfo [name=" + name + ", language=" + language + ", region=" + region + "]";
	}
}
