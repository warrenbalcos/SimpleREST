package com.wfdb.restservice.translation;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.wfdb.restservice.translation.models.LocaleInfo;
import com.wfdb.restservice.translation.models.TranslationDict;

class TranslationTests {

	@Test
	void testCsvLoad() {
		HashMap<String, TranslationDict> translationDictionary = TranslationService.getInstance()
				.getTranslationDictionary();
		assertTrue(!translationDictionary.isEmpty());
	}

	@Test
	void testSpecificLanguageLoaded() {
		TranslationDict translation = TranslationService.getInstance().getTranslation("en", "us");
		System.out.println(translation);
		LocaleInfo localeInfo = translation.getLocaleInfo();
		assertEquals("en", localeInfo.getLanguage());
		assertEquals("us", localeInfo.getRegion());
	}
	
}
