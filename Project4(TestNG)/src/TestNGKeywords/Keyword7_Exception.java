package TestNGKeywords;

import org.testng.annotations.Test;

public class Keyword7_Exception {
	
	//ExpectedException is used to exception handling . It is used insted of try catch.
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void infiniteforloop() {
		
		System.out.println("Exception Handled");
		
		String S = "abc";
		
		Integer.parseInt(S);
		
		System.out.println("Good Morning");

	}
	
	
	
	
	
	
	

}
