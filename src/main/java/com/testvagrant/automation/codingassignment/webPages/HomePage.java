package com.testvagrant.automation.codingassignment.webPages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePageObject{
	
	By popUpClose = By.xpath("//a[contains(@onclick, 'ndtvCloseThis')]");	
	By headerEllipsis = By.id("h_sub_menu");	
	By weatherLink = By.linkText("WEATHER");
	By cityList = By.xpath("//*[@id='messages']/div[*]/label");
	
	public HomePage(WebDriver driver, Logger logger) {
		super(driver, logger);
	}
	
	public HomePage openURL(String url)
	{
		logger.info("Open page URL: "+ url);
		openUrl(url);
		
		return this;
	}
	
	public HomePage closePopUpNotification()
	{
		if(isElementPresent(10, popUpClose))
			driver.findElement(popUpClose).click();
		return this;
	}
	
	public void navigateToWeather()
	{
		driver.findElement(headerEllipsis).click();
		waiting(500);
		driver.findElement(weatherLink).click();			
	}

}
