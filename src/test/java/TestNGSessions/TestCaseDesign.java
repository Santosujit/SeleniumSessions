package TestNGSessions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * 
 * @author Santosujit Mohanty 
 *         No of Test cases is equal to No of @Test
 *         Annotations. All the Test method name's should have test at the end - 
 *         Its a  good practice Assert.assertEquals(actual, expected);
 *         Assert.assertTrue(condition); The above two are the assertions we
 *         use.
 * @BT executed before all the test cases, before all th
 * e classes But @BC is
 *     executed before particular class
 * @BM is executed before each method
 * @BM @Test(Test Case) @AF Its a pair
 * 
 *
 */

public class TestCaseDesign {

	// Global Pre Conditions
	// Precondition
	// Test Steps (Test Case) + Expected vs Actual Result
	// post steps
	// status -- PASS/FAIL/SKIP
	// Report

	/*
	 * BS -- Before Suite --- Connect with DB 
	 * BT -- Before Test --- Create a sample User in DB	 * 
	 * BC -- Before Class --- Launch the browser and APP	 * 
	 * BM -- Before Method --- Login to app user info test -- t1 test case AM --
	 * logout	 * 
	 * BM -- Login to app home page search test -- t2 test case AM -- logout	 * 
	 * BM -- Login to app home page title test --t3 test case AM -- logout	 * 
	 * AC -- After class close the browser 
	 * AT -- After test Delete the user in DB 
	 * AS	 * -- After suite --- disconnect from DB
	 */

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BS -- Connect with DB");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BT -- Create a sample User in DB");

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("BC -- Launch the browser and APP");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BM -- Login to app");
	}

	@Test
	public void homePageTitleTest() {
		System.out.println("home page title test....");
		Assert.assertEquals("Google", "Google");
	}

	@Test
	public void checkUserInfoTest() {
		System.out.println("user info test");
		Assert.assertEquals("admin", "admin");
	}

	@Test
	public void homePageSearchTest() {
		System.out.println("home page search test");
		Assert.assertTrue(true);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AM -- logout");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("AC -- close the browser");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AT -- Delete the user in DB");
	}

	@AfterSuite()
	public void afterSuite() {
		System.out.println("AS -- disconnect from DB");
	}

}