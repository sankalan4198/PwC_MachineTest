package main.java.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.java.BaseTest;

public class SearchPageElements extends BaseTest {
	
	public static final WebElement iPhone=driver.findElement(By.className("_4rR01T"));
	public static final WebElement iPhone_Price=driver.findElement(By.xpath("//div[text()='APPLE iPhone 13 (Blue, 128 GB)']//following::div[@class='_30jeq3 _1_WHN1']"));
	public static final WebElement price=driver.findElement(By.className("_30jeq3 _16Jk6d"));
}
