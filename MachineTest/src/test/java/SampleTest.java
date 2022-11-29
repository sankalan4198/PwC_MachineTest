package test.java;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import main.java.pageEvent.FlipkartAutomation;
import main.java.pageEvent.SearchPageEvent;
import main.java.pageObject.HomePageElements;
import main.java.utils.Constants;
public class SampleTest extends BaseTest {
	
	@Test(priority=1)
	public void FlipkartAutomation() throws Exception
	{
		FlipkartAutomation fa=new FlipkartAutomation();
		
		fa.setupDriver();
		fa.beforeMethoMethod();
		fa.urlLaunch();
		fa.searchMobile();
		fa.scrollToIphone();
		fa.getPrice();
		
	}
	
	@AfterMethod
	public void afterMethodMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			String methodName= result.getMethod().getMethodName();
			String  logText="TestMethod: "+methodName+" Passed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS, m);
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			String methodName= result.getMethod().getMethodName();
			String  logText="TestMethod: "+methodName+" Failed";
			Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL, m);
		}
		driver.quit();
	}

	
	
}
