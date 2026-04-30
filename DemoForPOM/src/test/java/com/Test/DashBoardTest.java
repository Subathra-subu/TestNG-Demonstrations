package com.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import com.Utilities.Data;


public class DashBoardTest extends BaseTest {
  @Test(dataProvider="ValidData",dataProviderClass=Data.class)
  public void dashBoardTest(String userName,String password) {
	  
	  objLogin = new LoginPage(driver);
	  
	  objLogin.login(userName,password);
	  
	  objDashBoardPage = new DashboardPage(driver);
	  
	  Assert.assertTrue(objDashBoardPage.getHomePage().contains("Dashboard"));
	  
  }
}
