package testcases;

import org.testng.annotations.Test;

import wrappers.GenericWrapperMethods;

public class Login extends GenericWrapperMethods {

	@Test
	public void loginToOpentaps() {

		// Step 1: launch the browser
		invokeApp("chrome", "http://demo1.opentaps.org");

		// Step 2: Enter user name
		enterById("username", "DemoSalesManager");

		// Step 3: Enter Password
		enterById("password", "crmsfa");

		// Step 4: Click Login
		clickByClassName("decorativeSubmit");
		
		// Step 5: Verify Username
		verifyTextContainsByXpath("//div[@id='form']/h2", "Welcome");
		
		// Step 6: Click Logout
		clickByClassName("decorativeSubmit");
		



	}

}
