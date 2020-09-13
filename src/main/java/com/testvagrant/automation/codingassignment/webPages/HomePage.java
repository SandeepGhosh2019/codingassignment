package com.testvagrant.automation.codingassignment.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 *
 */
public class HomePage extends BasePageObject{
	
	By popUpClose = By.xpath("//a[contains(@onclick, 'ndtvCloseThis')]");	
	By headerEllipsis = By.id("h_sub_menu");	
	By weatherLink = By.linkText("WEATHER");
	By cityList = By.xpath("//*[@id='messages']/div[*]/label");
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage openURL(String url)
	{
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
