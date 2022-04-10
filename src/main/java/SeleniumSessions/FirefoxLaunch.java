package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxLaunch {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\Selenium_Training_By_Naveen\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// same

		driver.get("https://www.google.com");// Enter URL

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
