package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.BloomReach.config.PropertiesFile;

public class ChannelPage extends ContentPage {
	public Properties props;
	public WebDriver driver;
	WebDriverWait wait;

	public ChannelPage(WebDriver driver) throws Exception {
		super(driver);
		props = PropertiesFile.prop;
		int time = 120;
		wait = new WebDriverWait(driver, time);
		PropertiesFile.readContentPropertiesFile();
		PropertiesFile.readChannelPropertiesFile();
	}
	
	//Check If the Changes are reflected in the blog
	public boolean checkTheUpdatedSummary() {
		String fullText = super.getTextFromLabel(props.getProperty("summarydetails"));
		if(fullText.contains(props.getProperty("editText"))) {
			return true;
		}
		else {
			return false;
		}
	}
}
