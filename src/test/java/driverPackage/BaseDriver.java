package driverPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver extends PageDriver {


		
		public static String url = "https://www.wafilife.com/";
		 protected static WebDriver driver;

		    @BeforeSuite
		    public static void setupDriver() {
		    	
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		        
		        PageDriver.getInstance().setDriver(driver);
		     //   driver.get(url);
		        
		    }
		    
		    @AfterSuite
		    public void tearDown() {
		       // if (driver != null) 
		    	{
		    		PageDriver.getCurrentDriver().quit();
		        }
		    }
	}
	
	
	
