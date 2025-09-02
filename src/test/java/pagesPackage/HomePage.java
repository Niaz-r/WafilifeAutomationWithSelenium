package pagesPackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentReporter;

import driverPackage.PageDriver;
import utilityPackage.CommonUse;
import utilityPackage.GetScreenShots;

public class HomePage extends CommonUse {
	
	ExtentTest test;
	
	 public HomePage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	//	sleep(2000);
		
	}
	 
	 @FindBy(xpath = "//*[@id=\"header\"]/div/div[1]/div/div[3]/div/a[2]")WebElement loginBtn;
	 
	 String loginButton;
	 
	 public void clickLoginBtn() throws Exception,InterruptedException {
		 
		 try {
			 if(loginBtn.isDisplayed()) {
				 loginBtn.click();
				 test.pass("<p style=\"color:#00FF00; font-size:13px\"><b>Login Button found " + "</b></p>");
				 sleep(3000);
				  
			 }
			
		} catch (Exception e) {
			
			test.fail("<p style=\"color:#FF3535; font-size:13px\"><b>Login Button is not found " + e.getMessage() + "</b></p>");
			  
			  Throwable t= new InterruptedException("Exception");
			  test.fail(t);
			  @SuppressWarnings("unused")
			  
			    String screenshotPath = GetScreenShots.capture(PageDriver.getCurrentDriver(),loginButton);
			    test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			 //   Assert.class (firstName.isDisplayed());
			    PageDriver.getCurrentDriver().quit();
		}
		 
		 
		
	}
	 

}
