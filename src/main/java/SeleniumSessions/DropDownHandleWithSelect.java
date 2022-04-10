package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithSelect {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		// If you inspect any drop down, the tag name
		// will be select, then
		// click on the drop down, there will be value
		// and text
		// options tag are the child tags of parent select tag

		// WebElement industry_ele =
		// driver.findElement(By.id("Form_submitForm_Industry"));
		// findElement method
		// will
		// return an WebElement
		// WebElement country_ele =
		// driver.findElement(By.id("Form_submitForm_Country"));

		// to access the drop down, we have to create the object of Select class each
		// time for each drop down

		// Select select1 = new Select(industry_ele);//select class takes WebElement as
		// parameter not By locator
		// select1.selectByIndex(5);//index will start from zero, not recommended as
		// index may change
		// select1.selectByVisibleText("Computer / Technology - Services /
		// Consultancy");
		// select1.selectByValue("health");

		// now suppose we want to select values from country drop down
		// then we have to create another object of Select class again

		// Select select2 = new Select(country_ele);
		// select2.selectByVisibleText("India");

		// but as shown above we have to create objects repeatedly
		// Lets write generic methods

		// Create locators

		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");

		selectValue(country, DropDown.INDEX.toString(), "5");
		selectValue(industry, DropDown.VISIBLETEXT.toString(), "Electronics");
		selectValue(industry, DropDown.VALUE.toString(), "Education");

	}

	public static WebElement getElement(By locator) {
		// pass me your By locator, I will give you the corresponding
		// WebElement
		return driver.findElement(locator);
	}

	// Now create a single function , and club all of the below three methods there,
	// and the above one method

	public static void selectValue(By locator, String type, String value) {
		Select select = new Select(getElement(locator));

		switch (type) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		case "value":
			select.selectByValue(value);
			break;

		default:
			break;
		}

	}

	public static void doSelectDropDownVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));// directly calling the method
		select.selectByVisibleText(value);
	}

	public static void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));// directly calling the method
		select.selectByIndex(index);
	}

	public static void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

}
