package com.wfdb.restservice.translation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.wfdb.restservice.config.Config;
import com.wfdb.restservice.translation.models.LocaleInfo;
import com.wfdb.restservice.translation.models.TranslationDict;
import com.wfdb.restservice.utils.CSVUtils;
import com.wfdb.restservice.utils.LanguageUtils;

public class TranslationService {

	private static final TranslationService INSTANCE = new TranslationService();

	/**
	 * The loaded translation dictionary from csv translation files
	 * 
	 * key - the locale code (Ex. en-us, zh-cn)
	 */
	private HashMap<String, TranslationDict> translationDictionary;
	private static final byte[] lock = new byte[0];
	private boolean isLoaded;

	private TranslationService() {
		translationDictionary = new HashMap<>();
		isLoaded = false;
	}

	public static synchronized TranslationService getInstance() {
		return INSTANCE;
	}

	public void reload() {
		loadTranslations();
	}

	private void loadTranslations() {
		synchronized (lock) {
			try {
				isLoaded = true;
				translationDictionary.clear();
				File file = new File(Config.TRANSLATION_LOCALES_FILE_PATH);
				FileReader reader = new FileReader(file);
				List<LocaleInfo> result = new CsvToBeanBuilder<LocaleInfo>(reader).withType(LocaleInfo.class).build()
						.parse();
				HashMap<String, String> entries;
				for (LocaleInfo localeInfo : result) {
					try {
						entries = CSVUtils
								.read2ColumnCsv(Config.TRANSLATION_FILE_DIR + localeInfo.getLocaleCode() + ".csv");
						if (!entries.isEmpty()) {
							translationDictionary.put(localeInfo.getLocaleCode(),
									new TranslationDict(localeInfo, entries));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public HashMap<String, TranslationDict> getTranslationDictionary() {
		synchronized (lock) {
			if (!isLoaded) {
				loadTranslations();
			}
			return translationDictionary;
		}
	}

	public TranslationDict getTranslation(String language, String region) {
		synchronized (lock) {
			if (!isLoaded) {
				loadTranslations();
			}
			return translationDictionary.get(LanguageUtils.getLocaleCode(language, region));
		}
	}

	/**
	 * If no exact region is found the first language found will be returned
	 * regardless of region miss match
	 * 
	 * @param language
	 * @param region
	 * @return
	 */
	public TranslationDict findTranslation(String language, String region) {
		synchronized (lock) {
			TranslationDict result = getTranslation(language, region);
			if (result == null) {
				// return the first match based on the language ang ignore the region
				for (String key : translationDictionary.keySet()) {
					if (key.startsWith(language)) {
						return translationDictionary.get(key);
					}
				}
			}
			return result;
		}
	}
}
