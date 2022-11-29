package main.java.pageEvent;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import main.java.utils.Constants;

public class FlipkartAutomation {
	
	public static WebDriver driver;
	private static final String popUp="//button[@class='_2KpZ6l _2doB4z']";
	private static final String searchBar= "_3704LK";
	private static final String searchButton="//button[@class='L0Z3Pu']";
	private static final String iPhone="//div[text()='APPLE iPhone 13 (Blue, 128 GB)']//ancestor::a";
	private static final String iPhonePrice="//div[text()='APPLE iPhone 13 (Blue, 128 GB)']//following::div[@class='_30jeq3 _1_WHN1']";
	public static final String price="_30jeq3 _16Jk6d";
	//private static final WebElement Filters_text=driver.findElement(By.xpath("//span[text()='Filters']"));*/
	String price1,price2;
	public void setupDriver()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	public void beforeMethoMethod()
	{
		setupDriver();
		driver.manage().window().maximize();
	}
	
	
	
	
	public void urlLaunch()
	{
		driver.navigate().to(Constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath(popUp)).click();
	}
		
	
	public void searchMobile() throws Exception
	{
		driver.findElement(By.className(searchBar)).sendKeys("Mobile");
		Thread.sleep(2000);
		driver.findElement(By.xpath(searchButton)).click();
		
		
	}
	
	public void scrollToIphone() throws Exception
	{
		WebElement iPhone_black=driver.findElement(By.xpath(iPhone));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iPhone_black);
		
		price1 = driver.findElement(By.xpath(iPhonePrice)).getText();
		System.out.println(price1);
		Thread.sleep(500); 
		iPhone_black.click();
	}
	
	public void getPrice()
	{
		String parent=driver.getWindowHandle();
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it= window.iterator();
		while(it.hasNext())
		{
			String childWindow=it.next();
		if(!parent.equals(childWindow))
		{
			driver.switchTo().window(childWindow);
		}
		}
		price2=driver.findElement(By.className(price)).getText();
		System.out.println(price2);
		Assert.assertEquals(price1,price2);
	}
	
	
		
}


