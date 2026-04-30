package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
	
	@FindBy (xpath="//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	public WebElement dashBoard;
	
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	public String getHomePage() {
		return dashBoard.getText();
	}

}
