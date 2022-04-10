package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.londonfreelance.org/courses/frames/index.html");

		// Print the text in the title bar
		// It is inside the frame actually
		// driver is present inside the Web Page, 1st take the driver to the frame, then
		// interact
		// with the WebElements inside the frame
		// then again bring back the driver back to the Web Page level

		// frame method is overloaded - 3 ways are there to interact with WebElements
		// inside frame
		// driver.switchTo().frame(2);//index not recommeneded as each time you have to
		// count
		// driver.switchTo().frame("main");

//		driver.switchTo().frame(index);
//		driver.switchTo().frame(nameOrId)
//		driver.switchTo().frame(frameElement/WebElement);
//		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.name("main")));// take the driver inside the frame

		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		// the driver will now interact with the
		// WebElements inside the frame

		System.out.println(header);

		driver.switchTo().defaultContent();// driver will switch back to the Web Page

	}

}
