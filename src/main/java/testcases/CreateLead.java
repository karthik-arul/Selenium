package testcases;

import org.testng.annotations.Test;

import wrappers.GenericWrapperMethods;

public class CreateLead extends GenericWrapperMethods {

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
		
		// Step 6: Click CRM/SFA
		clickByLink("CRM/SFA");

		// Step 7: Click Create Lead
		clickByLink("Create Lead");
		
		// Step 8: Enter Company name
		enterById("createLeadForm_companyName", "Personal");
		
		// Step 9: Enter First name
		enterById("createLeadForm_firstName", "Karthik");
		
		// Step 10: Enter Last name
		enterById("createLeadForm_lastName", "Arul");

		// Step 11: Click Create Lead button
		clickByClassName("smallSubmit");

		// Step 12: Close browser
		quitBrowser();
		
	}

}
