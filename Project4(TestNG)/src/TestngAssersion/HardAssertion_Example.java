package TestngAssersion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import graphql.Assert;

public class HardAssertion_Example {
	
	//Example of Hard Assertion--------------------->>>>>>>>>>>>>>>>>>>>>>
	
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@Test
	public void OrangeHRM() {
		
	   WebElement Username =  driver.findElement(By.xpath("//input[@name=\"username\"]"));
	   
	   Assert.assertTrue(Username.isDisplayed());  //if this condition is true the it executes reamining steps otherwise it should not execute
	   
	   Username.sendKeys("Admin");
		
    	WebElement Password = driver.findElement(By.xpath("//input[@name=\"password\"]"));
    	
    	Assert.assertTrue(Password.isDisplayed());    //if this condition is true the it executes reamining steps otherwise it should not execute
    	
    	Password.sendKeys("admin123");
		
		WebElement Submitbutton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		
		Assert.assertTrue(Submitbutton.isEnabled());   //if this condition is true the it executes reamining steps otherwise it should not execute
		
		Submitbutton.click();
		
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
