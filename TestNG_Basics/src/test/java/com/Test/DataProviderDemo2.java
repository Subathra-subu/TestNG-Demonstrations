package com.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProviderDemo2 { // Parallel execution
	
	private static final ThreadLocal <WebDriver> driver=new ThreadLocal <WebDriver>();
	
	 
	@Test(dataProvider = "dp", dataProviderClass=DataProviderClass.class)
	  public void search(String keyWord) {
		 
		 WebDriver driver1 = driver.get();
		 
		 driver1.get("https://www.bing.com/");
		  
		  WebElement element = driver1.findElement(By.id("sb_form_q"));
		  
		  element.sendKeys(keyWord);
		  
		  System.out.println("Keyword: "+keyWord);
		  
		  element.sendKeys(Keys.ENTER);
		  
		  System.out.println("Search result is displayed");
	  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Start the test");
	  driver.set(new ChromeDriver());
  }

  @AfterMethod
  public void afterMethod() {
	  
	  WebDriver driver1 = driver.get();
	  if(driver1 != null)
		  driver1.quit();
  }
}
