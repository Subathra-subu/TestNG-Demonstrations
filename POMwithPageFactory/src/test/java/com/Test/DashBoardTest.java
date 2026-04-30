package com.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;


public class DashBoardTest extends BaseTest {
  @Test
  public void dashBoardTest() {
	  
	  objLogin = new LoginPage(driver);
	  
	  objLogin.login("Admin","admin123");
	  
	  objDashBoardPage = new DashboardPage(driver);
	  
	  Assert.assertEquals(objDashBoardPage.getHomePage(),"Dashboard");
	  
  }
}
