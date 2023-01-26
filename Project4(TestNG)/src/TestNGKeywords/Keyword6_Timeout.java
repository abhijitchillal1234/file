package TestNGKeywords;

import org.testng.annotations.Test;

public class Keyword6_Timeout {
	
	//Timeout keyword is used when there is infinite execution in programme
	
	@Test(timeOut = 1000 , enabled = false)
	public void InfiniteForLoop() {
		
		for(;;) {
			
			System.out.println("Hello");
		}
	}
	
	@Test()
	public void loop() {
		
		System.out.println("Good morning");
	}
	
	
	
	
	
	

}
