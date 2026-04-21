package com.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo1 { // Used to provide multiple data to same class
	
	public WebDriver driver;
	
  @DataProvider(name="testData")
  public Object[][] dataProvideFunc(){
	  return new Object[][] {{"Selenium"},{"TestNG"}};
  }
	
  @Test(dataProvider = "testData")
  public void search(String keyWord) {
	  
	  WebElement element = driver.findElement(By.id("sb_form_q"));
	  
	  element.sendKeys(keyWord);
	  
	  System.out.println("Keyword: "+keyWord);
	  
	  element.sendKeys(Keys.ENTER);
	  
	  System.out.println("Search result is displayed");
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Start the test");
	  driver = new ChromeDriver();
	  driver.get("https://www.bing.com/");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
