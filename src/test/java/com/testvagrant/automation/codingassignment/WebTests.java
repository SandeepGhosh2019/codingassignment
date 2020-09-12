package com.testvagrant.automation.codingassignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testvagrant.automation.codingassignment.base.WebTestBase;
import com.testvagrant.automation.codingassignment.utils.TestProperties;
import com.testvagrant.automation.codingassignment.webPages.HomePage;
import com.testvagrant.automation.codingassignment.webPages.WeatherPage;

public class WebTests extends WebTestBase{

	
    @Test
	public void searchWeatherOfACityInWebsite()
    {
    	HomePage homePage = new HomePage(driver, logger);
    	WeatherPage weatherPage = new WeatherPage(driver, logger);
    	
    	String webURL = TestProperties.getProperty("WebURL");
    	String cityName = TestProperties.getProperty("CityName");
    	
    	
    	homePage.openURL(webURL)
    		.closePopUpNotification()
    		.navigateToWeather();
    	
    	if(weatherPage.pageLoadCheck())
    	{	
    		weatherPage.searchCity(cityName);    		
    		weatherPage.findCityInMap(cityName);
    	}
    	else
    		extentTest.fail("Weather page is not displayed");

    }
    
    @Test
 	public void validateCityWeatherDetailsIsPresentInMap()
     {
    	HomePage homePage = new HomePage(driver, logger);
    	WeatherPage weatherPage = new WeatherPage(driver, logger);
    	
    	String webURL = TestProperties.getProperty("WebURL");
    	String cityName = TestProperties.getProperty("CityName");
     	
    	homePage.openURL(webURL)
    		.closePopUpNotification()
    		.navigateToWeather();
     	
     	if(weatherPage.pageLoadCheck())
     	{
     		weatherPage.searchCity(cityName);
     		if(weatherPage.fetchDetailsFromMap(cityName))
     			extentTest.info("City Weather details displayed on Map");
     		else
     			extentTest.fail("Weather details not displayed");
     	}
    	else
    		extentTest.fail("Weather page is not displayed");

     }

}
