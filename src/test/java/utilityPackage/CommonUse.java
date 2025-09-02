package utilityPackage;

public class CommonUse extends driverPackage.BaseDriver{

	   // Sleep (Thread.sleep wrapped safely)
 public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	

}
