This project uses Java 15 and Maven 1.12, it's highly recommended to instal the same versions.

To run this script:
1)Instal IntelliJ IDEA Community Edition 2020.2.3 version.
2)Instal Java 15 & Maven 1.7 -you can instal them while instaling IntelliJ.
3)Open project using Intellij
4)Download compatible version with your Chrom Browser of ChromeDriver.exe file from https://sites.google.com/a/chromium.org/chromedriver/downloads
5)Move Chromedriver.exe to Resources folder
6)Open POM.XML file and press reload button.
7)Make sure Data.XLXS file in the resources folder contains data properly.
8)Execute Test cases on OrdersTests test class.

Project environment
* Java 15
* Selenium Chrome Driver
* Selenium Support
* POI library to read data from excel
* testNG for Assertions

Project Structure
	First: main pachage
		* contains page locaters and methods to interact with these locate, Also contains Wrapper & Base classes
		1) Wrapper Class: 
			contains methods to take actions before using web elements, like wait for element or clear input fields before sending data to these fields.
			All methods inside that class have "locators" as parameters not "web elements".
	
		2) BasePages Class:
			This class is the super class for other pages classes
			contains constructor for driver, WebDriverWait and wrapper class since it's used by all other pages classes.
		3) Pages Classes:
			These classes contains locators of web elements and methods to simulate steps the user and the driver execute 
			The constructor of these classes is the constructor of the BasePage Class.
		Page Classes Are "ordered by user flow to execute the required task":
			1)HomePage Class
			2)SigninPage Class
			3)MyAccountPage Class
			4)DressesPage Class
			5)ProductPage Class
			6)OrderScreen Class
			7)MyOrderScreen Class
	Second: test package
		* contains classes that handles test cases
		1)BaseTests Class
			contains test setup & test teardown methods which are executed before & after each test class
			test setup method contains instances of page classes to be used directly in test cases.
		2)ReadDataFromExcelClass
			contains methods to read data from string and numeric excel cells.
			Handles only .xlxs files.
			the constructor of this class takes file path & sheet name as parameters.
		3)Test Classes
			These Classes contains test cases and inherits from BaseTests Class
			1)CreateNewAccountTests Class
				This class only for testing the pages methods and not part of the task
			2)OrdersTests
				This is the main test class that executes the required task and has two test cases
					1)To create new account, login with that account and create order using that account.
					2)Login with active account and create order using that account.
				
