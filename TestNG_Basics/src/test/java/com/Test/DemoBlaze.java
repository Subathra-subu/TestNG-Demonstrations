package com.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoBlaze {
	
	private static final ThreadLocal <WebDriver> driver=new ThreadLocal <WebDriver>();
  
	 @BeforeMethod
	  public void beforeMethod() {
		  
		  System.out.println("Start the test");
		  driver.set(new ChromeDriver());
	  }
	 
	 @Test
	  @Parameters({"Url","v_user","v_pass"})
	  public void LoginValidation(String Url,String v_user,String v_pass) {
		 
		 WebDriver driver1 = driver.get();
		 
		 driver1.manage().window().maximize();
		 
		 driver1.get(Url);
		  
		  driver1.findElement(By.id("login2")).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver1,Duration.ofSeconds(10));
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(v_user);
		  
		  driver1.findElement(By.id("loginpassword")).sendKeys(v_pass);
		  
		  driver1.findElement(By.xpath("//button[text()='Log in']")).click();
		  
		  String ExpectedMessage = "Log out";
		  
		  String Actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2"))).getText();
		  
		  Assert.assertEquals(Actual,ExpectedMessage);
		  System.out.println("Login Successfull");
		  
		}
	 
	 @DataProvider(name="testData")
	  public Object[][] dataProvideFunc(){
		  return new Object[][] {{"bcjrfi","admin"},{"admin","ad"}};
	  }
	 
	 @Test(dataProvider="testData")
	  public void InvalidLogin(String userName,String password) {
		 
		 WebDriver driver2 = driver.get();
		 
		 driver2.manage().window().maximize();
		 
		 driver2.get("https://www.demoblaze.com/");
		  
		  driver2.findElement(By.id("login2")).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver2,Duration.ofSeconds(10));
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(userName);
		  
		  driver2.findElement(By.id("loginpassword")).sendKeys(password);
		  
		  driver2.findElement(By.xpath("//button[text()='Log in']")).click();
		  
		  wait.until(ExpectedConditions.alertIsPresent());
		  
		  Alert alert = driver2.switchTo().alert();
		  
		  String alert_message = alert.getText();
		  
		  Assert.assertTrue(alert_message.equals("Wrong password.") || 
				  alert_message.equals("User does not exist.")
		  );
		  System.out.println(alert.getText());
		  
		  alert.accept();
	  }
	 

	  @AfterMethod
	  public void afterMethod() {
		  
		  WebDriver driver1 = driver.get();
		  if(driver1 != null)
			  driver1.quit();
	  }
}
