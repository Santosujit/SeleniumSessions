package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImages {

	public static void main(String[] args) {

		// go to amazon.in
		// get the total images with img tag
		// print the src(url) properties for each image, all the images are stored in a
		// file
		// server, source file
		// This is called web scrapping

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		System.out.println("Total no of images: " + imgList.size());

		for (int i = 0; i < imgList.size(); i++) {
			String srcUrl = imgList.get(i).getAttribute("src");
			// src is source file attribute where images are stored
			String altValue = imgList.get(i).getAttribute("alt");
			// alt is another alternate attribute

			System.out.println(srcUrl);
			System.out.println(altValue);

		}
	}

}
