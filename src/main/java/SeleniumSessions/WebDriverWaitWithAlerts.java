package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitWithAlerts {

	static WebDriver driver;

	public static void main(String[] args) {

		// webdrverwait -- can be applied , WebElements, non web elements also:
		// and alerts:

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		// On this step there will be Alert displayed on rediff page
		// we want to accept or dismiss the alert, and get the text of the alert

//		Alert alert = isAlertPresent(5);
//		System.out.println(alert.getText());
//		alert.accept();

		System.out.println(getAlertText(5));
		// It will check for the presence of alert for max 5 sec
		// If the alert is found within 2 sec, rest 3 second will be ignores, It will go
		// to next step,
		// If the alert is not found within 5 sec, then there will be Exception thrown

	}

	public static Alert isAlertPresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		// create WebDriverWait class object and pass the driver
		// and timeOut as parameter
		return wait.until(ExpectedConditions.alertIsPresent());

		// It will check the whether alert is present for timeOut
		// value given, ExpectedConditions is class
	}

	public static String getAlertText(int timeOut) {
		return isAlertPresent(timeOut).getText();
	}

	public static void doAcceptAlert(int timeOut) {
		isAlertPresent(timeOut).accept();
	}

	public static void doDismissAlert(int timeOut) {
		isAlertPresent(timeOut).dismiss();
	}

}
