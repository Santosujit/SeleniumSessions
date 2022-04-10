package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovetoElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);

		By mainlogIn = By.xpath("//div[@id='smoothmenu1']//a[text()='Login / Signup']");
		By spiceClubMember = By.xpath("//a[text()='SpiceClub Members']");
		By clubMemberLogIn = By.xpath("//li[@class='hide-mobile']//a[text()='Member Login']");

		WebElement mainLogin = driver.findElement(mainlogIn);
		WebElement spiceClubmember = driver.findElement(spiceClubMember);
		WebElement clubmemberLogIn = driver.findElement(clubMemberLogIn);

		Actions act = new Actions(driver);

		act.moveToElement(mainLogin).moveToElement(spiceClubmember).moveToElement(clubmemberLogIn).build().perform();
		Thread.sleep(2000);
		clubmemberLogIn.click();
		
	}
}