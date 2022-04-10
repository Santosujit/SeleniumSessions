package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchSuggestionList {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
		By search_Bar = By.id("search_query_top");
		driver.findElement(search_Bar).sendKeys("Dress");
		
		Thread.sleep(4000);
		
		By suggestionList = By.xpath("//div[@class='ac_results']//li");
		List<WebElement> sugList = driver.findElements(suggestionList);
		
		for(WebElement e:sugList) {
			String suggestion = e.getText();
			System.out.println(suggestion);
			
			   if(suggestion.equals("Blouses > Blouse")) {
				   e.click();
				   break;
			   }
		}
		
		
	}

}
