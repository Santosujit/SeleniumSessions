package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//search naveen automationlabs in google, 
//there will 10 suggestions, select naveen automationlabs resume

public class GoogleSearch {

	static WebDriver driver;
	// mentain a static WebDriver driver at class level so that It can be used
	// by all the methods inside this class without creating object for it

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		Thread.sleep(3000);

		// Inspect the search bar 1st, then inspect any one suggestion List value
		// Under ul tag, there are 10 li tags
		// naveen automationlabs is under span tag, which is not immediate child of tag,
		// so use //

		// create By locators for search bar, and suggestion List value

		By search = By.name("q");// This is the XPath for Google Search Bar

		By suggesionList = By.xpath("//ul[@class='erkvQe']/li//div[@class='sbl1']/span");
		// above is the most important step to get the xpath

		driver.findElement(search).sendKeys("naveen automation");
		Thread.sleep(3000);

		selectFromSuggestList(suggesionList, "naveen automation labs cucumber");

	}

	public static void selectFromSuggestList(By suggestionList, String value) {

		List<WebElement> resultList = driver.findElements(suggestionList);

		System.out.println(resultList.size());

		for (WebElement e : resultList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}
}
