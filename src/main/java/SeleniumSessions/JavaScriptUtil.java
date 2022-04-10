package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {// like ElementUtil we have created JavascriptUtil

	private WebDriver driver;// u v 2 maintain one driver
	// we have made this driver private so that no one can access this outside this
	// class

	public JavaScriptUtil(WebDriver driver) {// private constructor
		this.driver = driver;
	}

	public void flash(WebElement element) {
		// This method highlights a WebElement by changing the background colour
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 20; i++) {
			changeColor("rgb(0,200,0)", element);// rgb(0,200,0) stands for Green colour
			changeColor(bgcolor, element);// Its calling the below changeColor() method
		}
	}

	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		// it will create a border around the WebElement passed
		// of 3 pixel solid red border will be created around the WebElement
		// arguments[0].style.border - Go to argument no 0, change its style, change the
		// border
	}

	public void generateAlert(String message) {
		// this method 'll generate customized Alerts for you
		// alert() method is is used to generate alerts
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('" + message + "')");
	}

	public void clickElementByJS(WebElement element) {
		// this method is another way to click on a WebElement through Javascript
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public void refreshBrowserByJS() {
		// this method refreshes the webpage
		// one method also available in selenium java
		// driver.navigate().refresh()
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		// executeScript() method will execute history.go(0) method
	}

	public String getTitleByJS() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		// u v 2 convert ur driver to JavascriptExecutor - type casting
		// JavascriptExecutor is an Interface, so can not create object of it
		// it will give you title of the page using Javascript not by driver.getTitle()
		String title = js.executeScript("return document.title;").toString();
		// executeScript() method is responsible to execute the script
		// write document.title in the console, same write here
		// return will return a Javascript return, then toString() method will convert
		// it to Java String
		// return document.title will return a
		// javascript title
		// then toString method converts it into a Java string
		return title;
	}

	public String getPageInnerText() {// this method gives you the entire text of the webpage
		// this method is directly not available in selenium
		// In selenium getPageSource() method is available but not innerText() method
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		// document.documentElement.innerText - write it in console, same thing write
		// here
		// go to each and every element and gets the innertext
		return pageText;
	}

	public void scrollPageDown() {
		// This method scroll down to the bootom of the web page
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		// you have to use window object
		// to test it, go to the web page
		// right click and inspect
		// go to console, clear the console
		// paste the java script code window.scrollTo(0,document.body.scrollHeight)
		// press enter to execute the java script code, and test it
	}

	public void scrollPageUp() {
		// This method scroll up to the top of the web page
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}

	public void scrollIntoView(WebElement element) {
		// It will scroll down and stops when it finds the WebElement
		// All scrolling functions are for vertical scrolling
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public String getBrowserInfo() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String uAgent = js.executeScript("return navigator.userAgent;").toString();
		return uAgent;
	}

	public void sendKeysUsingJSWithId(String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	public void sendKeysUsingJSWithName(String name, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementByName('" + name + "').value='" + value + "'");
	}

	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
			return;
		}

		// This loop will rotate for 25 times to check If page Is ready after
		// every 1 second.
		// You can replace your value with 25 If you wants to Increase or
		// decrease wait time.
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}

}