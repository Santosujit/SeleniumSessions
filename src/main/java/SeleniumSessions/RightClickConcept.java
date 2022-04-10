package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		// In the above website, there is a application level right click
		// Do application level right click, get all the names of the options
		// and click one option out of them
		// we can not automate browser or OS level right click though

		// Create By Locators now so that u don't v 2 hit server always using
		// driver.findElement

		By rightClick = By.xpath("//span[text()='right click me']");
		By rightClickOptions = By.xpath("//ul/li[contains(@class,'context-menu-icon')]");

		// under ul tag 7 li are available, including the separator
		// exclude it using class context-menu-icon

//		 WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']")); 
//	     Actions act = new Actions(driver); 
//		 Thread.sleep(3000); 
//		 act.contextClick(rightClick);

		List<String> optionsList = getRightClickMenuList(rightClick, rightClickOptions);
		System.out.println("count is: " + optionsList.size());// 6
		System.out.println(optionsList);

		rightClickOption(rightClick, rightClickOptions, "Paste");

	}

	// Outside the class create generic functions

	// function to get WebElements

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	// function to get the list of right click options

	public static List<String> getRightClickMenuList(By rightCickLocator, By listLocator) {

		Actions act = new Actions(driver);
		act.contextClick(getElement(rightCickLocator)).perform();
		// right click in selenium is called context click

		List<String> rightClickList = new ArrayList<String>();
		// create an array list, and store all the right click
		// options
		List<WebElement> menuList = driver.findElements(listLocator);

		System.out.println(menuList.size());

		for (WebElement e : menuList) {
			String text = e.getText();
			rightClickList.add(text);
		}
		return rightClickList;
	}

	// function to click on one of the right click option

	public static void rightClickOption(By rightCickLocator, By listLocator, String value) {

		Actions act = new Actions(driver);
		act.contextClick(getElement(rightCickLocator)).perform();

		List<WebElement> menuList = driver.findElements(listLocator);

		System.out.println(menuList.size());// 6

		for (WebElement e : menuList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
