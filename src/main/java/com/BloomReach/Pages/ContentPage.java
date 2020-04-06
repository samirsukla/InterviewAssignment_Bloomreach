package com.BloomReach.Pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.BloomReach.config.PropertiesFile;

public class ContentPage extends HomePage {
	public Properties props;
	public WebDriver driver;
	WebDriverWait wait;

	public ContentPage(WebDriver driver) throws Exception {
		super(driver);
		props = PropertiesFile.prop;
		int time = 120;
		wait = new WebDriverWait(driver, time);
		PropertiesFile.readContentPropertiesFile();
		PropertiesFile.readChannelPropertiesFile();
	}

	// Click on UK Channel Link
	public boolean clickUKHippoChannelLink() {
		try {
			switchToFrame(props.getProperty("iframePath"));
			List<WebElement> channels = wait.until(
					ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(props.getProperty("hippogreenLink"))));
			super.clickUsingAction(channels.get(1));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Check Visibility of News Folder and Click on it
	public boolean clickOnNewsFolder() {
		boolean flag1 = super.checkVisibility(props.getProperty("newsFolder"));

		super.clickOnElement(props.getProperty("newsFolder"));

		return flag1 && true;

	}

	// Check Visibility of Year Folder and Click on it
	public boolean clickOnYearFolder() {
		boolean flag1 = super.checkVisibility(props.getProperty("yearFolder"));

		super.clickOnElement(props.getProperty("yearFolder"));

		return flag1 && true;

	}

	// Check Visibility of Sub Folder and Click on it
	public boolean clickOnSubFolder() {
		boolean flag1 = super.checkVisibility(props.getProperty("subFolder"));

		super.clickOnElement(props.getProperty("subFolder"));

		return flag1 && true;

	}

	// Check Visibility of the document and Click on it
	public boolean clickOnDocumentLink() {
		boolean flag1 = super.checkVisibility(props.getProperty("documentLink"));

		super.clickOnElement(props.getProperty("documentLink"));

		return flag1 && true;

	}

	// Check If the Same Document is opened or not
	public boolean compareTheDocumentTitle() {
		String expectedDocName = super.getTextFromLabel(props.getProperty("documentLink"));
		List<WebElement> docHeaders = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(props.getProperty("documentHeader"))));
		String actualDocName = docHeaders.get(0).getText().trim();
		if (actualDocName.equals(expectedDocName)) {
			return true;
		} else {
			return false;
		}

	}

	// Click on Edit Button
	public boolean clickEditButton() {
		boolean flag1 = super.checkVisibility(props.getProperty("editButton"));

		super.clickOnElement(props.getProperty("editButton"));

		return flag1 && true;
	}

	// Edit the Summary Field
	public boolean editSummaryData() {
		super.checkVisibility(props.getProperty("summaryField"));
		super.enterDatainInputBox(props.getProperty("summaryField"), props.getProperty("editText"));
		String fullText = super.getTextFromInputBox(props.getProperty("summaryField"));
		if (fullText.endsWith(props.getProperty("editText"))) {
			return true;
		} else {
			return false;
		}
	}

	// Click on Done Button
	public boolean clickDoneButton() {
		boolean flag1 = super.checkVisibility(props.getProperty("doneButton"));

		super.clickOnElement(props.getProperty("doneButton"));

		return flag1 && true;
	}

	// Click on Publication Button
	public boolean clickPublicationButton() {
		boolean flag1 = super.checkVisibility(props.getProperty("publicationLink"));

		super.clickOnElement(props.getProperty("publicationLink"));

		return flag1 && true;
	}

	// Publish the Document
	public boolean publishDocument() {
		boolean flag1 = super.checkVisibility(props.getProperty("publishLink"));

		super.clickOnElement(props.getProperty("publishLink"));

		return flag1 && true;
	}

	// Click on View Button
	public boolean clickViewButton() throws InterruptedException {
		boolean flag1 = super.checkVisibility(props.getProperty("viewLink"));
		WebElement viewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(props.getProperty("viewLink"))));
		super.clickUsingAction(viewButton);
		Thread.sleep(5000);
		super.clickOnElement(props.getProperty("viewLink"));

		return flag1 && true;
	}

	// Click on Channel Link
	public boolean clickChannelLink() {
		try {
			boolean flag1=false,flag2=false;
			flag1= super.checkVisibility(props.getProperty("channelLink"));

			super.clickOnElement(props.getProperty("channelLink"));

			flag2 = super.checkVisibility(props.getProperty("experiencemanagerPage"));
			return flag1 && flag2;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
