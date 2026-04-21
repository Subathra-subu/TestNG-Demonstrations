package com.Test;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

  @DataProvider(name="dp",parallel=true)
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"Selenium"},{"TestNG"},{"Automation"}
    };
  }
}
