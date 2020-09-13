# codingassignment
Test Vagrant Coding Assignment

## Setup
 Download the project in folder
 Open command prompt in the root folder
 Run command "mvn compile"
 
 
## Execution
 Modify the parameters in "Config.properties" file (if required)
 Open command prompt in the root folder
 Run command "mvn test"
 
 
## Results
 The execution result is generated in the "\test-output\ExtentReports" folder path
 The file name is "ExtentReport"
 
 
## Troubleshoot
 If the Automation run closes after opening web browser:
	There is a mismatch of Browser & driver version. Check compatibility and update accordingly
	

## Framework Structure
	The framework has been designed using TestNG framework and Maven build tool
	Currently there are 4 packages within main: 
		base - Contains the classes to initiate reporting as well as other preconditions like Webdriver for Web execution. Any new framework level enhancements should be done here.
		utils - Contains utility classes for various operations. Common uitilities should be added here. Hardcoding should be strictily avoided.
		api - Contains classes specific to API testing.
		webpages - Contains Base page class and pages classes of AUT
	Under test there are category-wise 3 test classes and 1 resources folder:
		WebTests - Contains all Web only test cases
		APITests - Contains all API only test cases
		ComparisionTests - Contains all comparison test cases
		resources/TestSuites - This folder contains the testng xmls of various test suites designed in the framework
		
	In the root folder the below folder/files are present:
	WebDrivers - This folder contains the webdrivers required during testing
	Config.properties - All configuration data are stored in this file. Owing to small size of test data set, test data is also currently stored here
	pom.xml - This is the configuration file for Maven
	
	
	
		