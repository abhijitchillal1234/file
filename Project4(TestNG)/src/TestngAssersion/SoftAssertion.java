package TestngAssersion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	//Softassertion-----in case if there is any failure then ,
	            //it should not skip remaining steps from test case it execurtes all the steps then throws exception
	
	    @Test
	    public void Test1() {
	
		SoftAssert soft = new SoftAssert();
	
		System.out.println("Execution Started");
		
		soft.assertEquals(true , true);            //if expected & actual are equals then this condition is true
		
		soft.assertTrue(true);   //if this condion is false then remaining steps from test case are skip & it directly jumps to next test case
		
		System.out.println("Execution Completed");
		
		soft.assertAll(); //It collect the result of all the assertion & 
		                     //in case if there is any failure then it throws exception after completion of all execution 

	}
	    
	    @Test
	    public void Test2() {
	
		SoftAssert soft = new SoftAssert();
	
		System.out.println("Execution Started Test2");
		
		soft.assertEquals(true , true);
		
		soft.assertTrue(true);
		
		System.out.println("Execution Completed Test2");
		
		soft.assertAll(); //It collect the result of all the assertion & 
		                     //in case if there is any failure then it throws exception after completion of all execution 

	}
}
