package TestNGKeywords;

import org.testng.annotations.Test;

public class Keyword3_DependsOn {
	

	//DependsOn----------it is used when some test cases are depends on another test cases
	
	@Test(expectedExceptions = ArithmeticException.class)
	public void LoginTest() {
		
		int No = 20/0;                //ArithmeticException
	}
	
	@Test(dependsOnMethods = "LoginTest")
	public void Searchpage() {
		
		System.out.println("Searchpage");
	}
	
	@Test(dependsOnMethods = "LoginTest")
	public void Refreshpage() {
		
		System.out.println("Refreshpage");
	}
	
	@Test(dependsOnMethods = "LoginTest")
	public void Users() {
		
		System.out.println("Users");
	}
	
	
	

}
