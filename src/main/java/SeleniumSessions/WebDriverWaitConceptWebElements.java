package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//assignment on 29 minutes

public class WebDriverWaitConceptWebElements {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/");
		// from this website give me the names of all the footer links
		// footer links will take time to load
		// so I am applying wait on all the elements or on List of Elements not only on
		// a single element
		By footers = By.cssSelector("ul.footer-nav li a");
		// create the CssSelector for all the footer links

		List<WebElement> footerList = visibiblityOfAllElements(footers, 1000);
		System.out.println(footerList.size());

		footerList.stream().forEach(ele -> System.out.println(ele.getText()));
		// apply stream on the List
		// for each element , pass the value to sytem.out.println()
		// then for each element get the text

		// On https://classic.crmpro.com/ apply wait on only on user name, no need to
		// apply wait on password and log in button

//		By username = By.name("username");
//		By password = By.name("password");
//		By loginButton = By.xpath("//input[@value='Login']");
//		
//		waitForElementPresent(username, 10).sendKeys("batchautomation");		
//		driver.findElement(password).sendKeys("Test@12345");
//		driver.findElement(loginButton).click();
//		//e4 e5 e6

	}

	public static WebElement getElement(By locator) {
		// Give me the By locator, will give you the WebElement
		return driver.findElement(locator);
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */

	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
//	The above method will check the presence of the WebElement in the DOM, 
//	and create ans return WebElement at 	runtime
	// the above method will wait for the element to be visible in the DOM.
	// There is no guarantee that the element will be visible in the Webpage
	// However you send a request to the server, server loads the DOM 1st
	// Then browser parses the DOM and loads the elements in the WebPage
	// presenceOfElementLocated is demanding a By locator as parameter

	/**
	 * An expectation for checking that an element, known to be present on the DOM
	 * of a page, is visible. Visibility means that the element is not only
	 * displayed but also has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
//	The above method will check the visibility of the WebElement
//	and creates and return WebElement at run time
	// the above method will check that element is visible in the Webpage
	// visibilityOf is demanding a WebElement as parameter

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 * @return
	 */
	public static List<WebElement> visibiblityOfAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
//	The above method checks the visibility of all the elements 
//	and it creates and return a List<WebElement>
	// until and visibilityOfAllElementsLocatedBy method will return a List of
	// WebElements

}
