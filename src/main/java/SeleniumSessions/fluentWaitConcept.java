package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fluentWaitConcept {

	public static void main(String[] args) {

		// WebDriverWait(c) --> extends--> FluentWait (c) ---> implements --> Wait (I)
//		WebDriverWait class extending FluentWait class which is implementing Wait Interface

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://classic.crmpro.com/");

		By username = By.name("username111");
		By password = By.name("password");
		By login = By.xpath("//input[@value='Login']");
		
//		Duration is a // class. Wait for maximum 10 sec before throwing Exception

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))						
				.pollingEvery(Duration.ofSeconds(2))// every 2 second check whether the element is visible or not
				.ignoring(NoSuchElementException.class)// while waiting for entire 10 sec ignore these Exceptions
				.ignoring(StaleElementReferenceException.class);

		wait.until(ExpectedConditions.presenceOfElementLocated(username)).sendKeys("naveen");
		// until() methood is coming from Wait Interface, returns a WebElement
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
//				                  .pollingEvery(Duration.ofSeconds(2))
//				                  .ignoring(NoSuchElementException.class);
				                  

	}

}