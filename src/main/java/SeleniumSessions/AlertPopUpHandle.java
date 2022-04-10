package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

//		Java script Alert: pop up coming because of alert() (JS)method
//		JavaScript based Alert comes when Page is loading
//		Authentication Pop up comes before Page loads when the URL is launched

//		Javascript Alerts are handled using Alert class

		// In the above URL, without entering user name and password, if you click on
		// Sign in
		// an alert pop up will come
		// How to validate the alert as it is not part of browser
		// driver is inside the browser

		driver.findElement(By.name("proceed")).click();

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();
		driver.switchTo().alert();
		// here driver is switched to the Alert from the Web Page
		// alert method will return a Alert class reference

		String text = alert.getText();
		System.out.println(text);

		alert.accept();// It will click on OK button, will accept the alert

		// alert.sendKeys("testing alert");If there is a text field in the alert, it
		// will enyter values there

		// alert.dismiss();//will cancel the alert - same as Esc button

		driver.switchTo().defaultContent();// bring back the driver from alert to the WebPage
		

	}

}
