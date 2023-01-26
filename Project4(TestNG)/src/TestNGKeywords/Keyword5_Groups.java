package TestNGKeywords;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Keyword5_Groups {
	
	//Using groups keyword we group the test cases from one page like logon page
	
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test(groups = "ApplicationUrl" , priority = 1)
	public void Url1() {
		
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test(groups = "Page1" , priority = 2)
	public void Companylogo() {
		
		boolean B = driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed();
		System.out.println(B);
	}
	
	@Test(groups = "Page1" ,  priority = 3)
	public void Logintext() {
		
		boolean B1 = driver.findElement(By.xpath("//h5[@class=\"oxd-text oxd-text--h5 orangehrm-login-title\"]")).isDisplayed();
		System.out.println(B1);
	}
	
	@Test(groups = "Page1" ,  priority = 4)
	public void Usersinput() {
		
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}
	
	@Test(groups = "Page2" ,  priority = 5 )
	public void Loginvalidation() {

		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		String S = driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).getText();
		System.out.println(S);
	}
	
	@Test(groups = "Page2" ,  priority = 6 , dependsOnMethods = "Loginvalidation" )
	public void Url2() {
		
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test(groups = "Test" ,  priority = 7)
	public void Test1() {
		
		System.out.println("TestClass");
	}
	
	@AfterMethod
	public void Teardown() {
		
		driver.quit();
	}
	
	
	
	

}
