package com.testvagrant.automation.codingassignment.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriverFactory {
	private WebDriver driver;
	private Logger logger;
	
	public BrowserDriverFactory(Logger logger) {
		this.logger = logger;
	}


	public WebDriver getDriver(String browserType) {
		logger.info("Create browser " + browserType);
		String webDriverPath = System .getProperty("user.dir") +  "\\WebDrivers\\";
		
		switch (browserType.toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", webDriverPath + "chromedriver.exe");
			driver=new ChromeDriver();
			break;

		case "FIREFOX":
			//Open FF
			break;

		case "IE":
			//Open IE
			break;

		default:
			throw new RuntimeException("Specified browser is not supported");
		}

		driver.manage().window().maximize();
		return driver;
	}

}
