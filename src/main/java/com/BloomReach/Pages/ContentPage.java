package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.BloomReach.config.PropertiesFile;

public class ContentPage extends HomePage {
	public Properties props;
	public WebDriver driver;
	WebDriverWait wait;
	
	public ContentPage(WebDriver driver) throws Exception {
		super(driver);
		props = PropertiesFile.prop;
		int time = 150;
		wait = new WebDriverWait(driver, time);
		PropertiesFile.readContentPropertiesFile();
	}
	
}
