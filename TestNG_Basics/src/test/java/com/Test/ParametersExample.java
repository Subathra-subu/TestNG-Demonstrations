package com.Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {
	
  @Test
  @Parameters({"val1","val2"})
  public void sum(int val1,int val2) {
	  System.out.print(val1+val2);
  }
  
  @Test
  @Parameters({"val1","val2"})
  public void sub(int val1,int val2) {
	  System.out.print(val1-val2);
	  }
}
