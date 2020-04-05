package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.BloomReach.Utility.BrowserSetup;
import com.BloomReach.config.PropertiesFile;

public class HomePageTest extends BrowserSetup{
	public WebDriver driver;
    public static Properties props;
    public HomePage home;
    
    @BeforeSuite
    public void setUpHomePage() throws Exception{
        driver = getDriver();
        home = new HomePage(driver);
        props = PropertiesFile.prop;
    }
    
    //Expand the User Menu
    @Test(priority = 21, enabled = true)
   	public void verifyExpandingUserMenu()
   	{
       	boolean flag = home.expandUserMenu();
      		Assert.assertTrue(flag, "User Menu is not Expanded");
   		
   	}
    //Verify content page loaded or not
    @Test(priority = 23, enabled = true)
	public void verifyClickingContentIcon()
	{
    	boolean flag = home.clickContentIcon();
   		Assert.assertTrue(flag, "Content Page is not loaded");
		
	}
    
  //Collapse the User Menu
    @Test(priority = 25, enabled = true)
   	public void verifyCollapseingUserMenu()
   	{
       	boolean flag = home.collapseUserMenu();
      		Assert.assertTrue(flag, "User Menu is not Collapsed.");
   		
   	}
    
}
