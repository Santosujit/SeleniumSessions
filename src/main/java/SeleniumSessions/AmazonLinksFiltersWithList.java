package SeleniumSessions;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLinksFiltersWithList {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

//		 I want to collect all the links from amazon.in where amazon keyword is
//		 present, and link is not blank using filter and stream concept
//		 The disadvantage of stream and filter concept is that It is difficult to
//		 debug using debugger at run time
//		 stream is Java 8 concept

		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		// will collect all the links from amazon website

		List<String> linkAmazonList = linksList

				.stream()// a stream will be applied on the List,
				// suppose 300 links on this step are there
				.filter(ele -> !ele.getText().isEmpty())// give me all the links which are not empty
				// it 'll filter links which are empty, suppose now 200 links
				// after filteration
				// are there
				// will return a Stream<WebElement>
				.filter(ele -> ele.getText().contains("Amazon"))
				// it 'll filter all the links which contain word
				// Amazon, filter also return a stream of
				// WebElement, so ele is
				// of data type WebElement here
				// will return a Stream<WebElement>
				.map(ele -> ele.getText().trim())
				// a mapper is required to map the list of WebElements we got after
				// filtering and the List
				// map return a Stream of Strings
				// mapper is an intermediary
				// mapper converts Stream<WebElement> to Stream<Strings>
				.collect(Collectors.toList());// then apply collect method using Collectors class
		// It will give you a List<Strings>

		// collect method will return a List of String
		// we started with List of WebElements and finally got List of Strings

		// List<String> linkAmazonList = linksList
//				.stream()
//					.filter(ele -> !ele.getText().isEmpty() && ele.getText().contains("Amazon")) 
		// you can use and operator too but not recommended
//					.map(ele -> ele.getText().trim())
//					.collect(Collectors.toList());

		linkAmazonList.stream().forEach(ele -> System.out.println(ele));
		// here ele is not a WebElement as before
		// here ele is a string, so not need to apply getText method

	}

}
