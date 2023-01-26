package Parameterisation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterisationThrowXML {
	
	WebDriver driver;
	
	@Parameters({"Username","Password","ExpectedUrl"})
    @Test
	public void Login(String Username1 , String Password1 , String ExpectedUrl1) {
		
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
			
		    driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);         //Implicit Wait
			
			driver.manage().window().maximize();
			
			driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
			
		    WebElement Username = driver.findElement(By.id("Email"));
			Username.clear();
			Username.sendKeys(Username1);
				
			WebElement Password = driver.findElement(By.id("Password"));
			Password.clear();
			Password.sendKeys(Password1);
				
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			
			String ActualUrl = driver.getCurrentUrl();
			
			if(ExpectedUrl1.equals(ActualUrl)) {
				
				System.out.println("Home Page");
			}
			else {System.out.println("Wrong Page");}
			
			driver.quit();

		
	}
		
		
		
		
		
		
	}
	
	
	
	
	


