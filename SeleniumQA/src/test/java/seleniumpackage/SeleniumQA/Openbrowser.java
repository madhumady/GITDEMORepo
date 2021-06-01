package seleniumpackage.SeleniumQA;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Openbrowser {

	
	WebDriver driver;
	@Test
	public void openandnavigatetowebpage() throws Exception {
		
		//browser initiation
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		//driver .manage() method
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//navigate methods
		/*driver.navigate().to("https://www.demoblaze.com/");
		driver.navigate().refresh();
		driver.navigate().back();*/
		
		//driver.get methods
		driver.get("https://www.demoblaze.com/");
		
		String id=driver.getWindowHandle();
		String pagesrc=driver.getPageSource();
		String curl=driver.getCurrentUrl();
		String title=driver.getTitle();
		//System.out.println(title+"\n"+curl+"\n"+pagesrc+"\n"+id);
		
		//Explicit wait
		WebDriverWait wait=new WebDriverWait(driver, 30);
		boolean status=wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
		System.out.println(status);
		//fluent wait
		FluentWait fwait=new FluentWait(driver);
				fwait.withTimeout(30, TimeUnit.SECONDS);
				fwait.pollingEvery(1, TimeUnit.SECONDS);
				fwait.ignoring(Exception.class);
				
				WebElement login=(WebElement) fwait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@for='log-name']"))));
				
		//Isdisplayed	
		
		status=login.isDisplayed();
		System.out.println(status);
		//javascriptexecutor
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("(//*[@class='btn btn-secondary'])[1]")) );
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Close'])[1]"))).click();
		WebElement log=driver.findElement(By.xpath("//*[@onclick='logIn()']"));
		WebElement cls=driver.findElement(By.xpath("(//button[text()='Close'])[1]"));
		//get cordinates using get location
		Point points=cls.getLocation();
		System.out.println(points);
		log.click();
		//alerts how to handle alerts
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		Thread.sleep(2000);
		// get attribute value
		System.out.println(cls.getAttribute("class"));
		//get css value method
		System.out.println(cls.getCssValue("background-color"));
		
		//Actions class
		
		Actions act=new Actions(driver);
		act.moveByOffset(0,0).click().build().perform();
		//driver.findElement(By.id("loginusername")).sendKeys(Keys.TAB,Keys.chord("Madhu"),Keys.SHIFT,Keys.TAB,Keys.chord("Madhu"),Keys.TAB,Keys.TAB,Keys.ENTER);
		
		Thread.sleep(2000);
	    
		
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		Thread.sleep(3000);
		// Select class for dropdown
		Select select=new Select(driver.findElement(By.id("select-demo")));
		select.selectByIndex(1);
		Thread.sleep(3000);
		List<WebElement> items=select.getAllSelectedOptions();
		System.out.println(items.get(0).getText());
		Thread.sleep(3000);
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		Thread.sleep(3000);
		//Robot class
		Robot robo=new Robot();
		//code to handle auth popup using robot class
		StringSelection s=new StringSelection("admin");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,s);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_TAB);
		robo.keyRelease(KeyEvent.VK_TAB);
		StringSelection s1=new StringSelection("admin");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1,s1);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1500);
		//code to take screenshot using Robot class
		Rectangle screen=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage tmp=robo.createScreenCapture(screen);
		String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		ImageIO.write(tmp, "png", new File(path));
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		//action interface and actions class
		//Drag and drop using actions and action interface
		driver.get("https://demoqa.com/droppable");
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=wait.until(ExpectedConditions.elementToBeClickable(By.id("droppable")));
		Actions actionobj=new Actions(driver);
		Action act1=actionobj.clickAndHold(source).moveToElement(target).release(target).build();
		
		act1.perform();
		Thread.sleep(3000);
		driver.get("https://demoqa.com/browser-windows");
		Thread.sleep(1000);
		//click
		driver.findElement(By.xpath("(//*[@id='windowButton'])[1]")).click();
		Thread.sleep(3000);
		//How to handle windows or how to switch window
		Set child=driver.getWindowHandles();
		ArrayList list=new ArrayList(driver.getWindowHandles());
		System.out.println(list.get(1)+"\n"+list.get(0));
		Iterator it= child.iterator();
		while(it.hasNext()) {
		driver.switchTo().window((String) it.next());
		System.out.println(driver.getPageSource());
		}
		//scroll inside webpage or webelement scroll
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-hamburger-menu"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='hmenu-content']/ul/li[31]/a")));
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[@id='hmenu-content']/ul/li[31]/a")));
		Thread.sleep(2000);
		//eventfirewebdriver scrolling for specific div inside webpage
		EventFiringWebDriver ev=new EventFiringWebDriver(driver);
		ev.executeScript("document.querySelector('#hmenu-content ul').scrollTop=500");
		Thread.sleep(5000);
		driver.quit();
	}
}
