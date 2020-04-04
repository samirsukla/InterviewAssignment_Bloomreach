package com.BloomReach.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesFile {

	public static Properties prop = new Properties();

	public static void readLoginPropertiesFile() throws Exception {

		String path = new File("src\\main\\java\\com\\BloomReach\\config\\loginpagedata.properties").getAbsolutePath();
		prop.load(new InputStreamReader(new FileInputStream(path), "UTF8"));

	}

	public static void readHomePagePropertiesFile() throws Exception {

		String path = new File("src\\main\\java\\com\\BloomReach\\config\\homepagedata.properties").getAbsolutePath();
		prop.load(new InputStreamReader(new FileInputStream(path), "UTF8"));

	}

	public static void readContentPropertiesFile() throws Exception {

		String path = new File("src\\main\\java\\com\\BloomReach\\config\\contentpagedata.properties")
				.getAbsolutePath();
		prop.load(new InputStreamReader(new FileInputStream(path), "UTF8"));

	}

	public static void readChannelPropertiesFile() throws Exception {

		String path = new File("src\\main\\java\\com\\BloomReach\\config\\channelpagedata.properties")
				.getAbsolutePath();
		prop.load(new InputStreamReader(new FileInputStream(path), "UTF8"));

	}
}
