package com.wfdb.restservice.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CSVUtils {

	public static HashMap<String, String> read2ColumnCsv(String filePath)
			throws FileNotFoundException, IllegalStateException, IOException {
		HashMap<String, String> result = new HashMap<String, String>();
		BufferedReader csvReader = new BufferedReader(new FileReader(filePath));
		String row;
		while ((row = csvReader.readLine()) != null) {
			String[] data = row.split(",");
			result.put(data[0], data[1]);
		}
		csvReader.close();
		return result;
	}

}
