package main.java.pageEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import main.java.pageObject.HomePageElements;



import main.java.utils.Constants;
import test.java.BaseTest;


public class FlipkartPageEvent extends BaseTest {
	
	HomePageElements homePageElements= new HomePageElements();
	 

	public FlipkartPageEvent(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	
	public void verifyHomePage()
	{
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, Constants.url, "User successfully landed into HomePage");
		logger.log(Status.PASS, "User successfully landed into Flipkart ");
		homePageElements.popUp.click();
	}
	
	public void searchOperation() throws Exception
	{
		homePageElements.searchBar.sendKeys("mobile");
		Thread.sleep(3000);
		homePageElements.searchButton.click();
		Thread.sleep(3000);
	}
	
	public void verifySearchPage()
	{
		if(homePageElements.Filters_text.isDisplayed())
		{
			logger.log(Status.PASS, "User is on mobile Search page");
		}
		else
		{
			logger.log(Status.FAIL, "User is unable to redirect on mobile Search page");
		}
	}
}
