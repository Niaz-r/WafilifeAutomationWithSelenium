package testPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import driverPackage.BaseDriver;
import driverPackage.PageDriver;
import pagesPackage.HomePage;
import pagesPackage.LekhokPage;
import pagesPackage.MyAccount;
import utilityPackage.ExtentFactory;

public class LekhokOptionTest extends BaseDriver {
	
	ExtentReports report;
	ExtentTest parentTest,childTest,ch1,ch2;
	
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		
	//	PageDriver.getCurrentDriver().manage().window().maximize();
	//	PageDriver.getCurrentDriver().get(url);
	//	Thread.sleep(5000);
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<span style=\\\"color:#1E90FF; font-size:16px; font-weight:bold;\\\">MyAccount</span>");
		
		
		
	}

    @Test(priority = 1)
    public void selectlekhok() throws Exception {

		childTest = parentTest.createNode("<span style=\"color:#FF8C00; font-size:14px; font-weight:bold;\">Select From Lekhok</span>");

		
		MyAccount  myAccount = new MyAccount(childTest);
		
		myAccount.clickLekhok();
		
 
    }
    
    @Test(priority = 2)
    public void clickNext() throws Exception {
    	ch1= parentTest.createNode("<span style=\"color:#FF8C00; font-size:14px; font-weight:bold;\">Next Button On lekhok</span>");
 
    LekhokPage lekhokPage = new LekhokPage(ch1);
    lekhokPage.clickOnNext();
    
    }
    
    
    @Test(priority = 3)
    public void clickAuthor() throws Exception {
    	ch2= parentTest.createNode("<span style=\"color:#FF8C00; font-size:14px; font-weight:bold;\">Author Name</span>");
 
    LekhokPage lekhokPage = new LekhokPage(ch1);
    
    lekhokPage.selectAuthor();
    
    }
    
    
    
    
	

	@AfterClass
	public void afterClass() {
		report.flush();
	}
	

 

}
