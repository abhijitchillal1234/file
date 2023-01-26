package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import graphql.Assert;

public class Clss4 {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(dataProvider = "name1")
	public void Testcase(String Username1 , String Password1 , String Status) {
		
		WebElement Username = driver.findElement(By.id("user-name"));
		Username.sendKeys(Username1);
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(Password1);
		
		driver.findElement(By.id("login-button")).click();
		
		String ActualUrl = driver.getCurrentUrl();
		System.out.println(ActualUrl);
		
		String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
		
		if(Status.equals("Invalid")) {
			
			if(ExpectedUrl.equals(ActualUrl)) {
				
                driver.findElement(By.id("react-burger-menu-btn")).click();
				
				driver.findElement(By.id("logout_sidebar_link")).click();
				
			    Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		
		}
		
		else if(Status.equals("Valid")) {
			
			if(ExpectedUrl.equals(ActualUrl)) {
				
				driver.findElement(By.id("react-burger-menu-btn")).click();
				
				driver.findElement(By.id("logout_sidebar_link")).click();
				
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		
		
		
		
	}
	
	@DataProvider(name = "name1")
	public Object Logindata() {
		
		String[][] Obj = {{"standard_user" , "secret_sauce" , "Valid"},
				{"standard_user123" , "secret_sauce" , "Invalid"},
				{"standard_user" , "secret_sauce123" , "Invalid"},
				{"standard_use123r" , "secret_sauce123" , "Invalid"},
		
		};
		
		return Obj;
	}
	
	@AfterMethod
	public void Teardown() {
		
		driver.quit();
	}

}
