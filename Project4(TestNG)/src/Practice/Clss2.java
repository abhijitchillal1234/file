package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import graphql.Assert;

public class Clss2 {
	
	WebDriver driver;

	@BeforeTest
	public void SetUp() {
		
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
			
		    driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);         //Implicit Wait
			
			driver.manage().window().maximize();
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(dataProvider = "Login")
	public void Login(String Username1 , String Password1 , String Status) {
		
		WebElement Username = driver.findElement(By.name("username"));
		Username.sendKeys(Username1);
		
		WebElement Pass = driver.findElement(By.name("password"));
		Pass.sendKeys(Password1);
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		String Expectedtitle = "OrangeHRM";
		
		String Actualtitle = driver.getTitle();
		System.out.println(Actualtitle);
		
		
		if(Status.equals("Valid")) {                                  //if status is valid
			
			if(Expectedtitle.equals(Actualtitle)) {                  //then it comapaire title if it is correct
				
				System.out.println("Login Successful with valid input");            //print the title
				
				driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).click();  //click on logout
				
				driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
				
				Assert.assertTrue(true);                   //if it is true then test case is pass
			}
			
			else {
				Assert.assertTrue(false);             //if it is false then test case is fail
				}
		}
		
		else if(Status.equals("Invalid")){                     //if status is invalid
			
			if(Expectedtitle.equals(Actualtitle)) {          //if it compaire title then it is falied test case
				

				System.out.println("Login Successful with valid input");            //print the title
				
				driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).click();  //click on logout
				
				driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
				
                Assert.assertTrue(false);					
			}                                                //then it is falied test case because it login with invalid input
			
			else {
				
				Assert.assertTrue(true);                    //true
			}
		}
		
	
		
	}
	
	@DataProvider(name = "Login")
	public String[][] Data() {
		
		String data[][] = {{"Admin" , "admin123" , "Valid"},
		                   {"Admin123" , "admin123" , "Invalid"},
	                       {"Admin" , "admin12" , "Invalid"},
		                   {"Admin123" , "admin1234" , "Invalid"}
		                
		};
				
		return data;		

	}
	
	@AfterMethod
	public void Teardown() {
		
		driver.quit();
	}
	
	
	

}
