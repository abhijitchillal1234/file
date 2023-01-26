package TestNGKeywords;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import net.bytebuddy.utility.RandomString;

public class Keyword2_Priority {
	
	//Priority Keyword-----it is used to priorities method 
	                         //if we are not using priority keyword the testng executes all method based on alplabatical order
	                         //the default value of priority is zero.
	
	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
	}
	
	@Test()                     //if we are not given priority to some method the it consider as zero priority
	public void Logo() {
		
		boolean B = driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]")).isDisplayed();
		System.out.println(B);
	}
	
	@Test(priority = 1)
	public void Register() throws IOException {
		
		driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
		
		String S = driver.findElement(By.xpath("//strong[text()=\"Your Personal Details\"]")).getText();
		System.out.println(S);
		
		WebElement Screenshot = driver.findElement(By.xpath("//strong[text()=\"Your Personal Details\"]"));
		
		File source = ((TakesScreenshot)Screenshot).getScreenshotAs(OutputType.FILE);
		
		String Imagename = "Register page";
		
		String Random = RandomString.make(4);
		
		File Dest = new File("C:\\Users\\Ramesh\\Desktop\\ScreenShots\\"+Imagename+""+Random+".jpg");
		
		FileHandler.copy(source, Dest);
	}
	
	@Test(priority = 2)
	public void Login() {
		
		driver.findElement(By.xpath("//a[@class=\"ico-login\"]")).click();
		
		String S1 = driver.findElement(By.xpath("//h1[contains(text(),\"Welcome\")]")).getText();
		System.out.println(S1);
	}
	
	@Test(priority = 3)
	public void Wishlist() {
		
		driver.findElement(By.xpath("//a[@class=\"ico-wishlist\"]")).click();
		
		String S2 = driver.findElement(By.xpath("//div[contains(text(),\"The \")]")).getText();
		System.out.println(S2);
	}
	
	@Test(priority = 4)
	public void Shoppingcart() {
		
		driver.findElement(By.xpath("//span[@class=\"cart-label\"]")).click();
		
		String S3 = driver.findElement(By.xpath("//div[@class=\"no-data\"]")).getText();
		System.out.println(S3);
		
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException {
		
		Thread.sleep(4000);
		
		driver.quit();
	}
	
	
	
}
