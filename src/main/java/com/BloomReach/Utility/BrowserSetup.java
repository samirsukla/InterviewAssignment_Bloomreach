package com.BloomReach.Utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
//import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowserSetup {
	public static WebDriver driver;
	 static String chromepath = new File("chromedriver.exe").getAbsolutePath();
	 static String firefoxpath = new File("geckodriver.exe").getAbsolutePath();

	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String url) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(url);
			break;
		case "firefox":
			driver = initFirefoxDriver(url);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Chrome as browser of choice..");
			driver = initChromeDriver(url);
		}
	}

	private static WebDriver initChromeDriver(String url) {
		System.out.println("Launching google chrome with new profile..");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", chromepath);
       // WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
		driver.navigate().to(url);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String url) {
		System.out.println("Launching Firefox browser..");
		System.setProperty("webdriver.gecko.driver", firefoxpath);
		//WebDriverManager.firefoxdriver().setup();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(url);
		return driver;
	}

	@Parameters({"browserType","url"})
	@BeforeSuite
	public void initializeTestBaseSetup(String browserType, String url) {
		setDriver(browserType, url);
	}

	@AfterSuite
	public void tearDown() throws Exception {

		driver.quit();
	}
}
