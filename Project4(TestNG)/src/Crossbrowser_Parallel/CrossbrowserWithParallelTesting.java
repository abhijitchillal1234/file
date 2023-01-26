package Crossbrowser_Parallel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossbrowserWithParallelTesting {
	
	WebDriver driver;
	
	@Parameters("Name")
	@Test
	public void Test1(String Browsername) {
		
		if(Browsername.equals("Edge")) {
	    	System.setProperty("webdriver.edge.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\msedgedriver.exe" );
		
	    	driver = new EdgeDriver();
	}
		
		else if(Browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe" );
			
			driver = new ChromeDriver();
			
		}
		
		else if((Browsername.equals("FF"))) {
        	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\geckodriver.exe" );
			
			driver = new FirefoxDriver();
			
		}
		
	    	driver.manage().window().maximize();
		
	    	driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
	    	driver.get("https://www.facebook.com/");
	    	
	    	driver.findElement(By.id("email")).sendKeys("Abc");
	    	
			driver.findElement(By.id("pass")).sendKeys("SDFGH");
			
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			
			String S = driver.findElement(By.xpath("//div[@class=\"_9ay7\"]")).getText();
			System.out.println(S);
			
			driver.quit();
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
