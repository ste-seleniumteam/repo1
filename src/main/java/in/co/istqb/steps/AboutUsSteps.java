package in.co.istqb.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import in.co.istqb.pageObjects.HomePage;
import io.qameta.allure.Step;

public class AboutUsSteps {
	WebDriver driver;
	HomePage hp;
	
	public AboutUsSteps(WebDriver driver){
		this.driver=driver;
		hp=new HomePage();
	}
	@Step("mouse hove: {0}")
	public void mouseHoverAndClick(){
		WebElement target = driver.findElement(By.xpath(hp.xpAboutUs));
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();
		act.click(driver.findElement(By.xpath(hp.xpAffComp))).perform();
	}
}
