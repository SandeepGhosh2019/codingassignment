package com.testvagrant.automation.codingassignment.webpages;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base class for Web application page classes
 *
 */
public class BasePageObject {
	
	protected WebDriver driver;

	public BasePageObject(WebDriver driver) {
		this.driver = driver;
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
