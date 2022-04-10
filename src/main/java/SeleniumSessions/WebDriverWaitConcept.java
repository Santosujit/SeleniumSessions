package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {

	static WebDriver driver;

	// declare the driver at class level so that it can be used by all the functions
	// inside the class

	public static void main(String[] args) {

		// Explicit wait: WebDriverWait extends FluentWait
		// Explicit wait is a category under which WebDriverWait extends FluentWait are
		// present
		// WebDriverWait is the child of FluentWait
		// There is no method called as Explicit wait
		// However we have Implicitly wait method available
		// both classes : WebDriverWait, and FluentWaitare are implementing Wait
		// interface
		// dynamic wait: 10 secs -- 5 secs -- 5 secs will be ignored if element is found
		// within 5 sec
		// it will be applied for WebElements as well as non web elements like title url
		// etc

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.dollartree.com/");

//		WebDriverWait wait = new WebDriverWait(driver, 10);//1st write these code then comment
//		 you have to create object of WebDriverWait class
//		 It will wait for maximum 10 seconds

//		wait.until(ExpectedConditions.titleContains("KAYAK"));

		

//		Exception in thread "main" org.openqa.selenium.TimeoutException: Expected 
//		condition failed: waiting for title to contain "My Store". 
//		Current title: "Search Flights, Hotels & Rental Cars | KAYAK" 
//			(tried for 10 second(s) with 500 milliseconds interval)

		// System.out.println(driver.getTitle());

		String title = waitForPageTitle("Dollar", 10);
		System.out.println(title);

	}

	// Create Generic Methods

	// sometimes page title of certain web page takes time to load
	// so the below method will wait for the title to be displayed, compare it, and
	// give you the title

	public static String waitForPageTitle(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		// timeOut is in integer in seconds not in milliseconds
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	// below method you have to specify exact title unlike above method where part
	// of the title was ok

	public static String waitForPageTitleToBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));// until method return a boolean
		return driver.getTitle();
	}

	// so basically you create the object of WebDriverWait class, then through
	// different functions available under it you do your job done as written below
	// WebDriverWait wait = new WebDriverWait(driver, timeOut);
	// wait.until(ExpectedConditions.titleIs(title));
}
