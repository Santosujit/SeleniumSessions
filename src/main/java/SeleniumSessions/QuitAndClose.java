package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitAndClose {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Training_By_Naveen\\Drivers\\chromedriver.exe");
		// This above line will start the server
		// then server will send requests to enter url, get title, quit or close to the
		// browser
		// Server will create session id or SID
		// we call different WebDriver APIs through our script (Java/Ruby/Python/JS etc)
		// If SID is gone then Server will not send request to the browser
		// server is started by the binary .exe file
		// Apple does not provide safari driver
		// Microsoft provides IEDriver, Mozilla provides Gecko driver etc
		// line

		WebDriver driver = new ChromeDriver();
		// Launch a Browser (Chrome) - every time u write this line, a new session
		// id is created
		driver.get("https://www.google.com");// Enter URL, same session id (SID) as above

		String title = driver.getTitle();// Get the Title same session id (SID) as above
		System.out.println("The Page Title is: " + title);// same session id (SID) as above

		// driver.quit();//NoSuchSessionException: Session ID is null. Using WebDriver
		// after calling quit()?
		// even after driver.quit() server still runs

		driver.close();// NoSuchSessionException: invalid session id --- expired session id
		System.out.println(driver.getTitle());

	}

}
