package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.BloomReach.config.PropertiesFile;

public class HomePage extends LoginPage {
	public Properties props;
	public WebDriver driver;
	WebDriverWait wait;
	public static String loginCredentail;
	

	public HomePage(WebDriver driver) throws Exception {
		super(driver);
		props = PropertiesFile.prop;
		int time = 150;
		wait = new WebDriverWait(driver, time);
		PropertiesFile.readHomePagePropertiesFile();
		PropertiesFile.readContentPropertiesFile();
	}
	
	//Click on Content Icon
	public boolean clickContentIcon() {
		super.clickUsingAction(props.getProperty("contentIcon"));
		boolean flag=super.checkVisibility("contentPageHeader");
		
		return flag;
	}
	
	
	
}
