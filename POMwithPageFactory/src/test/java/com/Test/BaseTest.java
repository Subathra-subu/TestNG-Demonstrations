package com.Test;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;

import org.testng.annotations.*;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
  public static WebDriver driver;
  
  LoginPage objLogin;
  
  DashboardPage objDashBoardPage;
  
  @BeforeMethod
  public void beforeClass() {
	  
	  ChromeOptions options= new ChromeOptions();
	  
	  options.addArguments("--remote-allow-origins=*");
	  
	  driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
  }

  @AfterMethod
  public void afterClass() {
	  
	  driver.close();
  }

}
