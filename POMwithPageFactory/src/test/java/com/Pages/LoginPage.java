package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (name = "username")
	public WebElement userName;
	
	@FindBy (name="password")
	public WebElement password;

	@FindBy (xpath="//button[@type='submit']")
	public WebElement login;
	
	@FindBy (xpath="//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
	public WebElement title;
	
	
	// Send UserName
	public void setUserName(String strUserName) {
		userName.sendKeys(strUserName);
	}
	
	
	// Send password
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	
	//Click login
	public void clickLogin() {
		login.click();
	}
	
	//Get Title
	public String getLoginTitle() {
		return title.getText();
	}
	
	
	public void login(String strUserName,String strPassword) {
		
		this.setUserName(strUserName);
		
		this.setPassword(strPassword);
		
		this.clickLogin();
	}

}
