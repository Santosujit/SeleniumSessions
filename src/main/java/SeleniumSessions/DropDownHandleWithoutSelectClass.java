package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Give me all the values of Industry and Country drop down, and select particular Industry and Country

public class DropDownHandleWithoutSelectClass {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		// Create the Locators

		By industryOptions = By.xpath("//select[@id='Form_submitForm_Industry']/option");
		// this xPath is for all the
		// options inside Industry
		// drop down --- 1 out 0f
		// 21, do a ctrl+f and check

		By countryOptions = By.xpath("//select[@id='Form_submitForm_Country']/option");

		selectDropDownValue(industryOptions, "Electronics");
		selectDropDownValue(countryOptions, "India");

	}

	public static void selectDropDownValue(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println("Number of available Industries are: " + optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);

			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
}
