package com.testvagrant.automation.codingassignment.base;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;
import com.testvagrant.automation.codingassignment.utils.BrowserDriverFactory;
import com.testvagrant.automation.codingassignment.utils.TestProperties;

public class WebTestBase extends TestBase {
	protected WebDriver driver;
	protected ExtentTest extentTest;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp(ITestContext iTestContext) {
		String testName=iTestContext.getCurrentXmlTest().getName();
		extentTest = extentReport.createTest(testName);
		extentTest.info("Starting test:  "+ testName);
		
		String browserType=TestProperties.getProperty("Browser");
		BrowserDriverFactory browserDriverFactory=new BrowserDriverFactory();
		driver=browserDriverFactory.getDriver(browserType);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		//Closing browser
		driver.quit();
		extentTest.pass("Test completed sussessfully.");
	}
}
