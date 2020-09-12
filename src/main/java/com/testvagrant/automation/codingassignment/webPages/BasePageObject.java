package com.testvagrant.automation.codingassignment.webPages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {
	
	protected WebDriver driver;
	protected Logger logger;

	public BasePageObject(WebDriver driver, Logger logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	protected void openUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	protected void waiting(long ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	protected boolean isElementPresent(int timeoutInSeconds, By byElement) {
		boolean foundElement = false;
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		try {
				wait.until(ExpectedConditions.elementToBeClickable(byElement));
				foundElement = true;
			}catch (TimeoutException te) {
				foundElement = false;
			}
			
			return foundElement;
	}

}
