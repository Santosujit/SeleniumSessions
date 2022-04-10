package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTesting {

	public static void main(String[] args) {

		String browser = "safari";
		WebDriver driver = null;// you have to initialise driver at class level

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training_By_Naveen\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium_Training_By_Naveen\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Pls pass the correct browser");
		}

		driver.get("https://www.google.com");// null.get so NullPointerException

		String title = driver.getTitle();// Get the Title
		System.out.println("The Page Title is: " + title);

		// Verification or checkpoint (Actual vs Expected)

		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("incorrect title");
		}

		System.out.println(driver.getCurrentUrl());
		// System.out.println(driver.getPageSource());

		driver.quit();// close the browser

	}

}
