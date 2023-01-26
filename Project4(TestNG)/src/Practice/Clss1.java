package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Clss1 {
	
	WebDriver driver;
	@Parameters("browser")
	@Test(priority = 1)
	void LoginUrl(String Browser) {
		
		if (Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} 
		else if(Browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		else if(Browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\msedgedriver.exe");
			driver = new EdgeDriver();

		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();	
		
	}
	
	@Parameters({"username", "password"})
	@Test(enabled = true,priority = 2)
	public void UserLogin(String username, String password) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println(username);
		System.out.println(password);
		
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
	}
	
	
	
	@AfterTest
	public void TearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
