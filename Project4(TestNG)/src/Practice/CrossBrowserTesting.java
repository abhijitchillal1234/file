package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossBrowserTesting {
	
	WebDriver driver;
	
	@Parameters("Name")
	@Test
	public void CrossBrower(String Browser) throws InterruptedException {
		
        if(Browser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
	       driver = new ChromeDriver();
		}
       else if(Browser.equals("Firefox")) {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\geckodriver.exe");
    	
    	driver = new FirefoxDriver();
       }
       else if(Browser.equals("Edge")) {
    	   System.setProperty("webdriver.edge.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\msedgedriver.exe");
    	   
    	   driver = new EdgeDriver();
       }
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
        
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        
        driver.findElement(By.name("username")).sendKeys("Admin");
        
        driver.findElement(By.name("password")).sendKeys("admin123");
        
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        
        Thread.sleep(3000);
        
        driver.quit();
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
