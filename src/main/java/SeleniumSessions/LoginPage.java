package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.SendKeysAction;

public class LoginPage {

	public static void main(String[] args) {

		String browserName = "chrome";//mentain a browser variable at class level

		// 1st store all locators below

		By domain = By.id("Form_submitForm_subdomain");
		By firstName = By.id("Form_submitForm_FirstName");
		By lastName = By.id("Form_submitForm_LastName");
		By submitButton = By.id("Form_submitForm_action_request");

		// 2nd --- Do all browser actions below
		// Now initialize browser, open URL, get the title, verify the title and do
		// other stuff using DriverFactory class

		DriverFactory df = new DriverFactory();

		WebDriver driver = df.init_driver(browserName);
		// this init_driver method returning an WebDriver so stored in a
//		WebDriver reference variable

		df.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");

		String title = df.doGetPageTitle();
		System.out.println("page title is: " + title);

		if (title.contains("Human Resource")) {
			System.out.println("correct page title...");
		}

		// 3rd --- Do all the web elements actions now using elementUtil class

		ElementUtil elementUtil = new ElementUtil(driver);
		
		elementUtil.doSendKeys(domain, "SujitAutomation");
		elementUtil.doSendKeys(firstName, "Santosujit");
		elementUtil.doSendKeys(lastName, "Mohanty");
		elementUtil.doClick(submitButton);

	}

}
