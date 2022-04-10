package TestNGSessions;

import org.testng.annotations.Test;

public class TestNGBasics {

	@Test // while writing TestNG classes no need to write main method
	// @Test annotation has many methods written in the background by TestNG
	public void test1() {
		System.out.println("Bye");
	}

}
