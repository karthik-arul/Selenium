package day2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

//import org.junit.Assert;
//import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAlert {
	@Test()
	public void AlertTest() {
		
		

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		String baseURL = "http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm";

		driver.get(baseURL);
		WebElement TryitFrame = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(TryitFrame);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Try it')]"))).click();
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
		
		StringSelection SS = new StringSelection("C:\\Karthik.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(SS, null);
		
		Robot robo;
		try {
			robo = new Robot();
	
		robo.keyPress(KeyEvent.VK_ENTER);
		
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame(TryitFrame);
		String AlertText = driver.findElement(By.id("demo")).getText();
		Assert.assertEquals("You pressed Cancel!", AlertText);
		System.out.println(AlertText);
		driver.quit();

	}
}
