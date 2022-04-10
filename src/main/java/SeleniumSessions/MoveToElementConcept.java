package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//part of 9th video

public class MoveToElementConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");

		// On the above website, you have to go to CONTENT and click on COURSES
		// you can't inspect COURSES directly and use driver.findElement.click as it is
		// not visible on the screen
		// 1st you have to mouse over to CONTENT, wait for COURSES to be visible, then
		// click on it
		// If in DOM ,Courses is written, and in UI, COURSES is written in capital letter
		// then selenium will understand capital letters only, whatever is written in UI
		// on the web page
		// not on DOM
		// This is one level mouse over, there can be two level mouse over too

		Thread.sleep(4000);// wait for 4 sec for contect to be visible

		WebElement content = driver.findElement(By.className("menulink"));// 1st create the WebElement

		Actions act = new Actions(driver);
		// 2nd Create the object of Actions class, and pass the driver

		act.moveToElement(content).perform();// then move to the content drop down

		Thread.sleep(2000);// wait for 2 sec for course to be visible

		driver.findElement(By.linkText("COURSES")).click();// go to courses and click on it

	}

}
