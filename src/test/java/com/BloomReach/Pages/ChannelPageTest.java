package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.BloomReach.Utility.BrowserSetup;
import com.BloomReach.config.PropertiesFile;

public class ChannelPageTest extends BrowserSetup {
	public WebDriver driver;
    public static Properties props;
    public ChannelPage channel;
    
    @BeforeSuite
    public void setUpChannelPage() throws Exception{
        driver = getDriver();
        channel = new ChannelPage(driver);
        props = PropertiesFile.prop;
    }
    
    //verify the updated content in the channel page
    @Test(priority = 101, enabled = true)
   	public void verifyClickingUKChannel()
   	{
       	boolean flag = channel.checkTheUpdatedSummary();
      	Assert.assertTrue(flag, "Summary is not displaying with updated Content");
   		
   	}
}
