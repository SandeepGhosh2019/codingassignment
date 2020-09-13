package com.testvagrant.automation.codingassignment.api;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import io.restassured.response.Response;

import static com.testvagrant.automation.codingassignment.utils.ApiUtilities.*;

/**
 * Weather API specific operations
 *
 */
public class WeatherAPI {
	Map<String, Object>  cityWeatherDetails;
	
	public Map<String, Object> getCityWeatherDetails() {
		return cityWeatherDetails;
	}

	public void getCityWeatherDetails(Response response)
	{
		JSONObject jsonObject = new JSONObject(response.asString());
		
		Map<String, Object> cityWeatherResponse = toMap(jsonObject);
		
		@SuppressWarnings("unchecked")
		Map<String, Integer> cityTemperatureDetails = (Map<String, Integer>) cityWeatherResponse.get("main");
		
		cityWeatherDetails = new HashMap<String, Object>();
		
		cityWeatherDetails.put("CityName", cityWeatherResponse.get("name"));
		cityWeatherDetails.put("TemperatureInC", cityTemperatureDetails.get("temp"));
		cityWeatherDetails.put("Pressure", cityTemperatureDetails.get("pressure"));
		cityWeatherDetails.put("Humidity", cityTemperatureDetails.get("humidity"));		

		for(Map.Entry<String, Object> pair : cityWeatherDetails.entrySet())
		{
			System.out.println(pair.getKey() + "  :  " + pair.getValue());
		}
	}
		
}
