package com.Test;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class NewTest {
	
	public WebDriver driver;
	
 @AfterMethod
  public void afterMethod() {
	  
	  driver.close();
  }
	
 
  @Test
  @Parameters({"v_user","v_pass"})
  public void LoginValidation(String v_user,String v_pass) {
	  
	  driver.findElement(By.id("login2")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(v_user);
	  
	  driver.findElement(By.id("loginpassword")).sendKeys(v_pass);
	  
	  driver.findElement(By.xpath("//button[text()='Log in']")).click();
	  
	  String ExpectedMessage = "Log out";
	  
	  String Actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2"))).getText();
	  
	  Assert.assertEquals(Actual,ExpectedMessage);
	  System.out.println("Login Successfull");
	  
	}
  
  @Test
  @Parameters({"p_user","p_pass"})
  public void InvalidLogin_Password(String p_user,String p_pass) {
	  
	  driver.findElement(By.id("login2")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(p_user);
	  
	  driver.findElement(By.id("loginpassword")).sendKeys(p_pass);
	  
	  driver.findElement(By.xpath("//button[text()='Log in']")).click();
	  
	  wait.until(ExpectedConditions.alertIsPresent());
	  
	  Alert alert = driver.switchTo().alert();
	  
	  String Expected = "Wrong password.";
	  
	  String alert_message = alert.getText();
	  
	  Assert.assertEquals(alert_message,Expected);
	  System.out.println("Incorrect Password");
	  
	  alert.accept();
  } 
  
  @Test
  @Parameters({"u_user","u_pass"})
  public void InvalidLogin_UserName(String u_user,String u_pass) {
	  
	  driver.findElement(By.id("login2")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(u_user);
	  
	  driver.findElement(By.id("loginpassword")).sendKeys(u_pass);
	  
	  driver.findElement(By.xpath("//button[text()='Log in']")).click();
	  
	  wait.until(ExpectedConditions.alertIsPresent());
	  
	  Alert alert = driver.switchTo().alert();
	  
	  String Expected = "Wrong password.";
	  
	  String alert_message = alert.getText();
	  
	  Assert.assertEquals(alert_message,Expected);
	  System.out.println("Incorrect UserName");
	  
	  alert.accept();
	  
  }
  
  
  @BeforeMethod
  @Parameters({"browser","Url"})
  public void beforeMethod(String browser,String Url) {
	  
	  if(browser.equals("Chrome")) {
	  
	  ChromeOptions options = new ChromeOptions();
	  
	  options.addArguments("--start-maximized");
//	  options.addArguments("--headless");
	  
	  driver = new ChromeDriver(options);
	  
	  driver.get(Url);
	  }
  
	  else if(browser.equals("FireFox")) {
		  
		  FirefoxOptions options = new FirefoxOptions();
		  
		  options.addArguments("--start-maximized");
//		  options.addArguments("--headless");
		  
		  driver = new FirefoxDriver(options);
		  
		  driver.get(Url);
		  
	  }
  }
}
