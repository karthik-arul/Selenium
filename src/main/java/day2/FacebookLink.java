package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLink {
	private WebDriver driver;
	private String baseURL;
	
	@Before
	public void Setup(){
	System.setProperty("webdriver.gecko.driver","H:\\Test Leaf\\Test Leaf Selenium Library\\Softwares\\drivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	baseURL = "https://www.facebook.com";
	
	}
	@Test
	public void TestFacebook(){
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//get list of all the links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//click on third link
		System.out.println("The 3rd links Text is :" +links.get(2).getText());
		links.get(2).click();
		
	}
	/*@After
	public void TearDown(){
		driver.quit();
	}*/


}
