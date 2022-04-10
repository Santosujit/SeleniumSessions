package SeleniumSessions;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();// It will start the middle server
		driver = new ChromeDriver();// it will launch the browser

		// It will give the request to open the chrome browser to the middle
		// server
		// and the server will give request to the browser itself
		// and performs actions on the browser

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");// it will enter the URL

		// get the element (By using any locator) + action(sendkeys, click, get
		// text....)

		// 1. id: ID is mostly unique, If ID is there Blindly use it

		/*
		 * driver.findElement(By.id("Form_submitForm_subdomain")).sendKeys(
		 * "SujitAutomation");//It // will give instructions to the server to // find
		 * the element 1st, then enter values //
		 * driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("Santosujit")
		 * ;
		 */

		// The above method is not good practice to write selenium codes

//		WebElement domain = driver.findElement(By.id("Form_submitForm_subdomain"));

		// domain.sendKeys("SanthosAutomation");// Here unlike previous one , will give
		// instructions only once to find the
		// element, then
		// you can only give instructions to enter values, better for reusability point
		// of view

		// The above coding practice is better than the 1st coding practice wrt to
		// reusability point of view

		// 3rd and 4th approach - create locator repositories 1st, then hit the server
		// whenever required using Finfelement method

		// 3rd approach

		// Create Locator Repositories 1st

//		By domain = By.id("Form_submitForm_subdomain");// id method will return a By

		// class reference, so store using By
		// class
		// reference variable

		/*
		 * By firstName = By.id("Form_submitForm_FirstName"); 
		 * By lastName =By.id("Form_submitForm_LastName");
		 * By submitButton =By.id("Form_submitForm_action_request");
		 * 
		 */

		// Hit the server
		/*
		 * driver.findElement(domain).sendKeys("SantoAutomation");// domain is the By
		 * locatior here driver.findElement(firstName).sendKeys("Santosujit");
		 * driver.findElement(lastName).sendKeys("Mohanty");
		 */

		// 4th approach-

		// create By locator repositories 1st

		/*
		 * By domain = By.id("Form_submitForm_subdomain"); By firstName =
		 * By.id("Form_submitForm_FirstName"); By lastName =
		 * By.id("Form_submitForm_LastName"); By submit Button =
		 * By.id("Form_submitForm_action_request");
		 */

		// Don't hit the server now, directly create the WebElements

		/*
		 * WebElement domain_ele = driver.findElement(domain);//ele means element
		 * WebElement firstName_ele = driver.findElement(firstName); WebElement
		 * lastName_ele = driver.findElement(lastName);
		 */
		// then perform actions

		/*
		 * domain_ele.sendKeys("OM SAI Automation"); firstName_ele.sendKeys("OM");
		 * lastName_ele.sendKeys("Sai");
		 */

		// 5th approach

		// In last approach everytime you have to wtite driver.findelement always

		// In 4th approach, still we have to write driver.findElement(by) multiple times
		// Instead of this write a generic function for that
		// give me the By location, I will give you the web element

		// 5th approach

		/*
		 * By domain = By.id("Form_submitForm_subdomain"); By firstName =
		 * By.id("Form_submitForm_FirstName"); By lastName =
		 * By.id("Form_submitForm_LastName"); By submitButton =
		 * By.id("Form_submitForm_action_request");
		 * 
		 * getElement(domain).sendKeys("OM SAI Automation");
		 * getElement(firstName).sendKeys("OM"); getElement(lastName).sendKeys("Sai");
		 * getElement(submitButton).click();
		 */

		// 6th approach, also create a separate method for sendKeys, and ,click

		By domain = By.id("Form_submitForm_subdomain");
		By firstName = By.id("Form_submitForm_FirstName");
		By lastName = By.id("Form_submitForm_LastName");
		By submitButton = By.id("Form_submitForm_action_request");

		doSendKeys(domain, "OM SAI Automation");
		doSendKeys(firstName, "OM");
		doSendKeys(lastName, "SAI");
		doClick(submitButton);

	}

	public static WebElement getElement(By locator) {
		// this function is about, you pass the By locator, I will give you
		// the WebElement
		return driver.findElement(locator);
	}

	// I will now write generic functions for sendkeys and click method.
	// above the findElement method we have created a wrapper doSendKeys method

	public static void doSendKeys(By locator, String value) {// Pass the By locator, and what value you want to enter

		getElement(locator).sendKeys(value);// Create the WebElement and enter values inside it
	}

	public static void doClick(By locator) {
		getElement(locator).click();
	}

}
