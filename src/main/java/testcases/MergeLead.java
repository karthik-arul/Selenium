package testcases;

import org.testng.annotations.Test;

import wrappers.GenericWrapperMethods;

public class MergeLead extends GenericWrapperMethods {

	@Test
	public void loginToOpentaps() {

		// Step 1: launch the browser
		invokeApp("chrome", "http://106.51.127.250:8080/opentaps/control/main");

		// Step 2: Enter user name
		enterById("username", "admin");

		// Step 3: Enter Password
		enterById("password", "opentaps");

		// Step 4: Click Login
		clickByClassName("decorativeSubmit");
		
		// Step 5: Click CRM/SFA
		clickByLink("CRM/SFA");
		
		// Step 6: Click Leads Link
		clickByLink("Leads");

		// Step 7: Click Merge Leads Link
		clickByLink("Merge Leads");
		
		// step 8: Click on Icon near From Lead
		clickByXpath("(//form[@action='mergeLeads']//img)[1]");
		
		// step 9: Move to new window
		switchToLastWindow();
		
		// step 10: Enter Lead ID
		String fromLead = driver.findElementByXPath("(//a[@class='linktext'])[1]").getText();
		enterByName("id", fromLead);
		
		// step 11: Click Find Leads
		clickByXpath("//button[contains(text(),'Find Leads')]");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// step12: Click First Resulting lead
		clickByXpath("(//a[@class='linktext'])[1]");
		
		// step 13: Switch back to primary window
		switchToParentWindow();
		
		// step 14: Click on Icon near To Lead
		clickByXpath("(//form[@action='mergeLeads']//img)[2]");
		
		// step 15: move to new window
		switchToLastWindow();
		
		// step 16: Enter Lead ID
		String toLead = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a").getText();
		enterByName("id", toLead);
		
		// step 17: Click Find Leads
		clickByXpath("//button[contains(text(),'Find Leads')]");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 18: Click First Resulting lead
		clickByXpath("(//a[@class='linktext'])[1]");
		
		// step 19: Switch back to primary window
		switchToParentWindow();
		
		// step 20: Click Merge
		clickByClassName("buttonDangerous");
		
		// step 21: Accept Alert
		acceptAlert();
		
		// step 22: Click Find Leads
		clickByLink("Find Leads");
		
		// step 23: Enter From Lead ID
		enterByName("id", fromLead);
		
		// step 24: Click Find Leads
		clickByXpath("//button[contains(text(),'Find Leads')]");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step 25: Verify error msg
		verifyTextByXpath("//div[@class='x-paging-info']", "No records to display");
		
		// Step 26: Close browser
		quitBrowser();
		
	}

}
