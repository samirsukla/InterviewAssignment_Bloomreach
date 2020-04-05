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
	public void verifyBloomReachTittle(String url)
	{
		Assert.assertEquals(login.verifyBRPageTittle(url), props.getProperty("loginpagetitle"));
		
	}
    //Verify Login Credentials
    @Test(priority = 3, enabled = true)
	public void verifyLoginCredentials()
	{
		boolean flag = login.enterLoginCredentials();
		Assert.assertTrue(flag, "Login Credentials are not entered properly");	
	}
    
    //Click Login Button
    @Test(priority = 5, enabled = true)
	public void verifyLoginButton()
	{
		boolean flag = login.clickLoginButton();
		Assert.assertTrue(flag, "Login button is not clickable");	
	}
    
    //Verify If Homepage is Loaded
    @Test(priority = 7, enabled = true)
   	public void verifyHomePageLoaded()
   	{
   		boolean flag = login.checkHomePageLoaded();
   		Assert.assertTrue(flag, "HomePage is not loaded");	
   	}
    
}
