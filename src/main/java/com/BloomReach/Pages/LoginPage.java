package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.BloomReach.config.PropertiesFile;

public class LoginPage {
	public Properties props;
	public WebDriver driver;
	WebDriverWait wait;
	public static String loginCredentail;
	

	public LoginPage(WebDriver driver) throws Exception {
		this.driver = driver;
		props = PropertiesFile.prop;
		int time = 150;
		wait = new WebDriverWait(driver, time);
		PropertiesFile.readLoginPropertiesFile();
	}

	// Check title of the Login Page
	public String verifyBRPageTittle(String url) {
		return driver.getTitle();

	}
	
	//Fetch the Login Credentials
	public String getLoginCredentials() {
		String fullText = this.getTextFromLabel(props.getProperty("loginCredential"));
		String[] credentials = fullText.split("-");
		loginCredentail = credentials[0].trim();
		return loginCredentail;
		
	}
	
	//Enter Login Credentials
	public boolean enterLoginCredentials() {
		try {
			String value = this.getLoginCredentials();
			this.enterDatainInputBox(props.getProperty("usernameField"),value);
			this.enterDatainInputBox(props.getProperty("passwordField"),value);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	//Click on Login Button
	public boolean clickLoginButton() {
		this.clickOnElement(props.getProperty("loginButton"));
		return true;
	}
	
	//Check Homepage Loaded or not
	public boolean checkHomePageLoaded() {
		boolean flag = this.checkVisibility(props.getProperty("homepage"));
		return flag;
	}
	
	//==================================== Common Mehods ==========================================
	
	//Fetch Text from any Label
	public String getTextFromLabel(String path) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		return element.getText().trim();
		
	}
	
	//Enter data in Text Box
	public void enterDatainInputBox(String path, String valueToEnter) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		element.click();
		element.clear();
		element.sendKeys(valueToEnter);
	}
	
	//Click on any element
	public void clickOnElement(String path) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
		element.click();

	}
	
	//Check Visibility of an element
	public boolean checkVisibility(String path) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
		if(element.isDisplayed()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
