package pagesPackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import driverPackage.PageDriver;
import utilityPackage.CommonUse;
import utilityPackage.GetScreenShots;

public class LoginPage extends CommonUse{
	
	
	ExtentTest test;
	
	 public LoginPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
		//	sleep(2000);
}
	 
	 
	 @FindBy(xpath = "//*[@id=\"username\"]")WebElement emailBox;
	
	 @FindBy(xpath = "//*[@id=\"password\"]")WebElement passBox;
	 
	 
	 public void login(String email, String pass) throws Exception {
		 
		 try {
			 if (emailBox.isDisplayed()) {
				 
				 emailBox.clear();
				 emailBox.sendKeys(email);
				 sleep(1000);
				 test.pass("<p style=\"color:#00FF00; font-size:13px\"><b>Email Text Field Founded " + "</b></p>");
			}
			
		} catch (Exception e) {
			test.fail("<p style=\"color:#FF3535; font-size:13px\"><b>Email Field Not Found " + e.getMessage() + "</b></p>");
			  
			  Throwable t= new InterruptedException("Exception");
			  test.fail(t);
			  @SuppressWarnings("unused")
			  String emailTextBox = "emailTextBox";
			    String screenshotPath = GetScreenShots.capture(PageDriver.getCurrentDriver(), emailTextBox);
			    test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		 
		 try {
			 if (passBox.isDisplayed()) {
				passBox.clear();
				passBox.sendKeys(pass);
				 test.pass("<p style=\"color:#00FF00; font-size:13px\"><b>Password Text Field Founded " + "</b></p>");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			test.fail("<p style=\"color:#FF3535; font-size:13px\"><b>Email Field Not Found " + e.getMessage() + "</b></p>");
			  
			  Throwable t= new InterruptedException("Exception");
			  test.fail(t);
			  @SuppressWarnings("unused")
			  String passTextBox = "passTextBox";
			    String screenshotPath = GetScreenShots.capture(PageDriver.getCurrentDriver(), passTextBox);
			    test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
	}

}

