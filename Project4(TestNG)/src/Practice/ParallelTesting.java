package Practice;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import graphql.Assert;

public class ParallelTesting {
	
	WebDriver driver;

	@Test
	public void Link() {
		
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
				    
				    WebElement Fpass = driver.findElement(By.xpath("//a[contains(text(),\"Forgotten\")]"));
				    
				    Assert.assertTrue(Fpass.isEnabled());
				    
				    Fpass.click();
				    
				    driver.quit();
				    
	}
	
	@Test
	public void Link1() {
		
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
		    
		    WebElement Fpass = driver.findElement(By.xpath("//a[contains(text(),\"Forgotten\")]"));
		    
		    Assert.assertTrue(Fpass.isEnabled());
		    
		    Fpass.click();
		    
		    String text = driver.findElement(By.xpath("//h2[@class=\"uiHeaderTitle\"]")).getText();
		    
		    assertEquals(text, "Find Your Account");
		    
		    driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
