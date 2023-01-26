package TestNGKeywords;

import org.testng.annotations.Test;

public class Keyword4_InvocationCount {
	
	//InvocationCount------to repeat the test cases again & again we use invocation count

	@Test(enabled = false)
	public void Priting() {
		
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");
		System.out.println("Hello");

	}
	
	@Test(enabled = false)
	public void Forloop() {
		
		for(int a=1;a<=10;a++) {
			
			System.out.println("Hello");
		}
	}
	
	@Test(invocationCount = 10)
	public void Demo() {
		
		int x=20;
		int y=30;
		int z=x+y;
		
		System.out.println("Sum is---->>>"+z);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
