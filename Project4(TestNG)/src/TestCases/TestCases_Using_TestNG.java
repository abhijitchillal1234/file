package TestCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases_Using_TestNG {
	
	WebDriver driver;
                
	   //If we create test cases using TestNG the we should not require main method because it executes main method in backend
	              //To call testng we require to give annotation @test.
	  //This TestNG is fisible for parallel testing-------
	            //Parallel testing means testing multiple browser at the same time (i.e testcase1 & testcase2)
	
	
	@Test
	public void Demo1() throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
	Thread.sleep(2000);
	
	driver.quit();
	
	}
	
	
	@Test(expectedExceptions = NoSuchElementException.class)
	public void Demo2() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
	    driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		
		WebElement Scroll = driver.findElement(By.xpath("//a[contains(text(),\"Automate\")]"));
		
		JS.executeScript("arguments[0].scrollIntoView();", Scroll);
		
		List<WebElement> row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr"));
		System.out.println(row.size());
		
		List<WebElement> cell = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr/th"));
		System.out.println(cell.size());
		
		WebElement Element = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td[2]"));
		System.out.println(Element.getText());
		
		for(int b=0;b<row.size();b++) {
			
			for(int c=0;c<cell.size();c++) {
				
				WebElement Elements = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr[" + b + "]/td[" + c + "]"));
				System.out.println(Elements.getText()+" | " );
				
			}
		}
		
		driver.quit();
		
	}
	
	
	@BeforeMethod
	public void Demo3(){
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
	}
		
	@Test(expectedExceptions = MalformedURLException.class)
	public void B() throws IOException, InterruptedException {
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println(Links.size());
		
		int Brokenlinks =0;
		
		for(int a=0;a<Links.size();a++) {
			
           String url = Links.get(a).getAttribute("href");
			
			if(url==null || url.isEmpty()) {
				
				System.out.println("Url is empty");
				continue;
			}
			
			URL U = new URL(url);
			
			HttpsURLConnection httpcode = (HttpsURLConnection)U.openConnection();
			
			httpcode.connect();
			
			if(httpcode.getResponseCode()>=400) {
				
				System.out.println(httpcode.getResponseCode()+"--->>"+U+"is--->>"+"Broken Link");
				Brokenlinks++;
			}
			else {System.out.println(httpcode.getResponseCode()+"--->>"+U+"is--->>"+"Valid Link");}
			
		}
		
		System.out.println("Number of broken links :"+Brokenlinks);
		
		
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
	
		Thread.sleep(10000);
		
		driver.quit();
		
	}		
	
	
}


