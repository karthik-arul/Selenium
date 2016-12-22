package contacts;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindContacts {
	@Test(groups={"sanity"},dataProvider="inputData")//,dependsOnGroups="smoke")
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
		driver.findElementByLinkText("Find Contacts").click();
		/*WebElement selectItem = driver.findElementByXPath("(//div[@class='x-grid3-body']//a)[1]");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathExpression)));
		selectItem.click();*/
		
		System.out.println("********* Find Contacts completed successfully *********");
		driver.quit();
	}
	@DataProvider(name="inputData")
	public Object[][] testData(){
		return new Object[][]{
			{"DemoSalesManager","crmsfa"},{"admin","opentaps"}
		};
	}
}
