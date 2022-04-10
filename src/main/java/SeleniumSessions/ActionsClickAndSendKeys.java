package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

	static WebDriver driver;
//	in above we declared driver at class level 
//	so that not only main method and but any method outside main method driver can be used in this class

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();// set up the middle server
		driver = new ChromeDriver();// launch the browser
		driver.get("https://demo.opencart.com/index.php?route=account/register");// enter the URL

		// in the above web site enter first name, last name some values, then click on
		// Login Link using Actions class

		// Create By locators now

		By firstname = By.id("input-firstname");
		By lastname = By.id("input-lastname");
		By loginLink = By.linkText("Login");

		Actions action = new Actions(driver);
		
		
//		action.click(target);

//		
//		action.sendKeys(driver.findElement(firstname), "naveen").perform();
//		this method asks for the WebElement where you want to enter text, the text you want to enter
//		action.sendKeys(driver.findElement(lastname), "automation").perform();

//		action.click(driver.findElement(loginLink)).perform();
		
//		action.sendKeys(keys);
//		action.sendKeys(target, keys);
		
		

		doActionsSendKeys(firstname, "naveen");
		doActionsSendKeys(lastname, "automation");

		doActionsClick(loginLink);

		Thread.sleep(6000);
		driver.quit();

	}

	// Create generic functions or Utilities now

	// pass the BY locator, below function will return the WebElement

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	// pass the By locator, the below function will click on the given WebElement

	public static void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}

	// you pass the By locator, the below function will enter values in the given
	// WebElement

	public static void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
//		action.sendKeys(keys);
//		action.sendKeys(target, keys);
		action.sendKeys(getElement(locator), value).perform();
	}

}
