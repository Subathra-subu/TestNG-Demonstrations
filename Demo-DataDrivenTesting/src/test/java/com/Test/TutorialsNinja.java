package com.Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Utilities.TestData;

public class TutorialsNinja {

  private static final ThreadLocal <WebDriver> driver=new ThreadLocal <WebDriver>();
  
  @BeforeMethod
	 public void beforeMethod() {
		  
	 System.out.println("Start the test");
	 driver.set(new ChromeDriver());
   }
	

  @Test(dataProvider="ValidLoginData",dataProviderClass = TestData.class)
  public void validLogin(String email,String password) {
	  
	  WebDriver driver1 = driver.get();
		 
	  driver1.manage().window().maximize();
		 
	  driver1.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	  
	  driver1.findElement(By.xpath("//span[@class=\"caret\"]")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver1,Duration.ofSeconds(5));
	  
	  WebElement loginLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Login\"]")));
	  
	  loginLink.click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-email']"))).sendKeys(email);
	  
	  driver1.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(password);

	  driver1.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	  
	  String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"content\"]/child::h2[1]"))).getText();
	  
	  assertEquals(actual,"My Account");
	  
	  System.out.println("Login Successful!!");
	  
	  }
  
  
  @Test(dataProvider="InValidLoginData",dataProviderClass = TestData.class)
  public void invalidLogin(String email,String password) {
	  
	  WebDriver driver1 = driver.get();
		 
	  driver1.manage().window().maximize();
		 
	  driver1.get("https://tutorialsninja.com/demo/index.php?route=common/home");
	  
	  driver1.findElement(By.xpath("//span[@class=\"caret\"]")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver1,Duration.ofSeconds(5));
	  
	  WebElement loginLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Login\"]")));
	  
	  loginLink.click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-email']"))).sendKeys(email);
	  
	  driver1.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(password);

	  driver1.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	  
	  WebElement alert = driver1.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]"));
	  
	  System.out.println(alert.getText());
  }
  
  
  @Test
  @Parameters({"url","keyWord"})
  public void Search(String url,String keyWord) {
	  
	  WebDriver driver1 = driver.get();
		 
	  driver1.manage().window().maximize();
		 
	  driver1.get(url);
	  
	  WebElement search = driver1.findElement(By.xpath("//input[@name='search']"));
	  
	  search.sendKeys(keyWord);
	  
	  WebElement searchButton = driver1.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
	  
	  searchButton.click();
	  
	  WebDriverWait wait = new WebDriverWait(driver1,Duration.ofSeconds(10));
	  
	  String searchOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"caption\"]/child::h4/child::a[1]"))).getText();
	  
	  Assert.assertTrue(searchOptions.toLowerCase().contains(keyWord.toLowerCase()),"Search not found");
	  
	  System.out.println("Search items are displayed!");
	  
  }
  
  
  @AfterMethod
  public void afterMethod() {
	  
	  WebDriver driver1 = driver.get();
	  if(driver1 != null)
		  driver1.quit();
  }
}
