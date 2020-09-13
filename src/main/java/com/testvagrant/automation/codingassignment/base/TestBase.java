package com.testvagrant.automation.codingassignment.base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * Initializes reporting and other resources for whole suite
 *
 */
public class TestBase {
	
	public static ExtentReports extentReport;
	
	@SuppressWarnings("deprecation")
	
	@BeforeSuite()
	public void setupExtentReport() {
		ExtentHtmlReporter reportType = new ExtentHtmlReporter("test-output\\ExtentReports\\ExtentReport.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(reportType );
	}
		
	@AfterSuite
	public void flushExtentReport() {
		extentReport.flush();
	}

}
