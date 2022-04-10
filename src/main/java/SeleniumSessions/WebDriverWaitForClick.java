package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitForClick {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.dollartree.com/");// we want to click on Track Order
		// The Link should be visible and clickable
		// Thread.sleep(5000);

		By trackOrders = By.xpath("//span[contains(@id,'track-order-element')]/a/span");

		ElementUtil eleUtl = new ElementUtil(driver);
		// the generic function we are calling from ElementUtil class
		eleUtl.clickWhenReady(trackOrders, 10);

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement track = wait.until(ExpectedConditions.presenceOfElementLocated(trackOrders));
		// track.click();//normal click is sometimes not working

		// driver.findElement(trackOrders).click();

//		By customers = By.linkText("Customers");
//		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement track = wait.until(ExpectedConditions.elementToBeClickable(trackOrders));
//		
//		Actions act = new Actions(driver);
//		act.moveToElement(track).click().build().perform();

	}

}
