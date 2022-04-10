package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthPopUpConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		driver.get("https://UserID:Password@URL");

		// authentication pop up are different from Javascript pop up
		// authentication pop up comes when e.g. log in page is not ready, or while
		// connecting to modem
		// write userid:password@URL

	}

}
