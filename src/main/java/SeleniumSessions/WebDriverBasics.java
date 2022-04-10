package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

//		windows:
		// System.setProperty("webdriver.chrome.driver",
		// "c:\\drivers\\chromedriver.exe");

		// Automation Steps + verification point ==> Automation Testing
		// Selenium + (Java + testNG/Junit + Assertions)
		// Selenium + (Python + PyTest)
		// (JavaScript + Mocha/Jasmine/Chai )
		// (Php + PHPUnit)

		// for mac:

		// Automation Steps+ Verification Points = Automation Testing
		// Selenium + Java(If else/TestNG Assertion
		// Selenium is just a Library, which gives many methods to interact with the
		// browser, it doesn't give you verification points
		// Then you have to include assertions etc then you can achieve automation
		// testing
		// selenium is used to automate the browser
		// Python+pyTest frameworl
		// Javascript+Mocha / Jasmine API/ Chai assertions
		// verification is same as assertions
		// Php+PHPUnit
		// Java+TestNG/Junit

		//// for mac:
		// System.setProperty("webdriver.chrome.driver",
		//// "/Users/naveenautomationlabs/Downloads/chromedriver");

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training_By_Naveen\\Drivers\\chromedriver.exe");// Set
																													// up
																													// the
																													// Server

		WebDriver driver = new ChromeDriver();// Launch a Browser (Chrome)
		

		// in the above line WebDriver is an Interface, ChromeDriver is a class
		// new ChromeDriver() is a child class object referred by parent Interface
		// reference variable driver
		// Default Constructor of ChromeDriver class will be called
		// Inside this default constructor the code to launching the browser is written
		// by Selenium Guys

		// no individual methods are there inside ChromeDriver class
		// All the rules are defined in WebDriver Interface
		// Only implementation of the same methods are there inside ChromeDriver class

		// driver is a WebDriver Interface reference variable
		// driver can't even access ChromeDriver's individual method if any , as
		// reference check will be failed

		driver.get("https://www.google.com");// Enter URL, It returns void

		String title = driver.getTitle();// Get the Title, returns String
		System.out.println("The Page Title is: " + title);

		// Verification or checkpoint (Actual vs Expected)

		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}

		System.out.println(driver.getCurrentUrl());// Retrieves the current URL
		// System.out.println(driver.getPageSource());

		// System.out.println(driver.getTitle()); NoSuchException Exception

		// driver.quit();//close the browser

		// NoSuchSessionException: Session ID is null. Using WebDriver after calling
		// quit()?

//		driver.close();
		// NoSuchSessionException: invalid session id

		// System.out.println(driver.getTitle()); NoSuchException Exception

		// diff between close and quit

	}

}
