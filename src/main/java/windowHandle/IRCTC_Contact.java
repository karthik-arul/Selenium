package windowHandle;

import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class IRCTC_Contact {
	@Test(groups={"testSanity"})
	public void AlertTest() {
		
		/*DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.5:5544/wd/hub") , dc);
			*/	
	
		System.setProperty("webdriver.chrome.driver", "H:\\Test Leaf\\Test Leaf Selenium Library\\Softwares\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","H:\\Test Leaf\\Test Leaf Selenium Library\\Softwares\\drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		String baseURL = "https://irctc.co.in";
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		System.out.println("Home page URL : "+driver.getCurrentUrl());
		driver.findElementByLinkText("Contact Us").click();
		
		//Collect all the active window identifiers
		Set<String> allWindow = driver.getWindowHandles();
		
		//Print No of Active windows
		System.out.println("Number of Active windows: "+allWindow.size());
		
		//Switch the focus to Contact Us window
		for (String SetWindow : allWindow) {
			driver.switchTo().window(SetWindow);
		}
		
		//print the Contact Us window URL
		System.out.println("Contact US window URL : "+driver.getCurrentUrl());
		
		//Close all open browsers
		driver.quit();
	
	}
}
