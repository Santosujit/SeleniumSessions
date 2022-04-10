package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	public static void main(String[] args) {

		// go to amazon.in
		// get the total links
		// print the text of each link but ignore the blank text
		// print the href(url) prop for each link

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();// driver reference variable pointing to new ChromeDriver() object
		driver.get("https://www.amazon.in/");

		// all the Links have tagName as a

		List<WebElement> linksList = driver.findElements(By.tagName("a"));

		System.out.println("total no of links: " + linksList.size());

		// Traverse the ArrayList using forEach loop

		/*
		 * for (WebElement e : linksList) { String linkText = e.getText();
		 * System.out.println(linkText); }
		 */

		for (int i = 0; i < linksList.size(); i++) {
			String linkText = linksList.get(i).getText();

			if (!linkText.isEmpty()) {// isEmpty returns false if the text is blank, which makes the if condtion
										// false, so it will not print the text
				System.out.println(i + ":->" + linkText);
				String hrefVal = linksList.get(i).getAttribute("href");//href attribute contains the entire link starting with https://
				//It will give you the value of the attribute href
				System.out.println(hrefVal);
			}
		}

	}

}
