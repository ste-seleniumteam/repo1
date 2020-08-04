package in.co.istqb.webutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver launchBrowser(String browser){
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			Reporter.log("chrome browser launched", true);
		}
		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
			Reporter.log("Firefox browser launched", true);
		}
		
		return driver;
	}
}
