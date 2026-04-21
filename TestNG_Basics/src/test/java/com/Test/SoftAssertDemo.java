package com.Test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {
		
		public WebDriver driver;
		
		
	 @AfterMethod
	  public void afterMethod() {
		  
		  driver.close();
	  }
		
	 
	  @Test
	  public void LoginValidation() {
		  
		  driver.findElement(By.id("login2")).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("admin");
		  
		  driver.findElement(By.id("loginpassword")).sendKeys("admin");
		  
		  driver.findElement(By.xpath("//button[text()='Log in']")).click();
		  
		  String ExpectedMessage = "Log out";
		  
		  String Actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2"))).getText();
		  
		  SoftAssert sa = new SoftAssert();
		  
		  sa.assertEquals(Actual,ExpectedMessage);
		  System.out.println("Login Successfull");
		  
		  sa.assertAll();
		  
		}
	  
	  @Test
	  public void InvalidLogin_Password() {
		  
		  driver.findElement(By.id("login2")).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("admin");
		  
		  driver.findElement(By.id("loginpassword")).sendKeys("ad");
		  
		  driver.findElement(By.xpath("//button[text()='Log in']")).click();
		  
		  wait.until(ExpectedConditions.alertIsPresent());
		  
		  Alert alert = driver.switchTo().alert();
		  
		  String Expected = "Wrong password.";
		  
		  String alert_message = alert.getText();
		  
		  SoftAssert sa = new SoftAssert();
		  
		  sa.assertNotEquals(alert_message,Expected,"Incorrect Password");
		  
		  alert.accept();
		  
		  sa.assertAll();
	  }
	  
	  @Test
	  public void InvalidLogin_UserName() {
		  
		  driver.findElement(By.id("login2")).click();
		  
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("a");
		  
		  driver.findElement(By.id("loginpassword")).sendKeys("admin");
		  
		  driver.findElement(By.xpath("//button[text()='Log in']")).click();
		  
		  wait.until(ExpectedConditions.alertIsPresent());
		  
		  Alert alert = driver.switchTo().alert();
		  
		  String Expected = "Wrong password.";
		  
		  String alert_message = alert.getText();
		  
		  SoftAssert sa = new SoftAssert();
		  
		  sa.assertEquals(alert_message,Expected);
		  System.out.println("Incorrect UserName");
		  
		  alert.accept();
		  
		  sa.assertAll();
		  
	  }
	  
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  
		  ChromeOptions options = new ChromeOptions();
		  
		  options.addArguments("--start-maximized");
		  options.addArguments("--headless");
		  
		  driver = new ChromeDriver(options);
		  
		  driver.get("https://www.demoblaze.com/");
		  
	  }
}
