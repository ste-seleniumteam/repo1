package in.co.istqb.generic;

import org.openqa.selenium.WebDriver;

public class Driver {
	
	private static  WebDriver wDriver;
	
	public static WebDriver getwDriver() {
		return wDriver;
	}

	public static void setwDriver(WebDriver wDriver) {
		Driver.wDriver = wDriver;
	}
	

}
