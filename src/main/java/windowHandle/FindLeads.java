package windowHandle;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FindLeads {
	@Test(dataProvider="DataSet")
	public void AlertTest(String userName,String password){
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","H:\\Test Leaf\\Test Leaf Selenium Library\\Softwares\\drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		String baseURL = "http://demo1.opentaps.org";
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
				
		driver.findElementById("username").sendKeys(userName);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByXPath("//input[@value='Login']").click();
		
		driver.findElementByPartialLinkText("CRM/SFA").click();
		
		driver.findElementByXPath("//li[@class='sectionTabButtonUnselected']//a[1]").click();
		driver.findElementByXPath("//a[contains(text(),'Find Leads')]").click();
		driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
		
		
		
		WebElement firsItem= driver.findElementByXPath("(//div[@class='x-grid3-body']//a)[1]");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(firsItem));
		
		firsItem.click();
		driver.quit();
		
	}
	@DataProvider(name="DataSet",parallel=true)
	public Object[][] getdata(){
		return new Object[][]{
			{"DemoSalesManager","crmsfa"},{"admin","opentaps"}
		};
	}
}
