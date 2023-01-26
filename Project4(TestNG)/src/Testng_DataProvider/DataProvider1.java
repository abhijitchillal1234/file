package Testng_DataProvider;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import graphql.Assert;

public class DataProvider1 {
	
	@Test(dataProvider = "Logindata")
	public void LoginTest(String Username1 , String Password1) {
		
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);         //Implicit Wait
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
		driver.manage().window().maximize();
		
		WebElement Username = driver.findElement(By.name("username"));
		Username.sendKeys(Username1);
		
		WebElement Password = driver.findElement(By.name("password"));
		Password.sendKeys(Password1);
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		boolean Text = driver.findElement(By.xpath("//p[@class=\"oxd-userdropdown-name\"]")).isDisplayed();
		
		Assert.assertTrue(Text);

		driver.quit();
	}
	
	@DataProvider(name = "Logindata")
	public Object[][] LoginData() {
		
		Object[][] data = new Object[4][2];
		
		//Correct Username & password
		data[0][0] = "Admin";
		data[0][1] = "admin123";
		
		//Correct Username & incorrect password
		data[1][0] = "Admin";
		data[1][1] = "admin1234";
		
		//Incorrect username & correct password
		data[2][0] = "Admin1234";
		data[2][1] = "admin123";
		
		//Incorrect username & incorrect Password
		data[3][0] = "Admin1234";
		data[3][1] = "Admin1234";
		
		return data;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
