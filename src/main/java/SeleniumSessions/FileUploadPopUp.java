package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

		// type="file" must be there to use sendKeys with file path.
		// if you use click instead of sendkeys then selenium can't handle it
		
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\Dell\\Downloads\\Form_12B.pdf");
//		driver.findElement(By.name("upfile")).sendKeys("PathOftheFileYouWantToUpload");
//		By.name("upfile") is the XPath of the Upload Button
//		

	}

}
