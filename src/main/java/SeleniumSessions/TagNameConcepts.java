package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagNameConcepts {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://classic.crmpro.com/");

		// String text = driver.findElement(By.tagName("h3")).getText();
		// System.out.println(text);

		// Get the text of all html tags
		// findelements will return a dynamic arrayList of WebElement type

		List<WebElement> h3List = driver.findElements(By.tagName("h3"));
		// return type is a List of WebElement

		System.out.println("total number of h3 tags: " + h3List.size());

		// traverse the loop using normal for loop

		// Inside the List in diff objects all the tagNames objects will be stored
		// get(i) method will take you the i th location, then getText method will fetch
		// the values of the i th location

		for (int i = 0; i < h3List.size(); i++) {
			String text = h3List.get(i).getText();
			System.out.println(text);
		}

		System.out.println("***************");

		// for each loop

		for (WebElement e : h3List) {// each e is represnting a WebElement
			System.out.println(e.getText());
		}

	}

}
