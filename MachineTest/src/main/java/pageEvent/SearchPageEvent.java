package main.java.pageEvent;

import java.util.Iterator;
import java.util.Set;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import main.java.pageObject.SearchPageElements;
import test.java.BaseTest;

public class SearchPageEvent  extends BaseTest{
	SearchPageElements searchPageElements=new SearchPageElements();
	String price1, price2;
	
	//Method to scroll to Iphone
	public void scrollToiPhone()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].scrollIntoView()", searchPageElements.iPhone);
		price1= searchPageElements.iPhone_Price.getText();
		searchPageElements.iPhone.click();
	}
	 
	//Moving to 2nd window
	public void differentWindow()
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it= window.iterator();
		String parent_window=it.next();
		String child_window=it.next();
		driver.switchTo().window(child_window);
		logger.log(Status.PASS, "User is on different window");
	}

	//Method to compare price
	public void comparePrice()
	{
		price2=searchPageElements.price.getText();
		
		Assert.assertEquals(price1, price2);
	}
}
