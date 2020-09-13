package com.testvagrant.automation.codingassignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testvagrant.automation.codingassignment.api.WeatherAPI;
import com.testvagrant.automation.codingassignment.base.ApiTestBase;
import com.testvagrant.automation.codingassignment.utils.ApiUtilities;
import com.testvagrant.automation.codingassignment.utils.ServiceFactory;
import com.testvagrant.automation.codingassignment.utils.TestProperties;

import io.restassured.response.Response;


/**
 * Test class for API only test cases
 *
 */
public class APITests extends ApiTestBase{
	
    @Test
	public void searchWeatherOfACityAPI()
    {
    	ServiceFactory serviceFactory = new ServiceFactory();
    	WeatherAPI weatherAPI = new WeatherAPI();
    	 
    	
    	Map<String, String> params = new HashMap<String, String>();
    	Map<String, String> headers = new HashMap<String, String>();
    	
    	params.put("q", TestProperties.getProperty("CityName"));
    	params.put("appid", TestProperties.getProperty("APIKey"));
    	params.put("units", "metric");
    	
    	Response response = serviceFactory.getAPIResponseGET(TestProperties.getProperty("Endpoint"), params, headers);
    	int statusCode = response.getStatusCode();
    	Assert.assertEquals(statusCode, 200);
    	
    	ApiUtilities.viewResponseJSON(response);
    	weatherAPI.getCityWeatherDetails(response);
    	
    }
   
}
