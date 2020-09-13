package com.testvagrant.automation.codingassignment.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

public class ApiTestBase extends TestBase{
	protected ExtentTest extentTest;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp(ITestContext iTestContext) {
		String testName=iTestContext.getCurrentXmlTest().getName();
		extentTest = extentReport.createTest(testName);
		extentTest.info("Starting test:  "+ testName);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		extentTest.pass("Test completed sussessfully.");
	}

}
