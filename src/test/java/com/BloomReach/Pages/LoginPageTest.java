package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.BloomReach.Utility.BrowserSetup;

import com.BloomReach.config.PropertiesFile;

public class LoginPageTest extends BrowserSetup {
	public WebDriver driver;
    public static Properties props;
    public LoginPage login;
    
    @BeforeSuite
    public void setUpLogin() throws Exception{
        driver = getDriver();
        login = new LoginPage(driver);
        props = PropertiesFile.prop;
        PropertiesFile.readLoginPropertiesFile();
    }

	// Verify Title
    @Parameters({"url"})
	@Test(priority = 1, enabled = true)
	public void verifyHumainHealthTittle(String url)
	{
		//String pageUrl = props.getProperty("url");
		Assert.assertEquals(login.verifyBRPageTittle(url), props.getProperty("loginpagetitle"));
		
	}
}
