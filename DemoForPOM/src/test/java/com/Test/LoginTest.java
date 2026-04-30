package com.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.LoginPage;

public class LoginTest extends BaseTest{
	
	
  @Test(priority=0)
  public void loginText() {
	  
	 objLogin = new LoginPage(driver);
	 
	 String loginPageTitle = objLogin.getLoginTitle();
	 Assert.assertTrue(loginPageTitle.contains("Login"));
  }
  
}
