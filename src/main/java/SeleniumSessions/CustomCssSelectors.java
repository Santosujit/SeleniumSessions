package SeleniumSessions;

//Watch this Video again

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomCssSelectors {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://classic.crmpro.com/");
		

		//id --> #id, tagName#id (you have to use hash or #)
		//class --> .class, tagName.class (You have to use Dot or .)
		//.c1.c2.c3...cn
		// #input-email
		// input#username
		
		By.cssSelector("#input-email");
		// .form-control.private-form__control.login-email
		// .login-email
		// input.login-email
		// input.form-control.private-form__control.login-email
		
		// #username.login-email
		// #username.form-control.private-form__control.login-email
		// .form-control.private-form__control.login-email#username
		// .login-email#username
		// input.login-email#username
		
		// tagName[atrr1 = 'value'] --css --- no double slash --- no @
		//tagName[@attr1 = 'value'] --xpath
		
		// input[value='Login']
		//input[@value='Login']
		By.cssSelector("input[value='Login']");
		
		// tagName[atrr1 = 'value'][attr2 = 'value']
		// input[value='Login'][type='submit'] --css
		//input[@value='Login' and @type='submit'] --xpath
		// input[value][type='submit']
		// input[value][type]
		
		//input[@value and @type='submit'] --xpath
		//input[@value and @type]
		
		//parent to child: > operator
		// div.private-form__input-wrapper input#username
		// div.private-form__input-wrapper > input#username
		// .private-form__input-wrapper input#username
		// .private-form__input-wrapper #username
		
		// div.private-form__input-wrapper > input
		
		//child to parent:
		//no backward traversing in CSS
		
		//contains:
//		tagName[attribute*='value'] --- contains
//		tagName[attribute^='value'] --- starts with
//		tagName[attribute$='value'] --- ends with
		
		// input[id*='user']
		// input[id*=-origin-airport]
		
		//starts-with:
		// input[id^='user']
		
		//ends-with:
		// input[id$='name']
		
		//By.cssSelector("input[id^='user']");
		
		//comma in css:
		
//		By loginPageElement = By.cssSelector("input#input-email, a[href*=forgotten], div#cart");
//		
//		List<WebElement> eleList = driver.findElements(loginPageElement);
//		
//		if(eleList.size() == 4) {
//			System.out.println("My login page is displayed with mandatory elements....");
//		}
		
//		List<WebElement> loginFormEleList = driver.findElements(
//				By.cssSelector("input#username, input#password, "
//						+ "button#loginBtn, span.private-checkbox__icon.private-checkbox__check"));
//		
//		if(loginFormEleList.size() == 4) {
//			System.out.println("My login page is displayed with mandatory elements....");
//
//		}
		
		//following sibling in css:
		// div.private-form__input-wrapper + div
		
		//nth-of-type:
		// ul.footer-nav > li > a
		// ul.footer-nav li a
		//ul[@class='footer-nav']/li/a
		
		// ul.footer-nav li:nth-of-type(3)
		// ul.list-unstyled li:nth-of-type(1)
		// ul.list-unstyled li:nth-of-type(n)
		
		By langLinks = By.cssSelector("ul.list-unstyled li:nth-of-type(n)");
		
		List<WebElement> langList = driver.findElements(langLinks);
		
		for(WebElement e : langList) {
			System.out.println(e.getText());
		}
		
//		System.out.println("------");
		
//		langList.stream().forEach(ele -> System.out.println(ele.getText()));
		
//		-----------------------------------

		// If any id attribute is there then you have to use #id
		// If any class attribute is there then you have to use .class
		// for multiple classes --- .c1.c2.c3....cn
		// If any html tag is there then tag#id
		// If any html tag is there then tag.class

		// https://demo.opencart.com/
		// I want to create a CSSSelector where id is available
		// #input-email
		// By.cssSelector("#input-email");

		// https://app.hubspot.com/login
		// form-control private-form__control login-email ---three classes so remove the
		// gap and put dot there
		// .form-control.private-form__control.login-email
		// .login-email
		// input#username ---with tag name
		// input.login-email --- with tag name
		// input.form-control.private-form__control.login-email ---with tag name
		// Can I write id with class name ---yes --- #username.login-email
		// #username.form-control.private-form__control.login-email
		// order does not matter
		// .form-control.private-form__control.login-email.#username
		// .login-email#username
		// input.login-email#username

		// tagName[atrr1 = 'value'] --in case of css selector
		// tagName[@attr1 = 'value'] --in case of xpath

		// input[value='Login'] --- cssSelector so doesn't start with // and no @ too
		// //input[@value='Login'] --- xpath so starts with // and @ is also there
		// By.cssSelector("input[value='Login']");

		// tagName[atrr1 = 'value'][attr2 = 'value']
		// input[value='Login'][type='submit'] --css no need of AND like in xpath
		// input[@value='Login' and @type='submit'] --xpath no need of two square
		// brackets like in cssSelector

		// input[value][type='submit'] ---even if value attribute has no value still a
		// right cssselector
		// input[value][type] ---even if value and type attribute has no value still a
		// right cssselector

		// input[@value and @type='submit'] ---right xpath even if no value for type
		// attribute
		// input[@value and @type] ---right xpath even if no value for type and value
		// attribute

		// https://app.hubspot.com/login

		// parent to child: in cssselector
		// div.private-form__input-wrapper input#username ---after class name there is a
		// space
		// .private-form__input-wrapper input#username ---without tag name also right
		// cssselector
		//// .private-form__input-wrapper #username ---without input tag also
		// div.private-form__input-wrapper > input#username --if you don't like space
		// then use an anchor tag

		//// div.private-form__input-wrapper > input ---both id and password fields come
		//// under it then use driver.findElements

		// child to parent:
		// no backward traversing in CSS

		// kayak.com
		// contains: In cssselector you don't have to mention contains keyword
		// explicitly
		// input[id*='user']
		// input[id*=-origin-airport]

		// https://app.hubspot.com/login

		// starts-with:
		// input[id^='user']

		// ends-with:
		// input[id$='name']

		// By.cssSelector("input[id^='user']");

		// comma in css:

		// By loginPageElement =
		// By.cssSelector("input#input-email,a[href*=forgotten],div#cart");
		// Instead of creating diff cssselector for email,forgot password link,cart we
		// created one cssselector only

//		List<WebElement> eleList = driver.findElements(loginPageElement);
//		
//		if(eleList.size() == 4) {
//			System.out.println("My login page is displayed with mandatory elements....");
//		}

//		List<WebElement> loginFormEleList = driver.findElements(
//				By.cssSelector("input#username, input#password, "
//						+ "button#loginBtn, span.private-checkbox__icon.private-checkbox__check"));
//		
//		if(loginFormEleList.size() == 4) {
//			System.out.println("My login page is displayed with mandatory elements....");
//
//		}

		// xpath vs cssselector ---which is faster ---It's myth that css is faster than
		// xpath
		// in fact xpath is faster
		// xpath value remains same for every browser
		// If you have written xpath for one browser then it will work for all other
		// browsers
		// every browser has a xpath engine whose responsibility is to read the xpath
		// parse the xpath, traverse the xpath
		// 5 or 7 yaers back xpath engine of IE was slower so is the myth that xpath is
		// slower
		// but now a days all xpath engine of all the browser is fast

		// freshworks.com

		// nth-of-type:
		// ul.footer-nav > li > a
		// ul.footer-nav li a
		// ul[@class='footer-nav']/li/a

		// ul.footer-nav li:nth-of-type(3) ---indexing
		// ul.list-unstyled li:nth-of-type(1)
		// ul.list-unstyled li:nth-of-type(n) --all the li it will give you

//		By langLinks = By.cssSelector("ul.list-unstyled li:nth-of-type(n)");

//		List<WebElement> langList = driver.findElements(langLinks);

//		for (WebElement e : langList) {
//			System.out.println(e.getText());
//		}

		System.out.println("------");

//		langList.stream().forEach(ele -> System.out.println(ele.getText()));
		
		// stream function can only be applied on List
		// when stream function is applied, it will a create a stream, then the foreach
		// method will create a runtime variable e.g. ele
		// ele will go to every webElement of the stream, and it wil pass to
		// system.println what it wants to do
		// and systemprintln wants to get text of each webElement

	}

}
