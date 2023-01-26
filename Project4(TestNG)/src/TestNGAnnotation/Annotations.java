package TestNGAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	//Precondion Annotations----------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@BeforeSuite
	public void Setup() {
    
		System.out.println("@BeforeSuite---->>>Setup Method");
	
	}
	
	@BeforeTest
	public void Launchbrowser() {
		
		System.out.println("@BeforeTest----->>>LaunchBrowser");
	}
	
	@BeforeClass
	public void EnterUrl() {
		
		System.out.println("@BeforeClass---->>>Enter URL");
	}
	
	@BeforeMethod
	public void ApplicationLogin() {
		
		System.out.println("@BeforeMethod---->>>Application Login");
	}
	
	//Test Case------------------->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@Test
	public void GoogleTitle() {
		
		System.out.println("@Test 1---->>> Google Title");
	}
	
	@Test
	public void FacebookTitle() {
		
		System.out.println("@Test 2---->>> Facebook Title");
	}
	
	@Test
	public void AmazonTitle() {
		
		System.out.println("@Test 3--->>> Amazon Title");
	}
	
	
	//PostCondions Annotation--------------------->>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@AfterMethod
	public void ApplicationLogout() {
		
		System.out.println("@AfterMethod--->>>Application Logout");
	}
	
	@AfterClass
	public void CloseBrowser() {
		
		System.out.println("@AfterClass--->>>Close Browser");
	}
	
	@AfterTest
	public void Deletecookies() {
		
		System.out.println("@AfterTest--->>>Delete Cookies");
	}
	
	@AfterSuite
	public void Teardown() {
		
		System.out.println("@AfterSuite--->>>Tear Down");
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}