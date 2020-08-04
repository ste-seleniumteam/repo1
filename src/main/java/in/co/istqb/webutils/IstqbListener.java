package in.co.istqb.webutils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

import in.co.istqb.generic.Driver;

public class IstqbListener implements ITestListener,WebDriverEventListener{
	
	public static int passCount,skipCount,failCount,executeCount =0;
	long startTime,totalTime;
	
	@Override
	public void onException(Throwable t, WebDriver d) {
		Reporter.log("Exception type:"+t.getMessage(), true);
	}
	
	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Total Pass="+passCount, true);
		Reporter.log("Total skipCount="+skipCount, true);
		Reporter.log("Total failCount="+failCount, true);
		Reporter.log("Total executeCount="+executeCount, true);
		totalTime = System.currentTimeMillis()-startTime;
		Reporter.log("Total execution time:"+totalTime, true);
		Driver.getwDriver().close();
	}

	@Override
	public void onStart(ITestContext context) {
		startTime = System.currentTimeMillis();
		WebDriver driver = BrowserFactory.launchBrowser("chrome");
		Driver.setwDriver(driver);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot ts=(TakesScreenshot)Driver.getwDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File desc=new File("./Istqb/screenshot"+result.getName()+".png");
		try{
			Files.copy(src, desc);
		}
		catch(IOException io){
			io.getCause();
			io.printStackTrace();
		}
		failCount++;
		Reporter.log("Failed"+result.getName(), true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		skipCount++;
		Reporter.log("Skipped"+result.getName(), true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		executeCount++;
		Reporter.log("Execution start"+result.getName(), true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		passCount++;
		Reporter.log("TestSucess"+result.getName(), true);
	}

	@Override
	public void afterAlertAccept(WebDriver arg0) {
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
	
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		
	}

	@Override
	public void afterGetText(WebElement arg0, WebDriver arg1, String arg2) {
		
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
	}

	@Override
	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {	
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {	
	}

	@Override
	public void beforeGetText(WebElement arg0, WebDriver arg1) {
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
	}

	@Override
	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
	}
		
}
