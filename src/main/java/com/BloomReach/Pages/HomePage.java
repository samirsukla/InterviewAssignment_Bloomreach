package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.BloomReach.config.PropertiesFile;

public class HomePage extends LoginPage {
	public Properties props;
	public WebDriver driver;
	WebDriverWait wait;
	

	public HomePage(WebDriver driver) throws Exception {
		super(driver);
		props = PropertiesFile.prop;
		int time = 45;
		wait = new WebDriverWait(driver, time);
		PropertiesFile.readHomePagePropertiesFile();
		PropertiesFile.readContentPropertiesFile();
	}
	
	//Expand the User Menu
	public boolean expandUserMenu() {
		super.clickOnElement(props.getProperty("expandIcon"));
		return true;
	}
	
	//Click on Content Icon
	public boolean clickContentIcon() {
		//WebElement contentIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((props.getProperty("contentIcon")))));
		try {
			super.clickOnElement(props.getProperty("contentIcon"));
			//driver.switchTo().frame(1);
			boolean flag=super.checkVisibility(props.getProperty("contentPageHeader"));
			
			return flag;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	//Collapse User Menu
	public boolean collapseUserMenu() {
		super.clickOnElement(props.getProperty("expandIcon"));
		return true;
	}
	
	
	
}
