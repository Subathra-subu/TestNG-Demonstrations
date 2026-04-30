package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	By userName = By.name("username");
	By password = By.name("password");
	By login = By.xpath("//button[@type='submit']");
	By title = By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	// Send UserName
	public void setUserName(String strUserName) {
		driver.findElement(userName).sendKeys(strUserName);
	}
	
	
	// Send password
	public void setPassword(String strPassword) {
		driver.findElement(password).sendKeys(strPassword);
	}
	
	//Click login
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	//Get Title
	public String getLoginTitle() {
		return driver.findElement(title).getText();
	}
	
	
	public void login(String strUserName,String strPassword) {
		
		this.setUserName(strUserName);
		
		this.setPassword(strPassword);
		
		this.clickLogin();
	}

}
