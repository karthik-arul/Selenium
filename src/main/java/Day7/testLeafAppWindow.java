package Day7;

import java.util.Set;
//import java.sql.Driver;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testLeafAppWindow {
	
	//Initialize & open Chrome Driver
	
	private ChromeDriver driver = new ChromeDriver();
	
	@Test
	public void SingleWindow(){
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
		String baseURL = "https://testleaf.herokuapp.com";
		//Open the application
		driver.get(baseURL);
		//Implicit wait for Find elements
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//click on Frames button or link
		driver.findElementByXPath("//h5[contains(text(),'Window')]").click();
		
		driver.findElementByXPath("//button[contains(text(),'Open Multiple Windows')]").click();
		
		Set<String> allActiveWindows = driver.getWindowHandles();
		System.out.println("No.of Active windows: "+allActiveWindows.size());
		driver.quit();
	}
	
	
}
