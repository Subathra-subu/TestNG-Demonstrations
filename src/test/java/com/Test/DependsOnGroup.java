package com.Test;

import org.testng.annotations.Test;

public class DependsOnGroup {
	
	 @Test(groups="groupA")
	  public void B() {
		  
		  System.out.println("Hello");
	  }
	  
	  @Test(groups="groupB")
	  public void C() {
		  System.out.println("Welcome");
	  }
	  
	  @Test(dependsOnGroups="groupA")
	  public void A() {
		  System.out.println("Hi");
	  }

}
