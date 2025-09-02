package utilityPackage;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShots {

    public static String capture(WebDriver driver, String screenShotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

    //    String dest = System.getProperty("user.dir") + "/ScreenShots/" + screenShotName + ".png";
        
        String dest = System.getProperty("user.dir") 
                + File.separator + "ScreenShots" 
                + File.separator + screenShotName + ".png";
        File destination = new File(dest);

        // Ensure folder exists
        destination.getParentFile().mkdirs();

        FileUtils.copyFile(source, destination);

        return dest;
    }
}
