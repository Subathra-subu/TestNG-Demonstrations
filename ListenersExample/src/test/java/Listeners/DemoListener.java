package Listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DemoListener implements ITestListener  {

	    public void onTestFailure(ITestResult result) {
	    	
	    		WebDriver driver = NewTest.getDriver();
	    		
	    		try {
	    		TakesScreenshot screen = (TakesScreenshot) driver;
	    		
	    		File source = screen.getScreenshotAs(OutputType.FILE);
	    		
	    		FileUtils.copyFile(source,new File("./Screenshots/Screen.png"));
	    		}
	    		catch(Exception e){
	    			System.out.print(e);
	    		}
	    		
	        System.out.println("Test FAILED: " + result.getName());
	    }

	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test SKIPPED: " + result.getName());
	    }

	    public void onTestStart(ITestResult result) {
	        System.out.println(result.getName() + " test started");
	    }

	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test PASSED: " + result.getName());
	    }

}
