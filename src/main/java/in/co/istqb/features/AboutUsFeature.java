package in.co.istqb.features;

import org.openqa.selenium.WebDriver;

import in.co.istqb.steps.AboutUsSteps;

public class AboutUsFeature {
	AboutUsSteps aus;
	
	public AboutUsFeature(WebDriver driver){
		aus=new AboutUsSteps(driver);
	}
	public void compList(){
		aus.mouseHoverAndClick();
	}
	
}
