package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.BloomReach.config.PropertiesFile;

public class LoginPage {
	public Properties props;
	public WebDriver driver;
	WebDriverWait wait;
	public LoginPage(WebDriver driver) throws Exception {
		this.driver = driver;
		props = PropertiesFile.prop;
		int time = 30;
		wait = new WebDriverWait(driver, time);
		PropertiesFile.readLoginPropertiesFile();
	}
	
	// Check title of the Login Page
		public String verifyBRPageTittle(String url) {
			
			try {
				return driver.getTitle();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
				
			}
			
		}
}
