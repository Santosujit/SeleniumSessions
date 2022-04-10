package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitConcept {

	public static void main(String[] args) {

		// Suppose in a Log in screen user name , password, and Log in button is there
		// You applied ImplicitWait of 10 second
		// 1st It will wait upto 10 second for username
		// when user name is visible at the same time password and log in button is also
		// visible as they are
//		on the same page, but as you have applied implicitWait
//		It will wait for all the element
//		For password it will call the implicitWait library, then will procees when it found that it is available
//		same will happen for log in button
//		unnecessary time wasteage
//		so in real time we dont use implictWait

		// There are two types of wait:
		//1000 milli seconds = 1 sec
		// 1. static wait: Thread.sleep(10000);//it will wait for 10 seconds even if it
		// finds the element in 2 sec, wastage of time, not recommended

		// 2. dynamic wait://there are two types of dynamic wait like implicitly wait
		// and explicit wait
		// a. implicitly wait

		// b. explicit wait//under explicit wait we have WebDriverWait and FluentWait
		// b.1 : WebDriverWait
		// b.2: FluentWait

		// a. implicitly wait : dynamic wait -- global wait
		// it will be applied on all the elements by default
		// When you create your element using FindElement and FindElements --implicitly
		// wait will be applied by default on it
		// default value of imp wait: 0 sec
		// if element is not within the given time: it will throw NoSuchElementException
		// disadvantage-it will be applied for WebElements not for non web elements:
		// like title, url, alerts (pop -ups)
		// default polling time : 500 ms or .5 seconds

		WebDriverManager.chromiumdriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// manage timeouts & apply implicitlywait using

		// TimeUnit class

		driver.get("http://classic.crmpro.com/");

		// Create the By locators now
		// By locators are nothing but addresses of the elements
//		implicitlyWait is not applied on By locators, It is applied only and only on WebElements

		By username = By.name("username");
		By password = By.name("password");
		By login = By.xpath("//input[@value='Login']");

		// Now create WebElements

		WebElement u1 = driver.findElement(username);// 10
		u1.sendKeys("batchautomation");

		WebElement u2 = driver.findElement(password);// 10
		u2.sendKeys("Test@12345");

		WebElement lg = driver.findElement(login);// 10
		lg.click();

		// For the above scenario 1st implicitly wait will be applied on line no 58 not
		// on By locator
		// It will wait max 10 seconds for the user name to be displayed
		// then when user name is displayed, automatically password and log in button
		// will be displayed as well
		// we dont want implicitlywait on line no 61,and 64 but it will be applied there
		// as
		// well as it is a golbal wait
		// On line no 61, 64 it will unnecessarily hit the implicitlywait library or
		// method,
		// then the library will check that password field is displayed then it will
		// ignore the request and move ahead
		// but still it will consume time unnecessarily
		// same checking will happen for all the WebElements consuming unnecessary time
		// so practically in project we never use implicitlyWait

		// home page:
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// you can override implicitlyWait method.
		// suppose you found Home Page gonna take more time so you overrid with 15
		// second
		// so on e4, e5 WebElements 15 sec implicitlyWait will be applied
		// e4 e5

		// deals page:
		// again overridden method with 5 sec
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// so on e6, e7, e8 WebElements 5 sec implicitlyWait will be applied
		// e6 e7 e8

		// home Page:

		// reg page:
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		// so on e e e e e e WebElements 0 sec implicitlyWait will be applied
		// -Nullification of ImplicitlyWait
		// e e e e e e

		// deals page:
		// so on WebElements below this line again 15 sec implicitlyWait will be applied
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// so basically we apply implicitlyWait by writing as below
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}
