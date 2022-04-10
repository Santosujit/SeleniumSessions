package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTextWithStream {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// I want print all the links of amazon.in
		// sequential stream will print all the links in order
		// parallel stream will print all the links without order, but it is faster

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		// all the links are represented by tagName a
		// findElemets method will return a List of WebElement

		long stTime = System.currentTimeMillis();

		// seq: 5407 ms 5893 ms 5994 ms 6077 ms

		// linksList.stream().forEach(ele -> System.out.println(ele.getText()));

		// linkList is a list of WebElement
		// apply a stream method upon the list which will create a stream
		// then apply a forEach method which will behave as a forEach loop
		// create any variable ele using lambda expression
		// ele will go to each element of the stream and fetch and print the values
		// ele will supplied to system.out.println() method

		// parallel: 5589 ms 5627ms 5250ms 6095 ms
		linksList.parallelStream().forEach(ele -> System.out.println(ele.getText()));

		long endTime = System.currentTimeMillis();

		System.out.println("total time taken: " + (endTime - stTime));

	}

}
