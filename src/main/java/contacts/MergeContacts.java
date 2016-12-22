package contacts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MergeContacts {
	@Test(groups={"regression"},dataProvider="inputData",dependsOnGroups="sanity")
	public void contacts(String userName, String password){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
		
		String baseURL = "http://demo1.opentaps.org";
		driver.get(baseURL);
		driver.findElementById("username").sendKeys(userName);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByXPath("//input[@value = 'Login']").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByLinkText("Merge Contacts").click();
		
		driver.findElementByXPath("//a[@class='buttonDangerous']").click();
		
		driver.switchTo().alert().accept();
		
		String errorMessageHeader = driver.findElementByXPath("//div[@class='errorMessageHeader']").getText();
		Assert.assertEquals("The Following Errors Occurred:", errorMessageHeader);
		System.out.println("********* Merger Contacts completed successfully *********");
		driver.quit();
	}
	@DataProvider(name= "inputData")
	public Object[][] testData(){
		return new Object[][]{{"DemoSalesManager","crmsfa"},{"admin","opentaps"}};
	}
}
