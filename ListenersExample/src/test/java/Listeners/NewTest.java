package Listeners;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import com.Utilities.DataProvider_Class;
 


@Listeners(DemoListener.class)
public class NewTest {
	
	private static final ThreadLocal <WebDriver> driver = new ThreadLocal <WebDriver>();
	 
	 public static Logger log = LogManager.getLogger(NewTest.class);
	 
	 public static WebDriver getDriver() {
		 return driver.get();
	 }
	 
  
  @Test(dataProvider="data",dataProviderClass=DataProvider_Class.class)
  public void LoginTest(String email,String password) {
	  
	  WebDriver driver1 = driver.get();
	  
	  log.info("Browser launched.TutorialsNinja website launching");
	  
	  driver1.findElement(By.xpath("//span[@class=\"caret\"]")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver1,Duration.ofSeconds(5));
	  
	  WebElement loginLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"Login\"]")));
	  
	  loginLink.click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-email']"))).sendKeys();
	  
	  driver1.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(password);

	  driver1.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	  
	  String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"content\"]/child::h2[1]"))).getText();
	  
	  assertEquals(actual,"My Account");
	  
	  log.info("Login Successful!!");
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  WebDriver driver1 = new ChromeDriver();
	  
	  driver.set(driver1);
	  
	  driver1.manage().window().maximize();
	  
	  driver1.get("https:tutorialsninja.com/demo/index.php?route=common/home");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  WebDriver driver1 = driver.get();
	  
	  if(driver1!=null) {
		  driver1.quit();
	  }
  }

}
