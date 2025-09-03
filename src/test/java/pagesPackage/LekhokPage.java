package pagesPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import driverPackage.PageDriver;
import utilityPackage.CommonUse;
import utilityPackage.GetScreenShots;

public class LekhokPage extends CommonUse {
	

	ExtentTest test;
	
	 public LekhokPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
		//	sleep(2000);
}
	
	 @FindBy(xpath = "//*[@id=\"main_content\"]/div/div/ul/li[2]/a[2]")WebElement authorName;
	 
	 
	 public void clickOnNext() throws Exception {
		 
		 JavascriptExecutor js = (JavascriptExecutor) PageDriver.getCurrentDriver();
		 
		 while(true) {
			 try {
				 
				 WebElement nextBtn = PageDriver.getCurrentDriver().findElement(By.xpath("//*[@id=\"main_content\"]/div/div/div[3]/nav/ul/li[9]/a"));
				   js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
		            nextBtn.click();
		            test.pass("<p style=\"color:#00FF00; font-size:13px\"><b>Next Field Founded " + "</b></p>");
		            break;
				 
				
			} catch (Exception e) {
				 js.executeScript("window.scrollBy(0,500)");
				 test.fail("<p style=\"color:#FF3535; font-size:13px\"><b>Next Button is not found " + e.getMessage() + "</b></p>");
				  
				  Throwable t= new InterruptedException("Exception");
				  test.fail(t);
				  @SuppressWarnings("unused")
				  
				  String next ="nextButton";
				  
				    String screenshotPath = GetScreenShots.capture(PageDriver.getCurrentDriver(),next);
				    test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			}
			 
			 
		 }
		 
			
		}
	 
	 
	 
	 public void selectAuthor() throws Exception {
		 
		 
		 try {
			 if (authorName.isDisplayed()) {
				 
				 authorName.click();
			
				 test.pass("<p style=\"color:#00FF00; font-size:13px\"><b>Click on Author Name" + "</b></p>");
				 
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			test.fail("<p style=\"color:#FF3535; font-size:13px\"><b>Email Field Not Found " + e.getMessage() + "</b></p>");
			  
			  Throwable t= new InterruptedException("Exception");
			  test.fail(t);
			  @SuppressWarnings("unused")
			  String authNAme = "authorName";
			    String screenshotPath = GetScreenShots.capture(PageDriver.getCurrentDriver(), authNAme);
			    test.fail("Screenshot:", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		 
		 
	 }
			
	
			
			
		 
	 }
	 
	 
	 


