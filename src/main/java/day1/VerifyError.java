package day1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyError {
	@Test
	public void TestError()
	{
	System.setProperty("WebDriver.chrome.driver", "./drivers/chromedriver.exe");
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("profile.default_content_setting_values.notification", 2);
	ChromeOptions options = new ChromeOptions();
	
	
	// Open browser             
	WebDriver driver=new ChromeDriver(options);
	        
	// maximize browser
	driver.manage().window().maximize();
	        
	// Open URL
	driver.get("http://www.naukri.com/");
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        
	// Click on login button
	driver.findElement(By.className("blueBtn")).click();
	
	driver.findElement(By.className("qsbSrch blueBtn")).click();
	
	        
	// This will capture error message
	String actual_msg=driver.findElement(By.id("qsbError")).getText();
	    
	// Store message in variable
	String expect="Please enter Keywords or Location to search";
	                
	// Here Assert is a class and assertEquals is a method which will compare two values if// both matches it will run fine but in case if does not match then if will throw an 
	//exception and fail testcases
	 
	// Verify error message
	Assert.assertEquals(actual_msg, expect);
	 
    }
}

