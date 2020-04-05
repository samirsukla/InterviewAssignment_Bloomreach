package com.BloomReach.Pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.BloomReach.Utility.BrowserSetup;
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
    
    //Verify Clicking on UK Channel Link
    @Test(priority = 41, enabled = true)
   	public void verifyClickingUKChannel()
   	{
       	boolean flag = content.clickUKHippoChannelLink();
      	Assert.assertTrue(flag, "UK Hippo Green Channel is not opened");
   		
   	}
    //Verify Clicking on News Folder
    @Test(priority = 43, enabled = true)
   	public void verifyClickingNewsFolder()
   	{
       	boolean flag = content.clickOnNewsFolder();
      	Assert.assertTrue(flag, "New Folder is not opened");
   		
   	}
    //Verify Clicking on Year Folder
    @Test(priority = 45, enabled = true)
   	public void verifyClickingYearFolder()
   	{
       	boolean flag = content.clickOnYearFolder();
      	Assert.assertTrue(flag, "Year Folder is not opened");
   		
   	}
    //Verify Clicking on SubFolder
    @Test(priority = 47, enabled = true)
   	public void verifyClickingSubFolder()
   	{
       	boolean flag = content.clickOnSubFolder();
      	Assert.assertTrue(flag, "Sub Folder is not opened");
   		
   	}
    //Verify Clicking on Document
    @Test(priority = 49, enabled = true)
   	public void verifyClickingDocument()
   	{
       	boolean flag = content.clickOnDocumentLink();
      	Assert.assertTrue(flag, "Document is not Clicked");
   		
   	}
    //Verify If the Same document is opened or not
    @Test(priority = 51, enabled = true)
   	public void verifyDocumentName()
   	{
       	boolean flag = content.compareTheDocumentTitle();
      	Assert.assertTrue(flag, "Opened Document title is not same as the clicked Document");
   		
   	}
    //Click on Edit Button
    @Test(priority = 53, enabled = true)
	public void verifyClickingEditButton()
	{
    	boolean flag = content.clickEditButton();
   		Assert.assertTrue(flag, "Edit Button is not Clicked");
		
	}
    //Edit the Summary Field
    @Test(priority = 55, enabled = true)
	public void verifyEditingSummaryField()
	{
    	boolean flag = content.editSummaryData();
   		Assert.assertTrue(flag, "Summary Data is not editable");
		
	}
    //Click on Done Button
    @Test(priority = 57, enabled = true)
   	public void verifyClickingDoneButton()
   	{
       	boolean flag = content.clickDoneButton();
      	Assert.assertTrue(flag, "Done Button is not Clicked");
   		
   	}
    //Click on Publication Link
    @Test(priority = 59, enabled = true)
   	public void verifyClickingPublicationButton()
   	{
       	boolean flag = content.clickPublicationButton();
      	Assert.assertTrue(flag, "Publication Link is not Clicked");
   		
   	}
    //Click on Publish Link
    @Test(priority = 61, enabled = true)
   	public void verifyClickingPublishButton()
   	{
       	boolean flag = content.publishDocument();
      	Assert.assertTrue(flag, "Document is not published");
   		
   	}
    //Click on View Link
    @Test(priority = 63, enabled = true)
   	public void verifyClickingViewButton() throws InterruptedException
   	{
       	boolean flag = content.clickViewButton();
      	Assert.assertTrue(flag, "View Button is not Clicked");
   		
   	}
    
    //Click on Channel Link
    @Test(priority = 65, enabled = true)
   	public void verifyClickingChannelLink()
   	{
       	boolean flag = content.clickChannelLink();
      	Assert.assertTrue(flag, "Selected Channel is not opened.");
   		
   	}
    
   
}
