package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.BloomReach.config.PropertiesFile;

public class ContentPageTest extends BrowserSetup {
	public WebDriver driver;
    public static Properties props;
    public ContentPage content;
    
    @BeforeSuite
    public void setUpContentPage() throws Exception{
        driver = getDriver();
        content = new ContentPage(driver);
        props = PropertiesFile.prop;
    }
    
    //Verify content page loaded or not
    @Test(priority = 21, enabled = true)
	public void verifyClickingContentIcon()
	{
    	boolean flag = home.clickContentIcon();
   		Assert.assertTrue(flag, "Content Page is not loaded");
		
	}
}
