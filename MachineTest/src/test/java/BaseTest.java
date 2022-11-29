package test.java;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.netty.util.Constant;
import main.java.pageEvent.FlipkartPageEvent;
import main.java.utils.Constants;
import main.java.pageObject.HomePageElements;

public class BaseTest {
	
	public static WebDriver driver;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	
	
	public void beforeTestMethod()
	{
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"AutomationReports.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Sankalan PC");
	}
	
	
	
	public void beforeMethodMethod(String browserName, Method testMethod)
	{
		
		logger=extent.createTest(testMethod.getName());
		setupDriver(browserName);
		driver.manage().window().maximize();
		driver.navigate().to(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	
	public void afterTestMethod()
	{
		extent.flush();
	}
	
	
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
	}
	
	//Method to set up the driver and initiate browser
	public void setupDriver(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			//FlipkartPageEvent flipkartPageEvent=new FlipkartPageEvent(driver);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",  System.getProperty("user.dir")+"\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
	}
	
	

}
