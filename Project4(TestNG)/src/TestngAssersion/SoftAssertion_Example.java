package TestngAssersion;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion_Example {
	
	//Soft Assertion example--------->>>>>>>>>>>>>>>>>>>>>>
	
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
	public void Loginpage() {
		
		SoftAssert soft = new SoftAssert();
		
	    WebElement Username =  driver.findElement(By.xpath("//input[@name=\"username\"]"));
	    
	    soft.assertTrue(Username.isDisplayed());          //if this condition is true or false then it executes the reaming steps
	    
		Username.sendKeys("Admin");
		
    	WebElement Password = driver.findElement(By.xpath("//input[@name=\"password\"]"));

    	soft.assertTrue(Password.isDisplayed());        //if this condition is true or false then it executes the reaming steps
    	
    	Password.sendKeys("admin123");
    	
		WebElement Submitbutton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

		soft.assertTrue(Submitbutton.isEnabled());
		
		Submitbutton.click();
		
		soft.assertAll();         //if any exception at run time then it collects that exception. Executes all steps then it throws.
			
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
