package Testng_DataProvider;

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

public class DataProvider3 {
	WebDriver driver;
	@BeforeMethod
	public void SetUp() {
		
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
			
		    driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);         //Implicit Wait
			
			driver.manage().window().maximize();
			
			driver.get("https://www.saucedemo.com/");
	}
	
	@Test(dataProvider = "Logindata")
	public void Login(String Username1 , String Password1 , String Status) throws InterruptedException {
		
		WebElement Username = driver.findElement(By.id("user-name"));
		Username.sendKeys(Username1);
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(Password1);
		
		driver.findElement(By.id("login-button")).click();
		
		String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
		
		String ActualUrl = driver.getCurrentUrl();
		System.out.println(ActualUrl);
		
		if(Status.equals("Valid")) {
			
			if(ExpectedUrl.equals(ActualUrl)) {
				
				System.out.println("Successfully Login");       //login successful
				
				driver.findElement(By.id("react-burger-menu-btn")).click();        //click on left side three line
				
				Thread.sleep(5000);
				
				driver.findElement(By.id("logout_sidebar_link")).click();         //click on logout
		
                Assert.assertTrue(true);                                        //true/pass
			}
			
//			else {
//			
//				Assert.assertTrue(false);        //false/failed
//			}
			
		}
		
		else if(Status.equals("Invalid")) {
             
			if(ExpectedUrl.equals(ActualUrl)) {
				
//				System.out.println("Successfully Login");       //login successful
				
				driver.findElement(By.id("react-burger-menu-btn")).click();        //click on left side three line
				
				driver.findElement(By.id("logout_sidebar_link")).click();         //click on logout
		
                Assert.assertTrue(false);                      //false/failed
			}
			
			else {
				
				Assert.assertTrue(true);                     //true/pass
			}
		
	}
	
	}
	
	
	@DataProvider(name = "Logindata")
	public String[][] Logindata() {
		
		String data [][] = {{"standard_user", "secret_sauce" , "Valid"},
		                    {"standard_user", "secret_sauce1234" , "Invalid"},
		                    {"standard_user1234", "secret_sauce" , "Invalid"},
	                    	{"standard_user1234", "secret_sauce1234" , "Invalid"}
                     	};
		
		return data;
	
	}
	
	@AfterMethod
	public void Teardown() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
