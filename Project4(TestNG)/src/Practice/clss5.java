package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import graphql.Assert;

public class clss5 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp() {	
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramesh\\Desktop\\Abhijit\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		driver.get("https://www.saucedemo.com/");
		
}
	
	@Test(dataProvider = "Name")
	public void Login(String Username1 , String Password1 , String Status) {
		
		WebElement Username = driver.findElement(By.id("user-name"));
		Username.sendKeys(Username1);
		
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(Password1);
		
		driver.findElement(By.id("login-button")).click();
		
		String ActualUrl = driver.getCurrentUrl();
		System.out.println(ActualUrl);
		
		String ExpectedUrl = "https://www.saucedemo.com/inventory.html";
		
		if(Status.equals("Invalid")) {
			
			if(ExpectedUrl.equals(ActualUrl)) {
				
				Assert.assertTrue(false);
			}
			
			else {
				Assert.assertTrue(true);
			}
			
		}
		else if(Status.equals("Valid")) {
			
			if(ExpectedUrl.equals(ActualUrl)) {
				
				
				
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
	
	
	}
	
	@DataProvider(name = "Name")
	public String[][] Logindata() {
		
		
		String[][] Obj = {{"standard_use123r" , "secret_sauce123" , "Invalid"},
				{"standard_user123" , "secret_sauce" , "Invalid"},
				{"standard_user" , "secret_sauce123" , "Invalid"},
				{"standard_user" , "secret_sauce" , "Valid"},
		
		};
		
		return Obj;
	}
	
	@Test(expectedExceptions = StaleElementReferenceException.class)
	public void List() throws InterruptedException {
		
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    
	    driver.findElement(By.id("password")).sendKeys("secret_sauce");
	    
		driver.findElement(By.id("login-button")).click();
		
		driver.navigate().refresh();
		
		Thread.sleep(5000);
	    		
		WebElement list = driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
		
		Select S = new Select(list);
		java.util.List<WebElement> list1 = S.getOptions();
		System.out.println(list1.size());
		
		for(int a=0;a<list1.size();a++) {
			
			System.out.println(list1.get(a).getText());
			
			if(list1.get(a).getText().equals("Price (low to high)")) {
				
				list1.get(a).click();
			}
		}
		
		
		
		System.out.println("Good morning");
		
	}
	
	@Test
	public void Brokenlink() throws URISyntaxException, IOException {
		
		 driver.findElement(By.id("user-name")).sendKeys("standard_user");
		    
		 driver.findElement(By.id("password")).sendKeys("secret_sauce");
		    
	     driver.findElement(By.id("login-button")).click();
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println(Links.size());

		int Brokenlinks = 0;
		
		for(int a=0;a<Links.size();a++) {
			
			String link = Links.get(a).getAttribute("href");
			
			if(link==null || link.isEmpty()) {
				
				System.out.println("Url is empty");
				continue;
			}
			
	try {	URL url = new URL(link);
			
			HttpURLConnection httpcode = (HttpURLConnection)url.openConnection();
			
			httpcode.connect();
			
			if(httpcode.getResponseCode()>400) {
				
				System.out.println(httpcode.getResponseCode()+"--->>"+url+"is--->>"+"Broken url");
				Brokenlinks++;
			}
			
			else {
				
				System.out.println(httpcode.getResponseCode()+"--->>"+url+"is--->>"+"Valid url");
			}
     		}
		catch(MalformedURLException e){
			
			e.getMessage();
		}
		}
		
		System.out.println("Number of broken links are :"+Brokenlinks);
	}
	
	@Test
	public void Addtocart() {
		
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
		    
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		    
	    driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),\"Add to cart\")]")).click();
		
		driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
		
		driver.findElement(By.xpath("//div[@class=\"cart_item_label\"]")).isDisplayed();
				
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
		
		driver.findElement(By.id("continue-shopping")).click();
		
		System.out.println(driver.findElement(By.xpath("//button[contains(text(),\"Add to cart\")]")).getText());
		
		Assert.assertTrue(true);
		
	}

	@Test
	public void About() {
		
	    driver.findElement(By.id("user-name")).sendKeys("standard_user");
	    
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		    
	    driver.findElement(By.id("login-button")).click();
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		
		driver.findElement(By.id("about_sidebar_link")).click();
		
		WebElement Solution = driver.findElement(By.xpath("(//a[text()=\"Solutions\"])[2]"));
		
		Actions Ac = new Actions(driver);
		
		Ac.moveToElement(Solution).build().perform();
		
		List<WebElement> Solution1 = driver.findElements(By.xpath("(//ul[@class=\"nav-link-group-row-column-list\"])[7]//li"));
		System.out.println(Solution1.size());
		
		for(int a=0;a<Solution1.size();a++) {
			
			System.out.println(Solution1.get(a).getText());
		}
		
		WebElement Platform = driver.findElement(By.xpath("(//a[text()=\"Platform\"])[2]"));
		
		Ac.moveToElement(Platform).build().perform();
		
		WebElement Company = driver.findElement(By.xpath("(//a[text()=\"Company\"])[2]"));
		
		Ac.moveToElement(Company).build().perform();
		
		List<WebElement> Company1 = driver.findElements(By.xpath("(//ul[@class=\"nav-link-group-row-column-list\"])[11]//li"));
		
		for(int c=0;c<Company1.size();c++) {
			
			System.out.println(Company1.get(c).getText());
			
			if(Company1.get(c).getText().equals("What is Sauce Labs")) {
				
			    Company1.get(c).click();
			}
			break;
		}
		
		driver.findElement(By.xpath("//div[@class=\"column is-full-mobile is-5-desktop is reference-container\"]")).isDisplayed();
		
		driver.navigate().back();
		
		driver.navigate().back();
		
		driver.findElement(By.id("login_button_container")).isDisplayed();
	
	}
	
	@Test
	public void Javascript() throws InterruptedException {
		
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		
		WebElement element = driver.findElement(By.id("login_button_container"));
		
		Js.executeScript("areguments[0].style.border=10px Solid Red", element);
		
		Js.executeScript("arguments[0].sytle.backgroundborder=Pink", element);
		
		Thread.sleep(3000);
	}

	@AfterMethod
	public void Teardown() throws InterruptedException {
		
	
		driver.quit();
	}
}
