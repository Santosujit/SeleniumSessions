package SeleniumSessions;

//Watch the Video again

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://classic.crmpro.com/");

		// XPath is not a property or attribute
		// xPath is address of the element inside the DOM

		// two types of Xpath:-
		// 1. absolute xpath - complete path of the element inside the DOM (not
		// recommended) - copy full path
		// /html/body/header/div/div/div[2]/div/input
		// its risky, it might get changed
		// they can add one more div over here

		// /html/body/header/div/div/div/div[2]/div/input

		// 2. relative xpath - xpath with some attribute or functions
		// custom xpath -

		// https://demo.opencart.com/

		// tagname[@attr = 'value'] --
		// input[@id='santosh']
		// Target 1 of 1 for single element,
		// Target 1 of n for multiple elements

		// input[@id='input-email'] --1 element
		// input[@id] --2 element also a xpath

		// input[@name='email']
		// input[@type='text']

		// tagname[@attr1 = 'value' and @attr1 = 'value'] --you can have multiple
		// attributes too

		// input[@id='input-email' and @type='text' and @name='email']

		// input[@id and @type and @name]
		// input[@id='input-email' and @type and @name]

		// https://app.hubspot.com/

		// form-control private-form__control login-email
		// form-control private-form__control login-password m-bottom-3

//		form-control private-form__control login-email

		By.className("form-control private-form__control login-email");
		// -- wrong, complete class will not work here,
		// 3 class names are here
		By.xpath("//input[@class='form-control private-form__control login-email']");
		// -right, here it will work

		// https://classic.crmpro.com/

		// If no attributes are there, only text is there then you have to use text
		// function

		// text(): any element having the text: link, span, h1,h2,h3, label, div

		// tagname[text()='value']

		// h3[text()='Marketing Campaigns']
		// a[text()='Solutions']

		// www.freshworks.com

		// https://www.orangehrm.com/

		// xpath with attr and text:
		// tagname[@attr='value' and text()='value']
		// tagname[text()='value' and @attr='value']

		// span[@class='description js-validator' and text()='Pick a username for
		// OrangeHRM trial.']

		// Indexing in xpath
		// index:
		// input[@type='text'] ---6
		// position() and last()
		// (//input[@type='text']) The capture group capturing 6 text elements
		// (//input[@type='text'])[1] --It will reach at 1st text element

		// https://demo.opencart.com/
		// (//input[@class='form-control'])[1]
		// (//input[@class='form-control'])[position()=1] ---position function

		// (//input[@class='form-control'])[last()] - It will go to the last element of
		// this capture grouped collection

		// https://www.orangehrm.com/

		// (//input[@type='text'])[last()]

		By fn = By.xpath("(//input[@type='text'])[1]");

		// https://demo.opencart.com/

		// contains(): is used for dynamic attributes

		// tagname[contains(@attr, 'value')]
		// input[contains(@name, 'search')]
		// input[contains(@name, 'se')] --you can pass partial part also
		// https://www.freshworks.com/

		// a[contains(text(),'Fresh')] - It will give you all the links which contains
		// text 'Fresh'

		// https://classic.crmpro.com/

		// h3[contains(text(), 'Management')] - Give me a header h3 which contains text
		// as management

		String deal_text = driver.findElement(By.xpath("//small[contains(text(), 'pulse')]")).getText();
		System.out.println(deal_text);

		// dynamic ID: ext JS extension Javascript
//		< input id = '123_firstname'>
//		<id = '333_firstname'>
//		<id = '121_firstname'>

		// input[contains(@id, '_firstname')] ---_firstname is constant, before that it
		// is varying

		// MoEV-origin-airport
		// c-aF0-origin-airport
		// input[contains(@id, '-origin-airport')] ----origin-airport is constant,
		// before it It is variable

//				c1y_n-submit (refresh It will change in the next line)
//				AcRp-submit
//				c-aF0-submit

		// https://classic.crmpro.com/
		// Inspect the Forgot Password Link

		// input[contains(@id,'value') and text()='value']
		// a[contains(@href, 'login') and text()='Forgot Password?']
		// a[contains(@href, 'login') and contains(text(),'Forgot')] -- with contains no
		// need to write full sentense

		// starts-with:
		// input[starts-with(@name,'user')]

//		----------------------------------------------

		// xpath: address of the element inside the DOM
		// two types:
		// 1. absolute xpath : complete path of the element inside the DOM (not
		// recommended)
		// /html/body/header/div/div/div[2]/div/input
		// its risky, it might get changed
		// /html/body/header/div/div/div/div[2]/div/input

		// 2. relative xpath: xpath with some attributes or functions
		// custom xpath

		// tagname[@attr = 'value'] -- 1 of 1 , 1 of n
		// input[@id='input-email'] --1
		// input[@id] --2

		// input[@name='email']
		// input[@type='text']

		// tagname[@attr1 = 'value' and @attr1 = 'value']
		// input[@id='input-email' and @type='text' and @name='email']

		// input[@id and @type and @name]
		// input[@id='input-email' and @type and @name]

		// input[@type='submit' and @value='Login']

		// form-control private-form__control login-email
		// form-control private-form__control login-password m-bottom-3

//		By.className("form-control private-form__control login-email"); //-- wrong
//		By.xpath("//input[@class='form-control private-form__control login-email']"); //-right

		// text(): any element having the text: link, span, h1,h2,h3, label, div
		// tagname[text()='value']
		// h3[text()='Marketing Campaigns']
		// a[text()='Solutions']

		// xpath with attr and text:
		// tagname[@attr='value' and text()='value']
		// tagname[text()='value' and @attr='value']

		// span[@class='description js-validator' and text()='Pick a username for
		// OrangeHRM trial.']
		// span[text()='Pick a username for OrangeHRM trial.' and @class='description
		// js-validator']
		// span[@class='description js-validator']

		// index:
		// input[@type='text'] ---6

		// position() and last()
		// (//input[@type='text'])[1]
		// (//input[@class='form-control'])[1]
		// (//input[@class='form-control'])[position()=1]

		// (//input[@class='form-control'])[last()]
		// (//input[@type='text'])[last()]
//		By fn = By.xpath("(//input[@type='text'])[1]");

		// contains(): is used for dynamic attributes
		// tagname[contains(@attr, 'value')]
		// input[contains(@name, 'search')]
		// input[contains(@name, 'se')]
		// a[contains(text(),'Fresh')]
		// h3[contains(text(), 'Management')]
		// small[contains(text(), 'pulse')]

//		String deal_text = driver.findElement(By.xpath("//small[contains(text(), 'pulse')]")).getText();
//		System.out.println(deal_text);

		// dynamic ID: ext JS
//		< input id = '123_firstname'>
//		<id = '333_firstname'>
//		<id = '121_firstname'>

		// input[contains(@id, '_firstname')]

		// MoEV-origin-airport
		// c-aF0-origin-airport
		// input[contains(@id, '-origin-airport')]

//		c1y_n-submit
//		AcRp-submit
//		c-aF0-submit

		// input[contains(@id,'value') and text()='value']
		// a[contains(@href, 'login') and text()='Forgot Password?']
		// a[contains(@href, 'login') and contains(text(),'Forgot')]

		// starts-with:
		// input[starts-with(@name,'user')]

	}

}
