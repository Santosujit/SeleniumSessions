package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentLOcators {

	public static void main(String[] args) {

		// 1. id - is mosly unique, can't be duplicate, 1st priority is given to id.
		// 2. name - is not unique, we can have same name for diff Web Elements
		// 3. class name -- is not unique too, we can have same name for diff elements

		// Class Name for E-mail address --- form-control private-form__control
		// login-email --- there are 3 clas names separated by space
		// Class Name for password --- form-control private-form__control login-password
		// m-bottom-3

		// By.ByClassName("form-control private-form__control login-email") --- wrong
		// you can't use the entire class name, as it is not unique
		// so try to fetch the unique class out of the class names separated by comma or
		// space

		WebDriverManager.chromiumdriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// driver.get("https://app.hubspot.com/login");

		// driver.get("https://www.freshworks.com/");

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		// driver.findElement(By.className("login-email")).sendKeys("test@gmail.com");
		// driver.findElement(By.className("login-password")).sendKeys("test@123");

		// 4. linkTest : Only for Links
//		whenever there is a link inside the html DOM, there is a corresponding linkText

		// driver.findElement(By.linkText("Customers")).click();// don't use href
		// property as it is not unique

		// partialLinkTest - only for Links --- used for Long Links - not recoomende to
		// use

		// driver.findElement(By.partialLinkText("Cust")).click();

		// But partialLinkTest is not recommended as if sign up, and sign in is there
		// ans you give sign It will get conffused

		// sign up
		// sign in

		// xpath --- not an attribute. It's a locator --- address of the element inside
		// the DOM

		// driver.findElement(By.xpath("//*[@id=\"Form_submitForm_subdomain\"]")).sendKeys("test@gmail.com");
		// driver.findElement(By.xpath("//*[@id=\"Form_submitForm_FirstName\"]")).sendKeys("test@123");

		// 6. cssSelector ---

		driver.findElement(By.cssSelector("#Form_submitForm_subdomain")).sendKeys("test@gmail.com");
		driver.findElement(By.cssSelector("#Form_submitForm_FirstName")).sendKeys("Santosujit");
		driver.findElement(By.cssSelector("#Form_submitForm_LastName")).sendKeys("Mohanty");

		// CSS vs xPath - which is faster It is a myth
		// Every browser has a CSS Engine, and a xPath Engine, they are super fast
		// Earlier Microsoft IE's xPath Engine was slow
		// Javascript based automation tools like Cypress or Protractor, they are
		// heavily dependent upon CSS selector, they don't support xpath
		// every browser has a xpath engine, and css engine

		// 8. tagName - is not unique
		// header, sub-header

	}

}
