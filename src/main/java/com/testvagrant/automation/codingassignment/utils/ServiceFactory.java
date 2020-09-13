package com.testvagrant.automation.codingassignment.utils;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Hello world!
 *
 */
public class ServiceFactory {
	
	public Response getAPIResponseGET(String endpoint, Map<String, String> params, Map<String, String> headers)
	{
		RestAssured.baseURI = TestProperties.getProperty("baseURI");
		
		Response response = RestAssured.given()
				.queryParams(params)
				.headers(headers)
				.when().get(endpoint);
		
		return response;		
	}
	
	public String getAPIResponsePOST(String endpoint, Map<String, String> headers, String body)
	{
		RestAssured.baseURI = TestProperties.getProperty("baseURI");
		
		Response response = RestAssured.given()
				.headers(headers)
				.body(body)
				.when().post(endpoint);
		
		return response.asString();		
	}

}
