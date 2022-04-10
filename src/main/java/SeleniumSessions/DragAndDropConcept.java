package SeleniumSessions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

//part of 9th video

public class DragAndDropConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		
		// while dragging one webelement, and dropping over another webelement we do 3
		// things
		// we click on the 1st web element, hold on it, move to 2nd web element, release
		// the 1st web element over 2nd web element
		// these 3 actions are called user action, for this we use Action class
		// but in selenium we can't automation the following:uploading one file from PC
		// to web

		Actions act = new Actions(driver);// we have to create the object of Actions class
		// In select class we pass the web element
		// but in Actions class we pass the driver

		// act.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();
		// we have to write build and perform at last if more than one actions are
		// there,
		// if one action, then only perform is sufficient
		// build collects all 3 actions, and perform performs all 3 actions sequentially

		act.dragAndDrop(sourceEle, targetEle).perform();// you can use this method also

	}

}
