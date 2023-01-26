package TestngAssersion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssersion {
	
	//HardAssertion--------if any condion is false then it should not execute remaining steps fron that test case
	                        //it directly jumps to next test case
	
	@Test
	public void Test1() {
		
		System.out.println("Execution Started");
		
		Assert.assertTrue(false);  //if this condion is false then remaining steps from test case are skip & it directly jumps to next test case
		
		System.out.println("Hello good morning");
		
		Assert.assertEquals("Selenium", "Selenium");    //if expected & actual are equals then this condition is true
		
		System.out.println("Hard Assertion");
		
		Assert.assertEquals("Python", "Python");       //if expected & actual are equals then this condition is true
		
		System.out.println("Execution Completed");
	}
	
	@Test
	public void Test2() {
		
		System.out.println("Executes Test2");
		
		Assert.assertTrue(true); //if this condion is false then remaining steps from test case are skip & it directly jumps to next test case
		
		System.out.println("Hard Assertion Test2");
		
		Assert.assertEquals("Java", "Java");   //if expected & actual are equals then this condition is true
		
		System.out.println("Print java");
		
		Assert.assertEquals("Ruby", "Ruby");   //if expected & actual are equals then this condition is true
		
		System.out.println("Excution Completed Test2");
		
		
	}
	

}
