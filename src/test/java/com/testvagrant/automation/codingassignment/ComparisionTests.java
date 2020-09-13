package com.testvagrant.automation.codingassignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testvagrant.automation.codingassignment.api.WeatherAPI;
import com.testvagrant.automation.codingassignment.base.ApiTestBase;
import com.testvagrant.automation.codingassignment.base.WebTestBase;
import com.testvagrant.automation.codingassignment.utils.Comparator;
import com.testvagrant.automation.codingassignment.utils.ServiceFactory;
import com.testvagrant.automation.codingassignment.utils.TestProperties;
import com.testvagrant.automation.codingassignment.webpages.HomePage;
import com.testvagrant.automation.codingassignment.webpages.WeatherPage;

import io.restassured.response.Response;

/**
 * Test class for comparison test cases
 *
 */
public class ComparisionTests extends WebTestBase{

	
	@Test
 	public void compareTemperatureFromTwoSources()
     {
    	HomePage homePage = new HomePage(driver);
    	WeatherPage weatherPage = new WeatherPage(driver);
    	ServiceFactory serviceFactory = new ServiceFactory();
    	WeatherAPI weatherAPI = new WeatherAPI();
    	
    	String webURL = TestProperties.getProperty("WebURL");
    	String cityName = TestProperties.getProperty("CityName");
     	
     	
    	homePage.openURL(webURL)
			.closePopUpNotification()
			.navigateToWeather();
     	
    	if(weatherPage.pageLoadCheck())
    	{	
    		weatherPage.searchCity(cityName);    		
    		weatherPage.fetchDetailsFromMap(cityName);
    	}
    	else
    	{
    		extentTest.fail("Weather page is not displayed");
    		Assert.fail();
    	}
     	
    	
    	Map<String, String> params = new HashMap<String, String>();
    	Map<String, String> headers = new HashMap<String, String>();
    	
    	params.put("q", TestProperties.getProperty("CityName"));
    	params.put("appid", TestProperties.getProperty("APIKey"));
    	params.put("units", "metric");
    	
    	Response response = serviceFactory.getAPIResponseGET(TestProperties.getProperty("Endpoint"), params, headers);
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(statusCode, 200);

    	weatherAPI.getCityWeatherDetails(response);
    	
		if(Comparator.compareTemperature("TemperatureInC", 
				weatherPage.getCityWeatherDetails(), weatherAPI.getCityWeatherDetails(), false))
				{
				extentTest.pass("Temperature from sources are matching");
				}
		else
		{
			extentTest.fail("Temperature from sources are not matching");
			Assert.fail();
		}
			
    	
     }
	
	@Test
 	public void compareTemperatureFromTwoSourcesWithVariance()
     {
    	HomePage homePage = new HomePage(driver);
    	WeatherPage weatherPage = new WeatherPage(driver);
    	ServiceFactory serviceFactory = new ServiceFactory();
    	WeatherAPI weatherAPI = new WeatherAPI();
    	
    	String webURL = TestProperties.getProperty("WebURL");
    	String cityName = TestProperties.getProperty("CityName");
     	
     	
    	homePage.openURL(webURL)
			.closePopUpNotification()
			.navigateToWeather();
     	
    	if(weatherPage.pageLoadCheck())
    	{	
    		weatherPage.searchCity(cityName);    		
    		weatherPage.fetchDetailsFromMap(cityName);
    	}
    	else
    	{
    		extentTest.fail("Weather page is not displayed");
    		Assert.fail();
    	}
    		
 
    	Map<String, String> params = new HashMap<String, String>();
    	Map<String, String> headers = new HashMap<String, String>();
    	
    	params.put("q", TestProperties.getProperty("CityName"));
    	params.put("appid", TestProperties.getProperty("APIKey"));
    	params.put("units", "metric");
    	
    	Response response = serviceFactory.getAPIResponseGET(TestProperties.getProperty("Endpoint"), params, headers);
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(statusCode, 200);

    	weatherAPI.getCityWeatherDetails(response);
    	
		if(Comparator.compareTemperature("TemperatureInC", 
				weatherPage.getCityWeatherDetails(), weatherAPI.getCityWeatherDetails(), true))
				{
				extentTest.pass("Temperature from sources are matching");
				}
		else
		{
			extentTest.fail("Temperature from sources are not matching");
			Assert.fail();
		}

     }
	
	@Test
 	public void compareHumidityFromTwoSourcesWithVariance()
     {
    	HomePage homePage = new HomePage(driver);
    	WeatherPage weatherPage = new WeatherPage(driver);
    	ServiceFactory serviceFactory = new ServiceFactory();
    	WeatherAPI weatherAPI = new WeatherAPI();
    	
    	String webURL = TestProperties.getProperty("WebURL");
    	String cityName = TestProperties.getProperty("CityName");
     	
     	
    	homePage.openURL(webURL)
			.closePopUpNotification()
			.navigateToWeather();
     	
    	if(weatherPage.pageLoadCheck())
    	{	
    		weatherPage.searchCity(cityName);    		
    		weatherPage.fetchDetailsFromMap(cityName);
    	}
    	else
    	{
    		extentTest.fail("Weather page is not displayed");
    		Assert.fail();
    	}
    		
 
    	Map<String, String> params = new HashMap<String, String>();
    	Map<String, String> headers = new HashMap<String, String>();
    	
    	params.put("q", TestProperties.getProperty("CityName"));
    	params.put("appid", TestProperties.getProperty("APIKey"));
    	params.put("units", "metric");
    	
    	Response response = serviceFactory.getAPIResponseGET(TestProperties.getProperty("Endpoint"), params, headers);
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(statusCode, 200);

    	weatherAPI.getCityWeatherDetails(response);
    	
		if(Comparator.compareHumidity("Humidity", 
				weatherPage.getCityWeatherDetails(), weatherAPI.getCityWeatherDetails(), true))
				{
					extentTest.pass("Humidity from sources are matching");
				}
		else
		{
			extentTest.fail("Humidity from sources are not matching");
			Assert.fail();
		}

     }

}
