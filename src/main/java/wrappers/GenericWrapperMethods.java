package wrappers;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GenericWrapperMethods implements Wrappers{
	public RemoteWebDriver driver;
	String parentWindow;

	@Override
	public void invokeApp(String browser, String url) {

		try {
			// Step 1: Launch chrome
			if(browser.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if(browser.equals("Firefox")){
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}

			// wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Step 2: Load URL
			driver.get(url);
			driver.manage().window().maximize();
			
			System.out.println("The browser :"+browser+" launched successfully.");
			
		} catch (Exception e) {
			System.out.println("The browser :"+browser+" could not be launched.");
		}

	}

	@Override
	/*
	 * 1) Write the logic
	 * 2) Handle the exception using try - catch
	 * 3) sysout for success and failure messages
	 */
	public void enterById(String idValue, String data) {
		try {
			WebElement element = driver.findElementById(idValue);
			element.clear();
			element.sendKeys(data);
			System.out.println("The text field :"+idValue+" is entered with text :"+data);
		} catch (NoSuchElementException e) {
			System.out.println("The text field :"+idValue+" not found");
		} catch(WebDriverException e){
			System.out.println("The browser got closed and not accessible");
		} catch(Exception e){
			System.out.println("Something went wrong. look at snapshot");
		}
	}

	@Override
	public void enterByName(String nameValue, String data) {
		try {
			WebElement element = driver.findElementByName(nameValue);
			element.clear();
			element.sendKeys(data);
			System.out.println("The text field : "+nameValue+" is entered with text: "+data);
		} catch (Exception e) {
			System.out.println("The text field : "+nameValue+" could not be entered with text: "+data);
		}

	}

	@Override
	public void enterByXpath(String xpathValue, String data) {
		try {
			WebElement element = driver.findElementByXPath(xpathValue);
			element.clear();
			element.sendKeys(data);
			System.out.println("The textfield : "+xpathValue+" is entered with text : "+data);
		} catch (Exception e) {
			System.out.println("The textfield : "+xpathValue+" could not be entered with text : "+data);
		}

	}

	@Override
	public boolean verifyTitle(String title) {

		if (driver.getTitle().equals(title)) {
			System.out.println("The Title of the Web page '"+title+"' is as expected");
			return true;
		}else{
		System.out.println("The Title of the Web page '"+title+"' is not as expected");
		return false;
		}
	}

	@Override
	public void verifyTextById(String id, String text) {
		try {
			if (driver.findElementById(id).getText().equals(text)){
				System.out.println("The element "+id+" has the text '"+text+"'");
			}else{
				System.out.println("The element "+id+" does not have the text '"+text+"'");
			}
		} catch (Exception e) {
			System.out.println("The element "+id+" not found");
		}
	}

	@Override
	public void verifyTextByXpath(String xpath, String text) {
		
		try {
			if(driver.findElementByXPath(xpath).getText().equals(text)){
				System.out.println("The element "+xpath+" has the text '"+text+"'");
			}else{
				System.out.println("The element "+xpath+" does not have the text '"+text+"'");
			}
		} catch (Exception e) {
			System.out.println("The element "+xpath+" not found");
		}

	}

	@Override
	public void verifyTextContainsByXpath(String xpath, String text) {
		
		try {
			if(driver.findElementByXPath(xpath).getText().toLowerCase().contains(text.toLowerCase())){
				System.out.println("The element "+xpath+" has text :"+text);
			}else{
				System.out.println("The element "+xpath+" does not have text :"+text);
			}
		} catch (NoSuchElementException e) {
			System.out.println("The text field :"+xpath+" not found");
		} catch(WebDriverException e){
			System.out.println("The browser got closed and not accessible");
		} catch(Exception e){
			System.out.println("Something went wrong. look at snapshot");
		}

	}

	@Override
	public void verifyTextContainsById(String id, String text) {
		try {
			if(driver.findElementById(id).getText().contains(text)){
				System.out.println("The element "+id+" has the text '"+text+"'");
			}else{
				System.out.println("The element "+id+" does not have the text '"+text+"'");
			}
		} catch (Exception e) {
			System.out.println("The element "+id+" not found");
		}

	}

	@Override
	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			System.out.println("The element with "+id+" clicked successfully.");
		} catch (Exception e) {
			System.out.println("The element with "+id+" could not be clicked.");
		}

	}

	@Override
	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The element with "+classVal+" clicked successfully.");
		} catch (Exception e) {
			System.out.println("The button "+classVal+" could not be clicked.");
		}
	}

	@Override
	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			System.out.println("The element "+name+" is clicked successfully");
		} catch (Exception e) {
			System.out.println("The element "+name+" Could notbe clicked");
		}

	}

	@Override
	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("The element " + name+" is clicked successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The element " + name+" could not be clicked ");
		}
	}

	@Override
	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("The element '"+xpathVal+"' is clicked successfully");
		} catch (Exception e) {
			System.out.println("The element '"+xpathVal+"' could not be clicked");
		}

	}

	@Override
	public String getTextById(String idVal) {
		String sReturn = "";
		try {
			sReturn = driver.findElementById(idVal).getText();
			return sReturn;
		} catch (Exception e) {
			System.out.println("The text could not be found");
		}
		return sReturn;
	}

	@Override
	public String getTextByXpath(String xpathVal) {
		String sReturn = "";
		try {
			sReturn = driver.findElementByXPath(xpathVal).getText();
			return sReturn;
		} catch (Exception e) {
			System.out.println("The text could not be found");
		}
		return sReturn;
	}

	@Override
	public void selectVisibileTextById(String id, String value) {
		

	}

	@Override
	public void selectIndexById(String id, String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void switchToParentWindow() {
		try {
			driver.switchTo().window(parentWindow);
			System.out.println("Switched to Parent Window Successfully");
		} catch (NoSuchWindowException e) {
			System.out.println("The Parent Window is not Found");;
		} catch (Exception e){
			System.out.println("Some other Exception occurred");
		}

	}

	@Override
	public void switchToLastWindow() {
		try {
			parentWindow = driver.getWindowHandle();
			Set<String> allActiveWindow = driver.getWindowHandles();
			for (String setWindow : allActiveWindow) {
				driver.switchTo().window(setWindow);
			}
			System.out.println("Switched to Child Window Successfully");
		} catch (NoSuchWindowException e) {
			System.out.println("The Window was not found");
		}catch (WebDriverException e){
			System.out.println("The browser got closed and not accessible");
		} catch (Exception e){
			System.out.println("Some other Unhandled exception");
		}
		

	}

	@Override
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert not found");
		}  catch(WebDriverException e){
			System.out.println("The browser got closed and not accessible");
		} catch(Exception e){
			System.out.println("Something went wrong. look at snapshot");
		}

	}

	@Override
	public void quitBrowser() {
		try {
			driver.quit();
			System.out.println("The browser was closed successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("The browser was not closed successfully");
		}

	}

}
