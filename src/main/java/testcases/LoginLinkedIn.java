package testcases;

import org.testng.annotations.Test;

import wrappers.GenericWrapperMethods;

public class LoginLinkedIn extends GenericWrapperMethods{
@Test	
	public void LoginLinkedInTest(){
		//Launch LinkedIn using Chrome browser
		invokeApp("chrome", "https://www.linkedin.com");
		//Enter username
		enterById("login-email", "mailkarthik.arul@gmail.com");
		//Enter Password
		enterById("login-password", "G0ldfish");
		//Click on Sign In button
		clickByName("submit");
		//Verify Title
		String title = "Welcome! | Linkedn";
		boolean result = verifyTitle(title);
		//Close Browser
		quitBrowser();
	}
}
