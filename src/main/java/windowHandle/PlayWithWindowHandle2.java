package windowHandle;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PlayWithWindowHandle2 {
	@Parameters({"URL"})
	@Test(groups={"testSmoke"})
	public void AlertTest(String baseURL){
	
		System.setProperty("webdriver.chrome.driver", "H:\\Test Leaf\\Test Leaf Selenium Library\\Softwares\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","H:\\Test Leaf\\Test Leaf Selenium Library\\Softwares\\drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//String baseURL = "https://checkin.crystalcruises.com";
	
	driver.get(baseURL);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//driver.manage().window().maximize();
	
	driver.findElement(By.linkText("click here")).click();
	
	System.out.println(driver.getTitle());
	String parent = driver.getWindowHandle();
	
	Set<String> allWindowHandles = driver.getWindowHandles();
	System.out.println(allWindowHandles.size());
	
	for (String setWindow : allWindowHandles) {
		
		driver.switchTo().window(setWindow);
	}
	
	
	System.out.println(driver.getCurrentUrl());
	
	driver.quit();
	
	}
}
