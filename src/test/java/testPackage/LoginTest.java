package testPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import driverPackage.BaseDriver;
import driverPackage.PageDriver;
import pagesPackage.HomePage;
import pagesPackage.LoginPage;
import utilityPackage.DataSet;
import utilityPackage.ExtentFactory;

public class LoginTest extends BaseDriver {
	
	ExtentReports report;
	ExtentTest parentTest,childTest,ch1;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		
		PageDriver.getCurrentDriver().manage().window().maximize();
		PageDriver.getCurrentDriver().get(url);
	//	Thread.sleep(5000);
		
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<span style=\\\"color:#1E90FF; font-size:16px; font-weight:bold;\\\">Homepage</span>");
		
		
		
	}
	
	
	@Test(priority = 1)
	public void clickLoginBtn() throws InterruptedException, Exception {
		
		childTest = parentTest.createNode("<span style=\"color:#FF8C00; font-size:14px; font-weight:bold;\">Login Button Test</span>");

		
		HomePage  homepage = new HomePage(childTest);
		
		homepage.clickLoginBtn();
	
	}
	
	@Test(priority =2,dataProvider ="loginData",dataProviderClass = DataSet.class  )
	public void login(String email, String pass) throws Exception {
		ch1= parentTest.createNode("<span style=\"color:#FF8C00; font-size:14px; font-weight:bold;\">Email and Password</span>");

		LoginPage loginPage = new LoginPage(ch1);
		
		loginPage.login(email, pass);
		
		
	}
	
	
	
	
	@AfterClass
	public void afterClass() {
		report.flush();
	}
	

}
