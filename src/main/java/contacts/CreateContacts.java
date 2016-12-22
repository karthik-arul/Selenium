package contacts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContacts {
	@Test(groups={"smoke"},dataProvider="inputData")
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
		driver.findElementByLinkText("Create Contact").click();
		driver.findElementById("firstNameField").sendKeys("UserFirstName");
		driver.findElementById("lastNameField").sendKeys("UserLastName");
		driver.findElementByXPath("//input[@value='Create Contact']").click();
		System.out.println("********* Create Contact completed successfully *********");
		driver.quit();	
	}
	@DataProvider(name="inputData")
	public Object[][] testData(){
		return new Object[][]{
			{"DemoSalesManager", "crmsfa"},{"admin","opentaps"}
		};
	}
}

