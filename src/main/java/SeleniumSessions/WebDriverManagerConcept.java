package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();// middle server will be set up

		// the binary exe file version and browser version should be compatible
		// the above line matches that automatically
		// copy the WebDriverManager dependency and paste it in your pom.xml
		// then it will show up in your maven dependencies
		// WebDriverManager will download the binary .exe file compatible with your
		// local browser automatically
		// boni gracia a developer from madrid has developed it

		WebDriver driver = new ChromeDriver();// browser will be launched and new session id created

		driver.get("http://www.google.com"); // Enter Url

		String title = driver.getTitle(); // get the title
		System.out.println("page title is: " + title);

		// verification point//checkpoint: (Actual vs Expected Result)
		if (title.equals("Google")) {
			System.out.println("correct title");
		} else {
			System.out.println("in-correct title");
		}

		System.out.println(driver.getCurrentUrl());

		// System.out.println(driver.getPageSource());

		// driver.quit();//close the browser
		driver.close();

	}

}
