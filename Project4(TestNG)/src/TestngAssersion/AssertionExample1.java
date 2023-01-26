package TestngAssersion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionExample1 {
	
	@Test
	public void test1() {
		                   //Actual   Expected
		Assert.assertEquals("Hello", "Hello");     //false
		
		Assert.assertNull(null);      //true
		
		Assert.assertNotNull(2000);    //false
		
		System.out.println("Hello this is assertion topic");
		
		
	}

}
