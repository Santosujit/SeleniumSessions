package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BackAndForwardNavigation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
		driver.navigate().to("https://www.amazon.in/ref=nav_logo");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();

//		driver.get(url) and driver.navigate().to(both methods are same);
//		navigate() method internally calls the get() method
//		navivate().to() method keeps the history unlike get() method which does not track the browser history

//		back/forward/refresh are not part of web Page they are part of the browser
//		so you can not inpsect them
//		Don't use refresh() method or else you may get StaleElemntException

	}

}
