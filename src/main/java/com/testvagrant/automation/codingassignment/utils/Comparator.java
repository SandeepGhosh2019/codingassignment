package com.testvagrant.automation.codingassignment.utils;

import java.util.Map;

public class Comparator {
	
	public static Boolean compareAttribute(String key, Map<String, Object> websiteData, Map<String, Object> apiData, Boolean varianceFlag)
	{
		double valueInWebsite = Double.parseDouble((String) websiteData.get(key));
		double valueInAPI;
		if(apiData.get(key) instanceof Integer)
		{
			int valueInInt = (int) apiData.get(key);
			valueInAPI = valueInInt;
		}
		else
			valueInAPI = (Double)apiData.get(key);
		
		if (varianceFlag) {
			String strTolerance = TestProperties.getProperty("TemperatureVariance"); 
			double tolerance = Double.parseDouble(strTolerance);
			
			double difference = Math.abs(valueInWebsite - valueInAPI);
			
			String strDifference = String.format("%.2f", difference);
			System.out.println("There is a difference of " + strDifference + "\u00B0" + "C in temperature from 2 sources");
			
			if(difference <= tolerance)
			{
				return true;
			}
			else
				return false;

		} else {
			if (valueInWebsite == valueInAPI) {
				return true;
			} else
				return false;
		}
	}

}
