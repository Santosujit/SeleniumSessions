package SeleniumSessions;

//Watch this Video again...Not able to understand

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JuqeryDropDownHandle {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		// In the above Website, do three things one by one
		// do single selection, then you may do multi selection,
		// you may do do all selection from the drop down,
		// select check boxes

		Thread.sleep(2000);

		driver.findElement(By.id("justAnInputBox")).click();
		// click on the drop down menu, it will show up the choices below it

		Thread.sleep(2000);

		By choices = By.xpath("//span[@class='comboTreeItemTitle']");
		// the choices are coming under span tag
		// there are 44 choices but only upto 7 visible, others are hidden choices or
		// check boxes
		// This is a bug

		// 1. single selection
		// selectChoiceFromDropDown(choices, "choice 1");

		// 2. multi selection - pass the choices on which you want to check the
		// checkboxes
		// selectChoiceFromDropDown(choices, "choice 2", "choice 6", "choice 6 2 3",
		// "choice 7");

		// 3. All selection: If you want to select all the check boxes
		selectChoiceFromDropDown(choices, "ALL");

	}

	/**
	 * Pass the single String value for single selection, Pass the multiple String
	 * values for multiple selection, Pass "ALL" for all selection values from
	 * dropdown
	 * 
	 * @param choices
	 * @param value
	 */

	public static void selectChoiceFromDropDown(By choices, String... value) {

		// I am passing the By locator of the choices List, and which value I want to
		// check using check box
		// value is an array, you can pass one
		// value or multiple values
		// you are passing here By locator choices, and diff values of choices for check
		// boxes

		List<WebElement> choiceList = driver.findElements(choices);

		if (!value[0].equalsIgnoreCase("All")) {
			// if value[0] equals All ...It "ll check, it will go directly to else part

			for (int i = 0; i < choiceList.size(); i++) {
				// Now iterate the choiceList arrayList - use a for loop

				String text = choiceList.get(i).getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {// this 2nd for loop is to iterate value array
					// to check the check boxes
					if (text.equals(value[j])) {
						choiceList.get(i).click();// here the counter is i not j
						break;
					}
				}
			}

		}

		// select all the values:
		else {
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {
				// System.out.println("element is not found....");
			}
		}
	}

}
