package testcases;

import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.Test;

import wrappers.GenericWrapperMethods;

public class LoginFacebook extends GenericWrapperMethods {
  @Test
  public void Login() {
	  //Launch Facebook in Chrome Browser
	  invokeApp("chrome", "https://www.facebook.com/");
	  //Enter the username 
	  enterById("email", "karthik.arul@yahoo.co.in");
	  //Enter the password
	  enterById("pass", "G0ldfish");
	  //Click in Log In button
	  clickByXpath("//input[@value='Log In']");
	  //Verify Title
	  String title = "Facebook";
	  verifyTitle(title);
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (UnhandledAlertException e){
		driver.switchTo().alert().accept();
		System.out.println("Alert has been closed");
	}
	  //Logout
	  clickByXpath("//*[contains(text(),'Account Settings')]");
	  clickByXpath("//*[contains(text(),'Log Out')]");
	  //Close the browser
	  
	  
	  quitBrowser();
  }
}
