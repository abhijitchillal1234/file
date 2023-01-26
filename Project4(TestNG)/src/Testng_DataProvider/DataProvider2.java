package Testng_DataProvider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import graphql.Assert;

public class DataProvider2 {
	
	WebDriver driver;

	@BeforeTest
	public void SetUp() {
		
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
			
		    driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);         //Implicit Wait
			
			driver.manage().window().maximize();
			
			driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
	}
		
	@Test(dataProvider = "Login")
	public void NopcommerceLogin(String Username1 , String Password1 , String Status) {		
			
		    WebElement Username = driver.findElement(By.id("Email"));
			Username.clear();
			Username.sendKeys(Username1);
			
			WebElement Password = driver.findElement(By.id("Password"));
			Password.clear();
			Password.sendKeys(Password1);
			
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			
			String ExpectedTitle = "Dashboard / nopCommerce administration";
			
			String ActualTitle = driver.getTitle();
			System.out.println(ActualTitle);
			
			if(Status.equals("Valid")) {                                  //if status is valid
				
				if(ExpectedTitle.equals(ActualTitle)) {                  //then it comapaire title if it is correct
					
					System.out.println("Login Successful with valid input");            //print the title
					
					driver.findElement(By.xpath("(//a[@class=\"nav-link\"])[2]")).click();  //click on logout
					
					Assert.assertTrue(true);                   //if it is true then test case is pass
				}
				
				else {
					Assert.assertTrue(false);             //if it is false then test case is fail
					}
			}
			
			else if(Status.equals("Invalid")){                     //if status is invalid
				
				if(ExpectedTitle.equals(ActualTitle)) {          //if it compaire title then it is falied test case
					
					System.out.println("Falied test case");
					
					driver.findElement(By.xpath("(//a[@class=\"nav-link\"])[2]")).click();  //click on logout
					
                    Assert.assertTrue(false);					
				}                                                //then it is falied test case because it login with invalid input
				
				else {
					
					Assert.assertTrue(true);                    //true
				}
			}
				
		}
	
	
	@DataProvider(name = "Login")
	public String[][] Data() {
		
		String data [][] = {
				        {"admin@yourstore.com" , "admin" , "Valid"},
	                	{"admin@yourstore.com" , "admin123" , "Invalid"}, 
		                {"admin123@yourstore.com" , "admin" , "Invalid"},
		                {"admin123@yourstore.com" , "admin123" , "Invalid"}
		                
	                	};
		
		
		    return data;             //returns data 
		
	}
	
	@AfterTest
	public void Teardown() {
		
		driver.quit();
	}
	
	
	
}
