package pagesPackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.sun.tools.javap.TryBlockWriter;

import driverPackage.PageDriver;
import utilityPackage.CommonUse;
import utilityPackage.GetScreenShots;

public class MyAccount extends CommonUse{
	
	
	ExtentTest test;
	
	 public MyAccount(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
		}
	 
	 
	 @FindBy(xpath = "//*[@id=\"menu-main-menu-1\"]/li[6]/a/span")WebElement lekhok;
	 
	 
	 
	 
	 
	 public void clickLekhok() throws Exception {
		 try {
			 if (lekhok.isDisplayed()) {
				 lekhok.click();
				 test.pass("<p style=\"color:#00FF00; font-size:13px\"><b>Lekhok option found and Click " + "</b></p>");
				
			}
			
		} catch (Exception e) {
			test.fail("<p style=\"color:#FF3535; font-size:13px\"><b>Email Field Not Found " + e.getMessage() + "</b></p>");
			  
			  Throwable t= new InterruptedException("Exception");
			  test.fail(t);
			  @SuppressWarnings("unused")
			  String lekhokBtn = "lekhokOption";
			    String screenshotPath = GetScreenShots.capture(PageDriver.getCurrentDriver(), lekhokBtn);
			    test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			
		}
		
	}
	 
}
