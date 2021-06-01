package Testngpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGTest {

	WebDriver driver;
	
	@BeforeTest
	public void browserinit() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	
	@Test()
	@Parameters({"browser"})
	public void browserinitiation(String browser) {
		if(browser.equals("chrome")) {
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.demoblaze.com/");
		String title=driver.getTitle();
		System.out.println(title+Thread.currentThread().getId());
		}
		else if(browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
			driver=new EdgeDriver();
			
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.get("https://www.demoblaze.com/");
			String title=driver.getTitle();
			System.out.println(title);
		}
		else if(browser.equals("IE")){
			System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.get("https://www.demoblaze.com/");
			String title=driver.getTitle();
			System.out.println(title);
		}
		
		
	}
	@Test()
	public void depend() {
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		//driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.demoblaze.com/");
		String title=driver.getTitle();
		System.out.println(title+Thread.currentThread().getId());
//		System.out.println("dependency");
//		Assert.assertEquals(true, true);
	}
	@Test(priority=2)
	public void validatelogin() throws InterruptedException {
		System.out.println("validating login screen");
		Thread.sleep(3000);
		//driver.findElement(By.id("login2")).click();
		Thread.sleep(3000);
	}
	@Test
	public void methodtest() {
		System.out.println("method test passed");
	}
	@Test
	public void gitmethod(){
		System.out.println("GIT PUSH method test passed");
	}
	
	@AfterTest
	public void quitdriver() {
		driver.quit();
	}
}
