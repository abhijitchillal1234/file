package TestngAssersion;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import graphql.Assert;

public class AssertionExample {
	
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
		
		WebElement Username = driver.findElement(By.name("username"));
		
		Assert.assertTrue(Username.isDisplayed());
		
		Username.sendKeys("Admin");
		
		WebElement Password = driver.findElement(By.name("password"));
		
		Assert.assertTrue(Password.isDisplayed());
		
		Password.sendKeys("admin123");
		
//		Assert.assertFalse(Username.isDisplayed());               //True          AssertException: condition expected to be false
//		
//		Username.sendKeys("Admin");
//		
//		Assert.assertFalse(Password.isDisplayed());              //True
//		
//		Password.sendKeys("admin123");

		WebElement Submit = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		
		Assert.assertTrue(Submit.isEnabled());
		
		Submit.click();
		
		String Uname = driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).getText();
		
	    assertEquals(Uname, "HARSH harshborse14");
	    
	    System.out.println("Correct Uname");
	   
		
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
		
		Thread.sleep(2000);
		
		driver.quit();

	}

}
