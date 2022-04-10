package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private WebDriver driver;

//	declared as private as I want this driver to be usable only in this class
//	or else somebody from other class will create object of DriverFactory class, 
//	and access this driver

	// This DriverFactory is teling "I will be responsible for creating the Driver
	// related actions like open URL, get the title, verify the title
	/**
	 * This method is used to initializing the driver on the basis of given browser
	 * name
	 * 
	 * @param browserName
	 * @return this return WebDriver driver
	 */

	public WebDriver init_driver(String browserName) {
		System.out.println("browser name is : " + browserName);

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("safari")) {
			// WebDriverManager.chromedriver().setup(); This line is not neede in case of
			// safari
			driver = new ChromeDriver();
		} else {
			System.out.println("please pass the correct browser name \" + browserName");
		}
		return driver;// this returned driver will be passed to elementUtil
	}

	public void launchUrl(String url) {// generic method for launching the URL
		driver.get(url);
	}

	public String doGetPageTitle() {
		return driver.getTitle();// generic method for getting the page title
	}

	public String doGetPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {// generic method for closing the browser
		driver.close();
	}

	public void quitBrowser() {// generic method for quitting the browser
		driver.quit();
	}
}
