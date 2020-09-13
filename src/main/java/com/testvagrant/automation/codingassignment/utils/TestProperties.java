package com.testvagrant.automation.codingassignment.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Reads properties file
 *
 */
public class TestProperties {
	
	private static Properties properties = new Properties();

	static {
		try {
			
				FileInputStream in = new FileInputStream("Config.properties");
				properties.load(in);
				in.close();

		} catch (IOException io) {
			System.out.println("Error in opening properties file");
			io.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		String value = null;
		if (System.getProperty(key) != null) {
			value = System.getProperty(key);
		} else {
			value = properties.getProperty(key).trim();
		}
		return value;
	}

}
