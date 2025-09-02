package utilityPackage;

import org.testng.annotations.DataProvider;

public class DataSet {

	@DataProvider(name = "loginData")
	public static Object loginData() {
		
		Object[][] objects = {{"niaz.ju.cse@gmail.com","1234567890"}};
		
		
		return objects;
		
	}
}
