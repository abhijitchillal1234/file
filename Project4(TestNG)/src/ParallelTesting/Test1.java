package ParallelTesting;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import graphql.Assert;

public class Test1 {
	
	WebDriver driver;
	
	@Test
	public void Demo1() {
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);         //Implicit Wait
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
	
		driver.quit();
		
	}
	
	@Test
	public void Demo2() {
		
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);         //Implicit Wait
			
			driver.manage().window().maximize();
			
			driver.get("https://www.facebook.com/");
			
		    WebElement Username = driver.findElement(By.id("email"));
		    
		    Assert.assertTrue(Username.isDisplayed());
		    
		    Username.sendKeys("XYZ");
		    
		    WebElement Pass = driver.findElement(By.id("pass"));
		    
		    Assert.assertTrue(Pass.isDisplayed());
		    
		    Pass.sendKeys("ABC");
		    
		    WebElement Seen = driver.findElement(By.xpath("//div[@class=\"_9lsb _9ls8\"]"));
		    
		    Assert.assertFalse(Seen.isSelected());
		    
		    WebElement Login = driver.findElement(By.xpath("//button[@name=\"login\"]"));
		    
		    Assert.assertTrue(Login.isEnabled());
		    
		    Login.click();
		    
		    String ErrorMessage = driver.findElement(By.xpath("//div[@class=\"_9ay7\"]")).getText();
		    
		    assertEquals(ErrorMessage, "The email address or mobile number you entered isn't connected to an account. Find your account and log in.");
		    
		    driver.quit();
    
		
	}
	
	

}
