package com.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {
	
  public static WebDriver driver;
  
  LoginPage objLogin;
  
  DashboardPage objDashBoardPage;
  
  @BeforeClass
  public void beforeClass() {
	  
	  driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
