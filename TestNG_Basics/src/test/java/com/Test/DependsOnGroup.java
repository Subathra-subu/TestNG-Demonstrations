package com.Test;

import org.testng.annotations.Test;

public class DependsOnGroup {
	
	 @Test
	  public void B() {
		  
		  System.out.println("Hello");
	  }
	  
	  @Test
	  public void C() {
		  System.out.println("Welcome");
	  }
	  
	  @Test
	  public void A() {
		  System.out.println("Hi");
	  }

}
