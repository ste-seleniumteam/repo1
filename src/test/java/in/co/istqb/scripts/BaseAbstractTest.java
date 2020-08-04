package in.co.istqb.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import in.co.istqb.features.AboutUsFeature;
import in.co.istqb.generic.Driver;
import in.co.istqb.pageObjects.HomePage;
import in.co.istqb.webutils.IstqbListener;

public class BaseAbstractTest {
	public static EventFiringWebDriver driver;
	AboutUsFeature auf;
	HomePage hp=new HomePage();
	
	@BeforeClass
	public void setUp(){
		driver=new EventFiringWebDriver(Driver.getwDriver());
		driver.register(new IstqbListener());
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://istqb.in/");
		auf=new AboutUsFeature(driver);
	}
	
	
}
