package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//You can get all the Links of a page by driver.findElement(tag Name "a")
//But here give me all the links in one section, 
//footer links or language links in google.co.in like hindi, bengali etc

public class GoogleLanguageLinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.co.in/");
		
		List<WebElement> langList  = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
		
		System.out.println("Total no of Links available in Google India is: "+langList.size());
		
		for(WebElement e : langList) {
			System.out.println(e.getText());
		}

	}

}
