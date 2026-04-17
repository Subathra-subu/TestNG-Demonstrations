package com.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssertions {
  @Test
  public void testAssertions() {
	  
	  String str1 = new String("TestNG");
	  String str2 = new String("TestNG");
	  String str3 = null;
	  String str4 = "TestNG";
	  String str5 = "TestNG";
	  String str6 = new String("Not TestNG");
	  
	  int val1 = 10;
	  int val2 = 28;
	  
	  Assert.assertEquals(str1, str4); 
	  System.out.println("Equal Assertion is successful");
	  
	  Assert.assertNotEquals(str1, str6); 
	  System.out.println("Not Equal Assertion is successful");
	  
	  Assert.assertTrue(val1 < val2);
	  System.out.println("True Assertion is successful"); 
	  
	  Assert.assertFalse(val1 > val2);
	  System.out.println("False Assertion is successful"); 
	  
	  Assert.assertSame(str4, str5);
	  System.out.println("Same Assertion is successful");
	  
	  Assert.assertNotSame(str5, str6);
	  System.out.println("Not Same Assertion is successful");
	  
	  Assert.assertNull(str3);
	  System.out.println("Null Assertion is successful"); 
	  
	  Assert.assertNotNull(str1);
	  System.out.println("Not Null Assertion is successful"); 
	  
  }
}
