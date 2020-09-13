package com.testvagrant.automation.codingassignment.webpages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page class for Weather page of news website
 *
 */
public class WeatherPage extends BasePageObject{
	
	Map<String, Object>  cityWeatherDetails;
	
	By searchTextBox = By.id("searchBox");

	By tempInC = By.xpath("preceding-sibling::div/span[@class = 'tempRedText']");
	By tempInF = By.xpath("preceding-sibling::div/span[@class = 'tempWhiteText']");
	By weatherDetails = By.className("leaflet-popup-content-wrapper");
	By temperatureInDegree = By.xpath("div/div/span[4]/b");
	By humidity = By.xpath("div/div/span[3]/b");
	
	
	public WeatherPage(WebDriver driver) {
		super(driver);
	}
	
	public Map<String, Object> getCityWeatherDetails() {
		return cityWeatherDetails;
	}
	
	public Boolean pageLoadCheck()
	{
		if(isElementPresent(10, searchTextBox))
			return true;
		else
			return false;
		
	}
	
	public void searchCity(String cityName)
	{
		driver.findElement(searchTextBox).sendKeys(cityName);
		
		By cityNameCheckBox = By.id(cityName);
		
		if(isElementPresent(5, cityNameCheckBox))
		{
			String checkStatus = driver.findElement(cityNameCheckBox).getAttribute("class");
			if(!checkStatus.equals("defaultChecked"))
				driver.findElement(cityNameCheckBox).click();
		}
	
	}
	

	
	public void findCityInMap(String cityName)
	{
		By cityNameInMap = By.xpath("//div[@class='cityText' and text() = '" + cityName + "']");
		
		if(driver.findElement(cityNameInMap).isDisplayed())
		{
			String temperatureInC = driver.findElement(cityNameInMap).findElement(tempInC).getText();
			temperatureInC = temperatureInC.replaceAll("[^\\d]", "");
			System.out.println(temperatureInC + "\u00B0" + "C" );
			
			String temperatureInF = driver.findElement(cityNameInMap).findElement(tempInF).getText();
			temperatureInF = temperatureInF.replaceAll("[^\\d]", "");
			System.out.println(temperatureInF + "\u00B0" + "F" );
		}
	}
	
	
	public Boolean fetchDetailsFromMap(String cityName)
	{
		cityWeatherDetails = new HashMap<String, Object>();		
		cityWeatherDetails.put("CityName", cityName);
		
		String temperatureText = null;
		String humidityText = null;
		By cityNameInMap = By.xpath("//div[@class='cityText' and text() = '" + cityName + "']");
		
		
		if(isElementPresent(2, cityNameInMap))
		{
			System.out.println("City is displayed in Map");
			driver.findElement(cityNameInMap).click();
			if(isElementPresent(2, weatherDetails))
			{			
				temperatureText = driver.findElement(weatherDetails)
						.findElement(temperatureInDegree).getText();
				
				humidityText = driver.findElement(weatherDetails)
						.findElement(humidity).getText();

				temperatureText = temperatureText.replaceAll("[^\\d]", "");
				cityWeatherDetails.put("TemperatureInC", temperatureText);
				
				humidityText = humidityText.replaceAll("[^\\d]", "");
				cityWeatherDetails.put("Humidity", humidityText);	
				return true;
			}			
			else
			{
				return false;
			}
				
		}
		else
		{
			System.out.println("Couldn't find City " + cityName + " in Map");
			return false;
		}
			
	}

}
