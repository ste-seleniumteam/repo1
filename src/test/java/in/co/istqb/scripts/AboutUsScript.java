package in.co.istqb.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;

public class AboutUsScript extends BaseAbstractTest{
	
	@Test
	@Severity(SeverityLevel.MINOR)
	@Description("Performing mouse hover on About Us")
	@Step("mouse hove: {0}")
	public void aboutUsPerform(){
		auf.compList();
	}
}
