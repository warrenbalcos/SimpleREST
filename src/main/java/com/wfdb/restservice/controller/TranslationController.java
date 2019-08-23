package com.wfdb.restservice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfdb.restservice.response.LocaleRepoResponse;
import com.wfdb.restservice.response.LocalesResponse;
import com.wfdb.restservice.translation.TranslationService;
import com.wfdb.restservice.translation.models.LocaleInfo;
import com.wfdb.restservice.translation.models.TranslationDict;

@RestController
public class TranslationController {

	@RequestMapping(path = "/translations")
	public List<LocalesResponse> getAvailableLanguages() {
		List<LocalesResponse> locales = new ArrayList<>();
		HashMap<String, TranslationDict> data = TranslationService.getInstance().getTranslationDictionary();
		LocaleInfo localeInfo;
		for (TranslationDict value : data.values()) {
			localeInfo = value.getLocaleInfo();
			locales.add(new LocalesResponse(localeInfo.getName(), localeInfo.getLanguage(), localeInfo.getRegion()));
		}
		return locales;
	}

	@RequestMapping(path = "/translation")
	public LocaleRepoResponse getTranslations(
			@RequestParam(value = "language") String language,
			@RequestParam(value = "region") String region) {
		TranslationDict result = TranslationService.getInstance().findTranslation(language, region);
		if (result != null) {
			LocaleInfo localeInfo = result.getLocaleInfo();
			return new LocaleRepoResponse(localeInfo.getName(), localeInfo.getLanguage(), localeInfo.getRegion(),
					result.getEntries());
		}
		return null;
	}

}
