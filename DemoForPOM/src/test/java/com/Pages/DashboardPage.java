package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	WebDriver driver;
	
	By dashBoard = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getHomePage() {
		return driver.findElement(dashBoard).getText();
	}

}
