package Day7;

import java.util.List;
//import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testLeafAppFrames {
	
	//Initialize & open Chrome Driver
	
	
	ChromeDriver driver = new ChromeDriver();
	@Test	
	public void SingleFrame(){
		//RemoteWebDriver driver = new RemoteWebDriver();
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
		
		
		
		String baseURL = "https://testleaf.herokuapp.com";
		//Open the application
		driver.get(baseURL);
		//Implicit wait for Find elements
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//click on Frames button or link
		driver.findElementByXPath("//h5[contains(text(),'Frame')]").click();
		
		/*WebElement singleFrame = driver.findElementByXPath("//iframe[@src='default.html']");
		driver.switchTo().frame(singleFrame);
		driver.findElementById("Click").click();
		System.out.println("******* First Frame **********");
		System.out.println(driver.findElementByXPath("//*[text()[contains(.,'inside a frame')]]").getText());
		
		driver.switchTo().defaultContent();*/
		
	}
	@Test()
	public void SecondFrame(){
		
		WebElement secondFrame= driver.findElementByXPath("//iframe[@src='page.html']");
		driver.switchTo().frame(secondFrame);
		WebElement nestedFrame = driver.findElementById("frame2");
		driver.switchTo().frame(nestedFrame);
		driver.findElementById("click1").click();
		WebElement secondFrameText = driver.findElementByXPath("//*[text()[contains(.,'nested frame')]]");
		System.out.println("******* Second Frame **********");
		System.out.println(secondFrameText.getText());
		driver.switchTo().parentFrame();
		
	}
	@Test
	public void ThirdFrame(){
		WebElement thirdFrame = driver.findElementByXPath("//*[@src='countframes.html']");
		driver.switchTo().frame(thirdFrame);
		System.out.println("******* Third Frame **********");
		System.out.println(driver.findElementByXPath("//*[text()[contains(.,'Find')]]").getText());
		driver.switchTo().defaultContent();
	}
	@Test
	public void TotalFrames(){
		List<WebElement> elements = driver.findElementsByTagName("iframe");
		System.out.println(elements.size());
	}
	
}
